package com.koshenya.koshenyablog.controllers;

import com.koshenya.koshenyablog.data.dao.BlogDAO;
import com.koshenya.koshenyablog.data.persistance.Image;
import com.koshenya.koshenyablog.data.persistance.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogDAO blogDAO;

    @RequestMapping("/")
    public ModelAndView getCommonView() {
        ModelAndView model = new ModelAndView("blogPosts");
        model.addObject("messages", blogDAO.getMessages());
        return model;
    }

    @RequestMapping(value = "blogPost/{postId}", method = RequestMethod.GET)
    public ModelAndView getPostFullView(@PathVariable("postId") int postId) {
        ModelAndView model = new ModelAndView("blogPost");
        model.addObject("message", blogDAO.getMessage(postId));
        return model;
    }

}
