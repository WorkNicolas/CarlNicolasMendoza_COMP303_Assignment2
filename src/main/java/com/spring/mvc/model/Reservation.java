/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

/** 
 * Reservation model class representing a flight reservation.
 * - reservation_id: Unique identifier for the reservation.
 * - passenger: The passenger who made the reservation.
 * - flight: The flight associated with the reservation.
 * - booking_date: Date when the reservation was made.
 * - departure_date: Date of the flight departure.
 * - no_of_passengers: Number of passengers in the reservation.
 * - total_price: Total price of the reservation.
 * - status: Status of the reservation (e.g., "BOOKED", "CANCELLED").
 * 
 * @author nico
 * @version 0.1
 * @since 2025-10-30
 */
package com.spring.mvc.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "Reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Long reservationId;

    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @PastOrPresent(message = "Booking date cannot be in the future")
    private LocalDate booking_date;

    @NotNull(message = "Departure date is required")
    @Future(message = "Departure date must be in the future")
    private LocalDate departure_date;

    @Min(value = 1, message = "Must have at least 1 passenger")
    private int no_of_passengers;

    @Positive
    private Double total_price;

    private String status; // "BOOKED", "CANCELLED"

    // Getters and Setters
    public Long getReservation_id() {
	return reservationId;
    }

    public void setReservation_id(Long reservation_id) {
	this.reservationId = reservation_id;
    }

    public Passenger getPassenger() {
	return passenger;
    }

    public void setPassenger(Passenger passenger) {
	this.passenger = passenger;
    }

    public Flight getFlight() {
	return flight;
    }

    public void setFlight(Flight flight) {
	this.flight = flight;
    }

    public LocalDate getBooking_date() {
	return booking_date;
    }

    public void setBooking_date(LocalDate booking_date) {
	this.booking_date = booking_date;
    }

    public LocalDate getDeparture_date() {
	return departure_date;
    }

    public void setDeparture_date(LocalDate departure_date) {
	this.departure_date = departure_date;
    }

    public int getNo_of_passengers() {
	return no_of_passengers;
    }

    public void setNo_of_passengers(int no_of_passengers) {
	this.no_of_passengers = no_of_passengers;
    }

    public Double getTotal_price() {
	return total_price;
    }

    public void setTotal_price(Double total_price) {
	this.total_price = total_price;
    }

    public String getStatus() {
	return status;
    }

    public void setStatus(String status) {
	this.status = status;
    }
}