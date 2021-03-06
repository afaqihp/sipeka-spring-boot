/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.faqih.sipeka.repositories;

import com.faqih.sipeka.models.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Faqih
 */
@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Integer> {
    
}
