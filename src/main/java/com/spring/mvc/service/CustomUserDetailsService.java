/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

/**
 * UserDetailsService implementation for loading user-specific data.
 * - loadUserByUsername(String email): Loads a user by their email address
 * 
 * @author nico
 * @version 0.1
 * @since 2025-10-30
 */

package com.spring.mvc.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.mvc.model.Passenger;
import com.spring.mvc.repository.PassengerRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final PassengerRepository passengerRepository;

    public CustomUserDetailsService(PassengerRepository passengerRepository) {
	this.passengerRepository = passengerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	Passenger passenger = passengerRepository.findByEmail(email);

	if (passenger == null) {
	    throw new UsernameNotFoundException("User not found with email: " + email);
	}

	return User.builder().username(passenger.getEmail()).password(passenger.getPassword()).roles("USER").build();
    }
}