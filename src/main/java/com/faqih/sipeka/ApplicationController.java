/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.faqih.sipeka;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Faqih
 */
@Controller
public class ApplicationController {
    
    //Kembali ke home
    @GetMapping("/index")
    public String goHome() { 
        return "index";
    }
    
    //Masuk ke halaman login
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    //Proses logout
    @GetMapping("/logout")
    public String logout() {
        return "login";
    }
    
    //Register
    @GetMapping("/register")
    public String register() {
        return "register";
    }
    
    //Access denied ketika tidak punya otorisasi
    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "access_denied";
    }
}
