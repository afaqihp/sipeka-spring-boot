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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Faqih
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    //Menambahkan user baru
    @PostMapping(value="users/addNew")
    public RedirectView addNew(User user, RedirectAttributes redir) {
            userService.save(user);	
            RedirectView  redirectView= new RedirectView("/login",true);
            redir.addFlashAttribute("message",
                    "You successfully registered! You can now login");
            return redirectView;				
    }	
    
    
}
