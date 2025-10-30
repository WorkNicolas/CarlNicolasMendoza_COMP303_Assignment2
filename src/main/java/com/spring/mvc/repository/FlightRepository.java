/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

/**
 * Flight repository interface for CRUD operations on Flight entities.
 * 
 * @author nico
 * @version 0.1
 * @since 2025-10-30
 */
package com.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.mvc.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
