package com.koshenya.koshenyablog.controllers;

import com.koshenya.koshenyablog.data.dao.BlogDAO;
import com.koshenya.koshenyablog.data.dto.AdminPicturesDTO;
import com.koshenya.koshenyablog.data.persistance.Image;
import com.koshenya.koshenyablog.data.persistance.Message;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.InputStream;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;

/**
 * Created by Admin on 1/20/2016.
 */

@Controller
@RequestMapping(value = "/admin", method = RequestMethod.GET)
@MultipartConfig
@EnableWebMvc
public class AdminController {

    @Autowired
    private BlogDAO blogDAO;

    @RequestMapping("/")
    public ModelAndView getAdminView() {
        ModelAndView model = new ModelAndView("admin");
        model.addObject("user", getPrincipal());
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

    @RequestMapping(value = "/savePostServlet", method = RequestMethod.POST)
    public void savePost(
            HttpServletRequest request, HttpServletResponse response,
            @RequestParam(name = "postHeader") String postHeader,
            @RequestParam(name = "postText") String postText,
            @RequestParam(name = "picture") CommonsMultipartFile picture) throws Exception {

        request.setCharacterEncoding("UTF-8");
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

        message.setHeader(postHeader);
        message.setText(postText);

        if (request.getParameter("isVisible") != null)
            message.setVisible(Boolean.TRUE);

        if (picture != null) {
            if (picture.getSize() > 0)
                message.setPicture(IOUtils.toByteArray(picture.getInputStream()));
            else {
                Message oldMessage = blogDAO.getMessage(id);
                if (oldMessage != null)
                    message.setPicture(oldMessage.getPicture());
            }
        }

        blogDAO.saveMessage(message);

        response.sendRedirect("adminPosts");
    }


    @RequestMapping(value = "/addImageServlet", method = RequestMethod.POST)
    public void addImage(
            HttpServletRequest request, HttpServletResponse response,
            @RequestParam(name="dialogPicture") CommonsMultipartFile dialogPicture) throws Exception {
        if (dialogPicture != null && dialogPicture.getSize() > 0) {

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
            image.setPicture(IOUtils.toByteArray(dialogPicture.getInputStream()));

            blogDAO.saveImage(image);
        }

        response.sendRedirect("adminPictures");
    }

    @RequestMapping(value = "/adminPosts/deletePost/{postId}", method = RequestMethod.POST)
    public ResponseEntity<String> deletePost(@PathVariable("postId") int postId) {
        blogDAO.deletePosts(Arrays.asList(new Integer[]{postId}));
        return new ResponseEntity<String>(HttpStatus.OK);
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    private String getPrincipal(){
        String userName = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof UserDetails) {
                userName = ((UserDetails) principal).getUsername();
            } else {
                userName = principal.toString();
            }
        }
        return userName;
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

}
