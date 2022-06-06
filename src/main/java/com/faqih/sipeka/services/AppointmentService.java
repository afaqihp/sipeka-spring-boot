/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.faqih.sipeka.services;

import com.faqih.sipeka.models.Appointment;
import com.faqih.sipeka.repositories.AppointmentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Faqih
 */
@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    
    //Mendapatkan semua appointment yang ada
    public List<Appointment> getAppointments() {
        return appointmentRepository.findAll();
    }
    
    //Mendapatkan appointment dari 1 user
    public List<Appointment> getUserAppointments(int userid ) {
        return appointmentRepository.findByUserid(userid);
    }
    
    //Menyimpan appointment
    public void save(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
    
    //Mendapatkan appointment by id
    public Appointment get(int id) {
        return appointmentRepository.findById(id).get();
    }
    
    //Menghapus appointment by id
    public void delete(int id) {
        appointmentRepository.deleteById(id);
    }
    
    //Mendapatkan semua appointment by keyword
    public List<Appointment> findByKeyword(String keyword) {
        return appointmentRepository.findByKeyword(keyword);
    }
}
