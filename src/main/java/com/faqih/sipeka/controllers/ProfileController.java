/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.faqih.sipeka.controllers;

import com.faqih.sipeka.models.User;
import com.faqih.sipeka.services.UserService;
import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Faqih
 */
@Controller
public class ProfileController {
    @Autowired
    private UserService userService;
    
    public String profile() {
        return "profile";
    }
    
    @GetMapping("/profile")
    public String getUser(Model model, Principal principal) {
        String username = principal.getName();
        User user = userService.getUser(username);
        model.addAttribute("user", user);
        
        return "profile";
    }
    
    @RequestMapping(value = "/profile/save", method = RequestMethod.POST)
    public String saveProfile(@ModelAttribute("user") User user) {        
        userService.save(user);
        
        return "redirect:/profile";
    }
}
