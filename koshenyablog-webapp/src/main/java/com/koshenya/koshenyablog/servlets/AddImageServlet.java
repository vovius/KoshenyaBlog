package com.koshenya.koshenyablog.servlets;

import com.koshenya.koshenyablog.data.dao.BlogDAO;
import com.koshenya.koshenyablog.data.persistance.Image;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@WebServlet("/admin/addImageServlet")
@MultipartConfig
public class AddImageServlet extends HttpServlet {

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
        Part filePart = request.getPart("dialogPicture");
        if (filePart != null && filePart.getSize() > 0) {

            Image image = new Image();
            int id = Integer.valueOf(request.getParameter("dialogImageId").isEmpty() ? "0" : request.getParameter("dialogImageId"));
            image.setId(id);

            if (id == 0)
                image.setCreated(new Timestamp(System.currentTimeMillis()));
            else {
                try {
                    image.setCreated(new Timestamp(new SimpleDateFormat("dd-mm-yyyy hh:mm").parse(request.getParameter("dialogImageCreated")).getTime()));
                }catch(Exception e) {
                    e.printStackTrace();
                }
            }

            image.setDescription((String) request.getParameter("dialogImageDescription"));
            image.setPicture(IOUtils.toByteArray(filePart.getInputStream()));

            blogDAO.saveImage(image);
        }

        //request.getRequestDispatcher("adminPictures").forward(request,response);
        response.sendRedirect("adminPictures");
    }
}
