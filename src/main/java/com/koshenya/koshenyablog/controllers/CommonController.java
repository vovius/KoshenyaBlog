package com.koshenya.koshenyablog.controllers;

import com.koshenya.koshenyablog.data.dao.BlogDAO;
import com.koshenya.koshenyablog.data.persistance.Image;
import com.koshenya.koshenyablog.data.persistance.Message;
import com.koshenya.koshenyablog.util.BlogUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by Admin on 1/13/2016.
 */

@Controller
public class CommonController {

    @Autowired
    private BlogDAO blogDAO;

    @RequestMapping(value = "**/getPostFile/{postId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<InputStreamResource> getPostFile(@PathVariable("postId") int postId, HttpServletResponse response) throws SQLException, IOException {
        Message message = blogDAO.getMessage(postId);
        if (message == null)
            return null;

        return BlogUtils.getImageStreamFromBytesToResponse(message.getPicture());
    }

    @RequestMapping(value = "**/getImage/{imageId}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<InputStreamResource> getImage(@PathVariable("imageId") int imageId, HttpServletResponse response) throws SQLException, IOException {
        Image image = blogDAO.getImage(imageId);
        if (image == null)
            return null;

        return BlogUtils.getImageStreamFromBytesToResponse(image.getPicture());
    }

}
