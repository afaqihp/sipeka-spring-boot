/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.faqih.sipeka.services;

import com.faqih.sipeka.models.Clinic;
import com.faqih.sipeka.repositories.ClinicRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faqih
 */
@Service
public class ClinicService {
    @Autowired
    private ClinicRepository clinicRepository;
    
    //Mendapatkan semua daftar klinik
    public List<Clinic> getClinics() {
        return clinicRepository.findAll();
    }
}
