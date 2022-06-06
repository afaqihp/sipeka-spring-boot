/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.faqih.sipeka.repositories;

import com.faqih.sipeka.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Faqih
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //Mendapatkan user by username
    User findByUsername(String username);

}
