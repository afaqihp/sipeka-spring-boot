/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.faqih.sipeka.controllers;

import com.faqih.sipeka.models.Clinic;
import com.faqih.sipeka.models.Doctor;
import com.faqih.sipeka.services.ClinicService;
import com.faqih.sipeka.services.DoctorService;
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
public class DoctorController {
    
    @Autowired
    private DoctorService doctorService;
    @Autowired
    private ClinicService clinicService;
    
    //Mendapatkan daftar dokter
    @GetMapping("/doctor")
    public String getDoctors(Model model, String keyword) {
        if (keyword != null) {
            model.addAttribute("doctor", doctorService.findByKeyword(keyword));
        } else {
            List<Doctor> doctorList = doctorService.getDoctors();                     
            model.addAttribute("doctor", doctorList);
        }
        return "doctor";
    }
    
    //Mendapatkan daftar klinik
    @GetMapping("/doctor/add") 
    public String getClinics(Model model) {
        List<Clinic> clinicList =  clinicService.getClinics();
        model.addAttribute("clinic", clinicList);
        
        return "doctor_add";
    }
    
    //Menambahkan dokter baru
    @RequestMapping("/doctor/add")
    public String addDoctor(Model model) {
        Doctor doctor = new Doctor();
        model.addAttribute("doctor", doctor);             
        return "doctor_add";
    }
    
    //Menyimpan dokter
    @RequestMapping(value = "/doctor/save", method = RequestMethod.POST)
    public String saveDoctor(@ModelAttribute("doctor") Doctor doctor) {        
        doctorService.save(doctor);
        return "redirect:/doctor";
    }
    
    //Edit dokter
    @RequestMapping("/doctor/edit/{id}")
    public ModelAndView showDoctorEditPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("doctor_edit");
        Doctor doctor = doctorService.get(id);
        mav.addObject("doctor", doctor);

        return mav;
    }
    
    //Menghapus dokter
    @RequestMapping("/doctor/delete/{id}")
    public String deleteDoctor(@PathVariable(name = "id") int id) {
        doctorService.delete(id);
        return "redirect:/doctor";       
    }

}
