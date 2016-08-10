package com.koshenya.koshenyablog.controllers;

import com.koshenya.koshenyablog.data.dao.BlogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by sony on 7/7/2016.
 */

@Controller
@RequestMapping("/blogPortfolio")
public class PortfolioController {

    @Autowired
    private BlogDAO blogDAO;

    @RequestMapping("/")
    public ModelAndView getMainView() {
        ModelAndView view = new ModelAndView("blogPortfolio");
        view.addObject("images", blogDAO.getImages());
        return view;
    }
}
