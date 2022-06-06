/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.faqih.sipeka.services;

import com.faqih.sipeka.models.User;
import com.faqih.sipeka.models.UserPrincipal;
import com.faqih.sipeka.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faqih
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired 
    UserRepository userRepository;
    
    //Memuat user by username
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user  = userRepository.findByUsername(username); 
        
        if (user == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        
        return new UserPrincipal(user);
    }  
} 
