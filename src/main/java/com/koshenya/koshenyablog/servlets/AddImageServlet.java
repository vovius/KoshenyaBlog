package com.koshenya.koshenyablog.servlets;

import com.koshenya.koshenyablog.data.BlogDAO;
import com.koshenya.koshenyablog.data.Image;
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
import java.io.InputStream;
import java.sql.Timestamp;

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

        Part filePart = request.getPart("picture");
        if (filePart != null && filePart.getSize() > 0) {
            Image image = new Image();
            image.setCreated(new Timestamp(System.currentTimeMillis()));
            image.setDescription((String) request.getParameter("imageDescription"));
            image.setPicture(IOUtils.toByteArray(filePart.getInputStream()));

            blogDAO.saveImage(image);
        }

        //request.getRequestDispatcher("adminPictures").forward(request,response);
        response.sendRedirect("adminPictures");
    }
}
