/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

/**
 * Flight service class for managing flight operations.
 * - findAll(): Retrieves all flights
 * - findById(Long id): Finds a flight by ID
 * - save(Flight flight): Saves a flight
 * - delete(Long id): Deletes a flight by ID
 * 
 * @author nico
 * @version 0.1
 * @since 2025-10-30
 */
package com.spring.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.mvc.model.Flight;
import com.spring.mvc.repository.FlightRepository;

@Service
public class FlightService {

    private final FlightRepository repository;

    public FlightService(FlightRepository repository) {
	this.repository = repository;
    }

    public List<Flight> findAll() {
	return repository.findAll();
    }

    public Flight findById(Long id) {
	return repository.findById(id).orElse(null);
    }

    public Flight save(Flight flight) {
	return repository.save(flight);
    }

    public void delete(Long id) {
	repository.deleteById(id);
    }
}

// ========================================
