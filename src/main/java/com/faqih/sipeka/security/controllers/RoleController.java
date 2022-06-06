/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.faqih.sipeka.security.controllers;

import com.faqih.sipeka.security.model.Role;
import com.faqih.sipeka.security.services.RoleService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Faqih
 */
@Controller
public class RoleController {
    @Autowired
    private RoleService roleService;
    
    //Get All Roles
    @GetMapping("roles")
    public String findAll(Model model) {
        model.addAttribute("roles", roleService.findAll());
        return "role";
        
    }
    
    @RequestMapping("/roles/findById")
    @ResponseBody
    public Role findById(int id) {
        return roleService.findById(id);
    }
    
    //Add Role
    @PostMapping(value = "roles/addNew")
    public String addNew(Role role) {
        roleService.save(role);
        return "redirect:/roles";
    }
    
    @RequestMapping(value="roles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Role role) {
        roleService.save(role);
        return "redirect:/roles";
    }
    
    @RequestMapping(value="roles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id) {
        roleService.delete(id);
        return "redirect:/roles";
    }
    
    
}
