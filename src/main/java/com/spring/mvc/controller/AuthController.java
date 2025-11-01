/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

/**
 * Auth controller for handling login and registration.
 * - loginForm: Displays the login form
 * - registerForm: Displays the registration form
 * - register: Handles user registration with validation and error handling
 * 
 * @author nico
 * @version 0.1
 * @since 2025-10-30
 */
package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.mvc.model.Passenger;
import com.spring.mvc.service.PassengerService;

import dto.RegistrationDto;
import jakarta.validation.Valid;

@Controller
public class AuthController {

    private final PassengerService passengerService;

    public AuthController(PassengerService passengerService) {
	this.passengerService = passengerService;
    }

    @GetMapping("/login")
    public String loginForm() {
	return "login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
	model.addAttribute("registrationForm", new RegistrationDto());
	return "register";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("registrationForm") RegistrationDto dto, BindingResult result,
	    Model model) {

	// Check for validation errors
	if (result.hasErrors()) {
	    return "register";
	}

	// Check if email already exists
	if (passengerService.findByEmail(dto.getEmail()) != null) {
	    model.addAttribute("error", "Email already registered");
	    return "register";
	}

	Passenger p = new Passenger();
	p.setEmail(dto.getEmail());
	p.setFirstname(dto.getFirstname());
	p.setLastname(dto.getLastname());
	p.setAddress(dto.getAddress());
	p.setCity(dto.getCity());
	p.setPostalCode(dto.getPostalCode());
	p.setPassword(dto.getPassword());

	// Register the passenger (password will be encoded in service)
	passengerService.register(p);
	model.addAttribute("success", "Registration successful! Please log in.");
	return "redirect:/login?registered";
    }
}

// ========================================
