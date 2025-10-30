/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

/**
 * Reservation controller class to handle reservation-related web requests.
 * - listReservations: Displays a list of reservations for the logged-in passenger
 * - newReservationForm: Shows form to create a new reservation for a selected flight
 * - saveReservation: Processes the reservation form submission and saves the reservation
 * - checkout: Displays the checkout page for a reservation
 * - confirmPayment: Handles payment confirmation for a reservation
 * - editReservation: Shows form to edit an existing reservation
 * - updateReservation: Processes the reservation update form submission
 * - cancelReservation: Cancels an existing reservation
 * - deleteReservation: Deletes a reservation
 * 
 * @author nico
 * @version 0.1
 * @since 2025-10-30
 */
package com.spring.mvc.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.model.Flight;
import com.spring.mvc.model.Passenger;
import com.spring.mvc.model.Reservation;
import com.spring.mvc.service.FlightService;
import com.spring.mvc.service.PassengerService;
import com.spring.mvc.service.ReservationService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final PassengerService passengerService;
    private final FlightService flightService;

    public ReservationController(ReservationService reservationService, PassengerService passengerService,
	    FlightService flightService) {
	this.reservationService = reservationService;
	this.passengerService = passengerService;
	this.flightService = flightService;
    }

    @GetMapping
    public String listReservations(Model model, Principal principal) {
	// Get current logged-in user
	Passenger passenger = passengerService.findByEmail(principal.getName());

	// For simplicity, showing all reservations
	// In production, filter by passenger_id
	List<Reservation> reservations = reservationService.findAll();
	model.addAttribute("reservations", reservations);
	return "reservation-list";
    }

    @GetMapping("/new")
    public String newReservationForm(@RequestParam("flightId") Long flightId, Model model, Principal principal) {

	Flight flight = flightService.findById(flightId);
	Passenger passenger = passengerService.findByEmail(principal.getName());

	if (flight == null || passenger == null) {
	    return "redirect:/flights?error=invalid";
	}

	Reservation reservation = new Reservation();
	reservation.setFlight(flight);
	reservation.setPassenger(passenger);
	reservation.setBooking_date(LocalDate.now());
	reservation.setStatus("BOOKED");

	model.addAttribute("reservation", reservation);
	model.addAttribute("flight", flight);
	return "reservation-form";
    }

    @PostMapping("/save")
    public String saveReservation(@Valid @ModelAttribute("reservation") Reservation reservation, BindingResult result,
	    @RequestParam("flightId") Long flightId, @RequestParam("passengerId") Long passengerId, Model model) {

	if (result.hasErrors()) {
	    Flight flight = flightService.findById(flightId);
	    model.addAttribute("flight", flight);
	    return "reservation-form";
	}

	// Set relationships
	Flight flight = flightService.findById(flightId);
	Passenger passenger = passengerService.findById(passengerId);

	reservation.setFlight(flight);
	reservation.setPassenger(passenger);
	reservation.setBooking_date(LocalDate.now());
	reservation.setStatus("BOOKED");

	// Calculate total price
	double totalPrice = flight.getPrice() * reservation.getNo_of_passengers();
	reservation.setTotal_price(totalPrice);

	reservationService.save(reservation);
	return "redirect:/reservations/checkout/" + reservation.getReservation_id();
    }

    @GetMapping("/checkout/{id}")
    public String checkout(@PathVariable("id") Long id, Model model) {
	Reservation reservation = reservationService.findById(id);

	if (reservation == null) {
	    return "redirect:/reservations?error=notfound";
	}

	model.addAttribute("reservation", reservation);
	return "checkout";
    }

    @PostMapping("/confirm/{id}")
    public String confirmPayment(@PathVariable("id") Long id, Model model) {
	Reservation reservation = reservationService.findById(id);

	if (reservation == null) {
	    return "redirect:/reservations?error=notfound";
	}

	// In a real application, process payment here
	// For now, just mark as confirmed
	reservation.setStatus("CONFIRMED");
	reservationService.save(reservation);

	model.addAttribute("reservation", reservation);
	return "confirmation";
    }

    @GetMapping("/edit/{id}")
    public String editReservation(@PathVariable("id") Long id, Model model) {
	Reservation reservation = reservationService.findById(id);

	if (reservation == null) {
	    return "redirect:/reservations?error=notfound";
	}

	model.addAttribute("reservation", reservation);
	model.addAttribute("flight", reservation.getFlight());
	return "reservation-form";
    }

    @PostMapping("/update/{id}")
    public String updateReservation(@PathVariable("id") Long id,
	    @Valid @ModelAttribute("reservation") Reservation reservation, BindingResult result, Model model) {

	if (result.hasErrors()) {
	    model.addAttribute("flight", reservation.getFlight());
	    return "reservation-form";
	}

	// Recalculate total price
	double totalPrice = reservation.getFlight().getPrice() * reservation.getNo_of_passengers();
	reservation.setTotal_price(totalPrice);
	reservation.setReservation_id(id);

	reservationService.save(reservation);
	return "redirect:/reservations?updated";
    }

    @GetMapping("/cancel/{id}")
    public String cancelReservation(@PathVariable("id") Long id) {
	Reservation reservation = reservationService.findById(id);

	if (reservation != null) {
	    reservation.setStatus("CANCELLED");
	    reservationService.save(reservation);
	}

	return "redirect:/reservations?cancelled";
    }

    @GetMapping("/delete/{id}")
    public String deleteReservation(@PathVariable("id") Long id) {
	reservationService.delete(id);
	return "redirect:/reservations?deleted";
    }
}

// ========================================
