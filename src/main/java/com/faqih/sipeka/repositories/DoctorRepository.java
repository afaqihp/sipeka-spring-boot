/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.faqih.sipeka.repositories;

import com.faqih.sipeka.models.Doctor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Faqih
 */
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    
    
    @Query(value = "SELECT * FROM doctor d WHERE d.name like %:keyword% OR d.contact like %:keyword% OR "
            + "d.specialty like %:keyword%", nativeQuery = true)
    List<Doctor> findByKeyword(@Param("keyword") String keyword);
    
}
