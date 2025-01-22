package com.scm.scm20.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    // home

    @RequestMapping("/home")
    public String home() {
        System.out.println("Home Page Handler");
        return "home";
    }

    // about

    @RequestMapping("/about")
    public String aboutPage() {
        System.out.println("About page loading");
        return "about";
    }

    // services

    @RequestMapping("/services")
    public String servicesPage() {
        System.out.println("Services page loading");
        return "services";
    }

    // contact

    @GetMapping("/contact")
    public String contact() {
        return new String("contact");
    }

    // login

    @GetMapping("/login")
    public String login() {
        return new String("login");
    }

    // register

    @GetMapping("/register")
    public String register() {
        return "register";
    }

}
