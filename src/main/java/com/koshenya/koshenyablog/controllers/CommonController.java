package com.koshenya.koshenyablog.controllers;

import com.koshenya.koshenyablog.data.dao.BlogDAO;
import com.koshenya.koshenyablog.data.persistance.Image;
import com.koshenya.koshenyablog.data.persistance.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

/**
 * Created by Admin on 1/13/2016.
 */

@Controller
@RequestMapping("/blog")
public class CommonController {

    @Autowired
    private BlogDAO blogDAO;

    @RequestMapping("/")
    public ModelAndView getCommonView() {
        ModelAndView model = new ModelAndView("blogPosts");
        model.addObject("messages", blogDAO.getMessages());
        return model;
    }

    @RequestMapping(value = "/blogPost/{postId}", method = RequestMethod.GET)
    public ModelAndView getPostFullView(@PathVariable("postId") int postId) {
        ModelAndView model = new ModelAndView("blogPost");
        model.addObject("message", blogDAO.getMessage(postId));
        return model;
    }

    @RequestMapping(value = "**/getPostFile/{postId}", method = RequestMethod.GET)
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

    @RequestMapping(value = "**/getImage/{imageId}", method = RequestMethod.GET)
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
