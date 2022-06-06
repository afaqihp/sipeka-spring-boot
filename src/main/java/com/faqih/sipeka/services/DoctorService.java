/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.faqih.sipeka.services;

import com.faqih.sipeka.models.Doctor;
import com.faqih.sipeka.repositories.DoctorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faqih
 */
@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;
    
    //Mendapatkan semua daftar dokter
    public List<Doctor> getDoctors() {
        return doctorRepository.findAll();
    }
    
    //Menyimpan data dokter
    public void save(Doctor doctor) {
        doctorRepository.save(doctor);
    }
    
    //Mendapatkan dokter by id
    public Doctor get(int id) {
        return doctorRepository.findById(id).get();
    }
    
    //Menghapus dokter by id
    public void delete(int id) {
        doctorRepository.deleteById(id);
    }
    
    //Mendapatkan dokter by keyword
     public List<Doctor> findByKeyword(String keyword) {
        return doctorRepository.findByKeyword(keyword);
    }
    
}
