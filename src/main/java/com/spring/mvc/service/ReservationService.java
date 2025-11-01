/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

/**
 * Reservation service class to handle business logic for reservations.
 * - findAll(): Retrieves all reservations
 * - findById(Long id): Finds a reservation by ID
 * - save(Reservation reservation): Saves a reservation
 * - delete(Long id): Deletes a reservation by ID
 * 
 * @author nico
 * @version 0.1
 * @since 2025-10-30
 */
package com.spring.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.mvc.model.Reservation;
import com.spring.mvc.repository.ReservationRepository;

@Service
public class ReservationService {

    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
	this.repository = repository;
    }

    public List<Reservation> findAll() {
	return repository.findAll();
    }

    public Reservation findById(Long id) {
	return repository.findById(id).orElse(null);
    }

    public Reservation save(Reservation reservation) {
	return repository.save(reservation);
    }

    public void delete(Long id) {
	repository.deleteById(id);
    }

    public List<Reservation> findByPassengerId(Long passengerId) {
	return repository.findByPassenger_PassengerId(passengerId);
    }

}
