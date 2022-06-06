/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.faqih.sipeka.controllers;

import com.faqih.sipeka.models.Appointment;
import com.faqih.sipeka.models.User;
import com.faqih.sipeka.models.UserPrincipal;
import com.faqih.sipeka.services.AppointmentService;
import com.faqih.sipeka.services.UserService;
import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Faqih
 */
@Controller
public class ClinicController {
    
    @Autowired
    private AppointmentService appointmentService;
    
    @Autowired
    private UserService userService;
    
    //Masuk ke halaman klinik 
    @GetMapping("/clinic")
    public String getClinic(Model model, Principal principal) {
        String username = principal.getName();
        int id = userService.getUser(username).getId();
        List<Appointment> appointmentList = appointmentService.getUserAppointments(id);
        model.addAttribute("appointment", appointmentList);
        
        return "klinik";
    }
    
    //Daftar semua appointment yang masuk
    @GetMapping("/clinic/viewAll")
    public String getAppointments(Model model, String keyword) {
        
        if (keyword != null) {
            model.addAttribute("appointment", appointmentService.findByKeyword(keyword));
        } else {
            List<Appointment> appointmentList = appointmentService.getAppointments();
            model.addAttribute("appointment", appointmentList);
        }
        return "klinik_manage";
    }
       
    //Menyimpan appointment
    @RequestMapping(value = "/clinic/saveAppointment", method = RequestMethod.POST)
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment) {        
        appointmentService.save(appointment);
        return "redirect:/clinic";
    }
    
    //Mengedit appointment
    @RequestMapping("/clinic/edit/{id}")
    public ModelAndView showAppointmentEditPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("klinik_edit");
        Appointment appointment = appointmentService.get(id);
        mav.addObject("appointment", appointment);

        return mav;
    }
    
    //Menghapus appointment
    @RequestMapping("/clinic/delete/{id}")
    public String deleteAppointment(@PathVariable(name = "id") int id) {
        appointmentService.delete(id);
        return "redirect:/clinic";       
    }
    
}
