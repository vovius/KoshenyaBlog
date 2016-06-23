package com.koshenya.koshenyablog.controllers;

import com.koshenya.koshenyablog.data.BlogDAO;
import com.koshenya.koshenyablog.data.Image;
import com.koshenya.koshenyablog.data.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * Created by Admin on 1/20/2016.
 */

@Controller
@RequestMapping("/admin")
@MultipartConfig
@EnableWebMvc
public class AdminController {

    @Autowired
    private BlogDAO blogDAO;

    @RequestMapping("/")
    public ModelAndView getAdminView() {
        ModelAndView model = new ModelAndView("admin");
        return model;
    }

    @RequestMapping("/adminPosts")
    public ModelAndView getAdminPostsView() {
        ModelAndView model = new ModelAndView("adminPosts");
        model.addObject("messages", blogDAO.getMessages());
        return model;
    }

    @RequestMapping("/adminPictures")
    public ModelAndView getAdminPicturesView() {
        ModelAndView model = new ModelAndView("adminPictures");
        model.addObject("images", blogDAO.getImages());
        return model;
    }

    @RequestMapping(value = "/getPostFile/{postId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<InputStreamResource> getPostFile(@PathVariable("postId") int postId, HttpServletResponse response) throws SQLException, IOException {
        Message message = blogDAO.getMessage(postId);
        if (message == null)
            return null;
        InputStream picture = new ByteArrayInputStream(message.getPicture());
        if (picture == null)
            return null;
        String mimeType = "application/octet-stream";

        return ResponseEntity.ok()
                .contentLength(picture.available())
                .contentType(MediaType.parseMediaType(mimeType))
                .body(new InputStreamResource(picture));

    }

    @RequestMapping(value = "/getImage/{imageId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<InputStreamResource> getImage(@PathVariable("imageId") int imageId, HttpServletResponse response) throws SQLException, IOException {
        Image image = blogDAO.getImage(imageId);
        if (image == null)
            return null;
        InputStream picture = new ByteArrayInputStream(image.getPicture());
        if (picture == null)
            return null;
        String mimeType = "application/octet-stream";

        return ResponseEntity.ok()
                .contentLength(picture.available())
                .contentType(MediaType.parseMediaType(mimeType))
                .body(new InputStreamResource(picture));

    }
}
