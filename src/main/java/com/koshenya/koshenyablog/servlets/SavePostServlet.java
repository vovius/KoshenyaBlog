package com.koshenya.koshenyablog.servlets;

import com.koshenya.koshenyablog.data.BlogDAO;
import com.koshenya.koshenyablog.data.Message;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by Admin on 1/19/2016.
 */

@WebServlet("/admin/savePostServlet")
@MultipartConfig
public class SavePostServlet extends HttpServlet {

    @Autowired
    public BlogDAO blogDAO;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        WebApplicationContext springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
        final AutowireCapableBeanFactory beanFactory = springContext.getAutowireCapableBeanFactory();
        beanFactory.autowireBean(this);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Message message = new Message();
        int id = Integer.valueOf(request.getParameter("postId").isEmpty() ? "0" : request.getParameter("postId"));
        message.setId(id);
        if (id == 0)
            message.setCreated(new Timestamp(System.currentTimeMillis()));
        else {
            try {
                message.setCreated(new Timestamp(new SimpleDateFormat("dd-mm-yyyy hh:mm").parse(request.getParameter("created")).getTime()));
            }catch(Exception e) {
                e.printStackTrace();
            }
            message.setChanged(new Timestamp(System.currentTimeMillis()));
        }

        message.setHeader((String)request.getParameter("postHeader"));
        message.setText((String)request.getParameter("postText"));

        InputStream fileStream = null;
        Part filePart = request.getPart("picture");
        if (filePart != null) {
            if (filePart.getSize() > 0)
                message.setPicture(IOUtils.toByteArray(filePart.getInputStream()));
            else {
                Message oldMessage = blogDAO.getMessage(id);
                if (oldMessage != null)
                    message.setPicture(oldMessage.getPicture());
            }
        }

        blogDAO.saveMessage(message);

        //request.getRequestDispatcher("").forward(request,response);
        response.sendRedirect("adminPosts");
    }
}
