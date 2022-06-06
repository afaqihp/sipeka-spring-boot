/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.faqih.sipeka.services;

import com.faqih.sipeka.models.User;
import com.faqih.sipeka.repositories.UserRepository;
import com.faqih.sipeka.security.model.Role;
import com.faqih.sipeka.security.repositories.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faqih
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder encoder;
    @Autowired
    private RoleRepository roleRepository;
    
    //Menyimpan user
    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }
    
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }
   
    public void registerDefaultUser(User user) {
        Role role = roleRepository.findById(2);
        user.addRole(role);
        
        userRepository.save(user);
    }
}
