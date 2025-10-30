/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

/**
 * Flight controller class for handling flight-related requests.
 * - listFlights: Displays a list of all flights
 * 
 * @author nico
 * @version 0.1
 * @since 2025-10-30
 */
package com.spring.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.mvc.model.Flight;
import com.spring.mvc.service.FlightService;

@Controller
@RequestMapping("/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
	this.flightService = flightService;
    }

    @GetMapping
    public String listFlights(Model model) {
	List<Flight> flights = flightService.findAll();
	model.addAttribute("flights", flights);
	return "flights";
    }
}

// ========================================
