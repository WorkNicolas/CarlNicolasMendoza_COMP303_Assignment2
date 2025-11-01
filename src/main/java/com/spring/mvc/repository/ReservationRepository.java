/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

/**
 * Reservation repository interface for CRUD operations on Reservation entities.
 * 
 * @author nico
 * @version 0.1
 * @since 2025-10-30
 */
package com.spring.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.mvc.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByPassenger_PassengerId(Long passengerId);
}
