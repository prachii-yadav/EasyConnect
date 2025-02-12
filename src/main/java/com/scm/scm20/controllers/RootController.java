package com.scm.scm20.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.scm.scm20.entities.User;
import com.scm.scm20.helpers.Helper;
import com.scm.scm20.services.UserService;

@ControllerAdvice
public class RootController {

    private Logger logger = LoggerFactory.getLogger(RootController.class);

    @Autowired
    private UserService userService;

    @ModelAttribute
    public void addLoggedInUserInformation(Model model, Authentication authentication) {
        if (authentication == null) {
            return;
        }
        System.out.println("Adding logged in user information to the model");
        String username = Helper.getEmailOfLoggedInUser(authentication);
        logger.info("User logged in: {}", username);

        // fetch data from database: get user from db
        User user = userService.getUserByEmail(username);
        System.out.println(user);
        System.out.println(user.getName());
        System.out.println(user.getEmail());

        model.addAttribute("loggedInUser", user);
    }
}
