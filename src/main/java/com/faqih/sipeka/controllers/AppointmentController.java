/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.faqih.sipeka.controllers;

import com.faqih.sipeka.models.Appointment;
import com.faqih.sipeka.services.AppointmentService;
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
public class AppointmentController {
//     @Autowired
//    private AppointmentService appointmentService;
//    
//    @GetMapping("/clinic")
//    public String getAppointments(Model model) {
//        List<Appointment> appointmentList = appointmentService.getAppointments();
//        model.addAttribute("appointment", appointmentList);
//        return "klinik";
//    }
//    
// 
//    @RequestMapping("/clinic/addAppointment")
//    public String addAppointment(Model model) {
//        Appointment appointment = new Appointment();
//        model.addAttribute("appointment", appointment);
//        return "klinik_add";
//    }
//    
//    @RequestMapping(value = "/clinic/save", method = RequestMethod.POST)
//    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment) {        
//        appointmentService.save(appointment);
//        return "redirect:/klinik";
//    }
//    
//    @RequestMapping("/clinic/editAppointment/{id}")
//    public ModelAndView showAppointmentEditPage(@PathVariable(name = "id") int id) {
//        ModelAndView mav = new ModelAndView("klinik_edit");
//        Appointment appointment = appointmentService.get(id);
//        mav.addObject("appointment", appointment);
//
//        return mav;
//    }
//    
//    @RequestMapping("/clinic/deleteAppointment/{id}")
//    public String deleteSAppointment(@PathVariable(name = "id") int id) {
//        appointmentService.delete(id);
//        return "redirect:/klinik";       
//    }
}
