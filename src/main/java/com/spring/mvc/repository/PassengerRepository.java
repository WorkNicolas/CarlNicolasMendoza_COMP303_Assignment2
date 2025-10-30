/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

/**
 * Passenger repository interface for CRUD operations on Passenger entities.
 * 
 * @author nico
 * @version 0.1
 * @since 2025-10-30
 */
package com.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.mvc.model.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    Passenger findByEmail(String email);
}
