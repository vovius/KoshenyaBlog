package com.koshenya.koshenyablog.controllers;

import com.koshenya.koshenyablog.data.dao.BlogDAO;
import com.koshenya.koshenyablog.data.persistance.Comment;
import com.koshenya.koshenyablog.data.persistance.Image;
import com.koshenya.koshenyablog.data.persistance.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
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
import java.sql.Timestamp;
import java.util.Date;

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

    @RequestMapping(value = "blogPost/addComment", method = RequestMethod.POST)
    public void addPostComment(
            @RequestParam(name="name") String name,
            @RequestParam(name="email") String email,
            @RequestParam(name="comment") String text,
            @RequestParam(name="postId") int postId,
            @RequestParam(name="parentCommentId") Integer parentCommentId,
            HttpServletResponse response
    ) throws IOException {

        Message message = blogDAO.getMessage(postId);
        Comment parentComment = parentCommentId != null ? message.getCommentById(parentCommentId) : null;

        Comment comment = new Comment.Builder()
                .message(message)
                .parentComment(parentComment)
                .created(new Timestamp(new Date().getTime()))
                .name(name)
                .email(email)
                .text(text)
                .build();

        blogDAO.saveComment(comment);

        response.sendRedirect(String.valueOf(postId).concat("#c" + comment.getId()));
    }

}
