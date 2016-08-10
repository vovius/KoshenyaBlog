package com.koshenya.koshenyablog.controllers;

import com.koshenya.koshenyablog.data.dao.BlogDAO;
import com.koshenya.koshenyablog.data.dto.AdminPicturesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.annotation.MultipartConfig;

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

    @RequestMapping(value = "/adminPictures/deleteImages", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> deleteImages(@RequestBody AdminPicturesDTO dto) {
        blogDAO.deleteImages(dto.getImageIds());
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value = "/postPreview/{postId}", method = RequestMethod.GET)
    public ModelAndView getPostFullView(@PathVariable("postId") int postId) {
        ModelAndView model = new ModelAndView("blogPost");
        model.addObject("message", blogDAO.getMessage(postId));
        return model;
    }

}
