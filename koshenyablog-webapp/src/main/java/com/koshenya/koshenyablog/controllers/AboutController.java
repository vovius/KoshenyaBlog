package com.koshenya.koshenyablog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sony on 8/27/2016.
 */
@Controller
@RequestMapping("/blogAbout")
public class AboutController {

    @RequestMapping("/")
    public ModelAndView getAboutView() {
        ModelAndView modelAndView = new ModelAndView("blogAbout");
        return modelAndView;
    }
}
