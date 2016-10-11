package com.eshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by User on 11.10.2016.
 */
@Controller
public class LogInOutController {
    @RequestMapping(value="/login", method= RequestMethod.GET)
    public ModelAndView loginPage(
            ModelAndView modelAndView,
            @RequestParam(value="error",required = false) String error,
            @RequestParam(value="logout", required = false) String logout){

        if(error != null){
            modelAndView.addObject("error", "Invalid username and password");
        }
        if(logout!=null){
            modelAndView.addObject("msg","You've been logged out successfully!");
        }
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
