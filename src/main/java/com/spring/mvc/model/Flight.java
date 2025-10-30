/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

/** 
 * Flight model class representing a flight entity.
 * - flight_id: Unique identifier for the flight
 * - airline_name: Name of the airline (not blank)
 * - origin: Origin location of the flight (not blank)
 * - destination: Destination location of the flight (not blank)
 * - departure_time: Departure time of the flight (not null)
 * - arrival_time: Arrival time of the flight (not null)
 * - price: Price of the flight (must be positive)
 * 
 * @author nico
 * @version 0.1
 * @since 2025-10-30
 */
package com.spring.mvc.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "Flight")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long flight_id;

    @NotBlank
    private String airline_name;
    @NotBlank
    private String origin;
    @NotBlank
    private String destination;

    @NotNull
    private LocalDateTime departure_time;
    @NotNull
    private LocalDateTime arrival_time;
    @Positive
    private Double price;

    // getters and setters
    public Long getFlight_id() {
	return flight_id;
    }

    public void setFlight_id(Long flight_id) {
	this.flight_id = flight_id;
    }

    public String getAirline_name() {
	return airline_name;
    }

    public void setAirline_name(String airline_name) {
	this.airline_name = airline_name;
    }

    public String getOrigin() {
	return origin;
    }

    public void setOrigin(String origin) {
	this.origin = origin;
    }

    public String getDestination() {
	return destination;
    }

    public void setDestination(String destination) {
	this.destination = destination;
    }

    public LocalDateTime getDeparture_time() {
	return departure_time;
    }

    public void setDeparture_time(LocalDateTime departure_time) {
	this.departure_time = departure_time;
    }

    public LocalDateTime getArrival_time() {
	return arrival_time;
    }

    public void setArrival_time(LocalDateTime arrival_time) {
	this.arrival_time = arrival_time;
    }

    public Double getPrice() {
	return price;
    }

    public void setPrice(Double price) {
	this.price = price;
    }
}
