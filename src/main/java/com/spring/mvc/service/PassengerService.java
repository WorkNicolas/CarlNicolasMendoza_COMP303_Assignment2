/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

/**
 * Passenger service class for managing Passenger entities.
 * - findById(Long id): Finds a passenger by ID
 * - findByEmail(String email): Finds a passenger by email
 * - save(Passenger passenger): Saves a passenger
 * - register(Passenger passenger): Registers a new passenger with encrypted password
 * 
 * @author nico
 * @version 0.1
 * @since 2025-10-30
 */
package com.spring.mvc.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.mvc.model.Passenger;
import com.spring.mvc.repository.PassengerRepository;

@Service
public class PassengerService {

    private final PassengerRepository repository;
    private final PasswordEncoder passwordEncoder;

    public PassengerService(PassengerRepository repository, PasswordEncoder passwordEncoder) {
	this.repository = repository;
	this.passwordEncoder = passwordEncoder;
    }

    public List<Passenger> findAll() {
	return repository.findAll();
    }

    public Passenger findById(Long id) {
	return repository.findById(id).orElse(null);
    }

    public Passenger findByEmail(String email) {
	return repository.findByEmail(email);
    }

    public Passenger save(Passenger passenger) {
	return repository.save(passenger);
    }

    public Passenger register(Passenger passenger) {
	// Encrypt password before saving
	passenger.setPassword(passwordEncoder.encode(passenger.getPassword()));
	return repository.save(passenger);
    }

    public boolean authenticate(String email, String rawPassword) {
	Passenger passenger = findByEmail(email);
	if (passenger == null) {
	    return false;
	}
	return passwordEncoder.matches(rawPassword, passenger.getPassword());
    }

    public Passenger update(Passenger passenger) {
	return repository.save(passenger);
    }

    public void delete(Long id) {
	repository.deleteById(id);
    }
}

// ========================================
