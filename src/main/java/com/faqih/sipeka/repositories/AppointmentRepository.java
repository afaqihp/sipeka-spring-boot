/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.faqih.sipeka.repositories;

import com.faqih.sipeka.models.Appointment;
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
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
    //Mendapatkan appointment by user id
    List<Appointment> findByUserid(int userid);
    
    @Query(value = "SELECT * FROM appointment a WHERE a.id like %:keyword% OR a.userid like %:keyword% OR "
            + "a.details like %:keyword% OR a.schedule like %:keyword%", nativeQuery = true)
    List<Appointment> findByKeyword(@Param("keyword") String keyword);
}
