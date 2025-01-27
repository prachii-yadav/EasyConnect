package com.scm.scm20.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.scm20.entities.User;
import com.scm.scm20.forms.UserForm;
import com.scm.scm20.helpers.Message;
import com.scm.scm20.helpers.MessageType;
import com.scm.scm20.services.UserService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

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
    public String register(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "register";
    }

    // processing register
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@ModelAttribute UserForm userForm,HttpSession session) {
        System.out.println("Processing registration");
        // fetch form data
        System.out.println(userForm);
        // validate form data
        // save to database

        // user service
        // UserForm-->User

        // User user = User.builder()
        //         .name(userForm.getName())
        //         .email(userForm.getEmail())
        //         .password(userForm.getPassword())
        //         .about(userForm.getAbout())
        //         .profilePic("@{'images/profile.png'}")
        //         .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("@{'images/profile.png'}");
        
        User savedUser = userService.saveUser(user);

        System.out.println("user saved");

        // message = 'Registration Successful'
        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();
        session.setAttribute("message","message");

        // redirect to login page
        return "redirect:/register";
    }

}
