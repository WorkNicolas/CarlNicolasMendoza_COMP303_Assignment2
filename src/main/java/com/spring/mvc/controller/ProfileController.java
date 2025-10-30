/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

/**
 * Profile controller to handle viewing and updating passenger profiles.
 * - viewProfile: Displays the profile page for the logged-in passenger
 * - updateProfile: Handles profile updates with validation
 * 
 * @author nico
 * @version 0.1
 * @since 2025-10-30
 */
package com.spring.mvc.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc.model.Passenger;
import com.spring.mvc.service.PassengerService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/profile")
public class ProfileController {

    private final PassengerService passengerService;

    public ProfileController(PassengerService passengerService) {
	this.passengerService = passengerService;
    }

    @GetMapping
    public String viewProfile(Model model, Principal principal) {
	if (principal == null) {
	    return "redirect:/login";
	}

	Passenger passenger = passengerService.findByEmail(principal.getName());

	if (passenger == null) {
	    return "redirect:/login";
	}

	model.addAttribute("passenger", passenger);
	return "profile";
    }

    @PostMapping("/update")
    public String updateProfile(@Valid @ModelAttribute("passenger") Passenger passenger, BindingResult result,
	    Principal principal, Model model) {

	if (result.hasErrors()) {
	    return "profile";
	}

	// Get the current passenger from database
	Passenger existingPassenger = passengerService.findByEmail(principal.getName());

	if (existingPassenger == null) {
	    return "redirect:/login";
	}

	// Update fields (keep the same ID and password)
	existingPassenger.setFirstname(passenger.getFirstname());
	existingPassenger.setLastname(passenger.getLastname());
	existingPassenger.setAddress(passenger.getAddress());
	existingPassenger.setCity(passenger.getCity());
	existingPassenger.setPostalCode(passenger.getPostalCode());

	passengerService.update(existingPassenger);
	model.addAttribute("success", "Profile updated successfully");
	model.addAttribute("passenger", existingPassenger);

	return "profile";
    }
}