/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.faqih.sipeka.security.repositories;

import com.faqih.sipeka.security.model.Role;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Faqih
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
 
    @Query(
        value = "SELECT * FROM role WHERE id NOT IN (SELECT role_id FROM user_role WHERE user_id = ?1)", 
        nativeQuery = true
    )
    Set<Role> getUserNotRoles(Integer userId);
    
    Role findById(int id);
   
    Role findByDescription(String desc);
}
