/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

/** 
 * Passenger model class representing a passenger entity in the system.
 * - email: Passenger's email address (must be valid and not blank)
 * - password: Passenger's password (must be at least 8 characters and not blank)
 * - firstname: Passenger's first name (not blank)
 * - lastname: Passenger's last name (not blank)
 * - address: Passenger's address
 * - city: Passenger's city
 * - postalCode: Passenger's postal code (must be 4–6 digits)
 * 
 * @author nico
 * @version 0.1
 * @since 2025-10-30
 */
package com.spring.mvc.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Passenger")
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "passenger_id")
    private Long passengerId;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 8)
    private String password;

    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;

    @Size(max = 255, message = "Address must not exceed 255 characters")
    private String address;

    @Size(max = 100, message = "City must not exceed 100 characters")
    @Pattern(regexp = "^[\\p{L} .'-]*$", message = "City contains invalid characters")
    private String city;

    @Pattern(regexp = "\\d{4,6}", message = "Postal code must be 4–6 digits")
    private String postalCode;

    // getters and setters
    public Long getPassengerId() {
	return passengerId;
    }

    public void setPassenger_id(Long passenger_id) {
	this.passengerId = passenger_id;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public String getFirstname() {
	return firstname;
    }

    public void setFirstname(String firstname) {
	this.firstname = firstname;
    }

    public String getLastname() {
	return lastname;
    }

    public void setLastname(String lastname) {
	this.lastname = lastname;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getPostalCode() {
	return postalCode;
    }

    public void setPostalCode(String postalCode) {
	this.postalCode = postalCode;
    }
}
