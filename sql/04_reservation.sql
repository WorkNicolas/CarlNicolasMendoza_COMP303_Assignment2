/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

-- Insert Reservations (Execute LAST - depends on both Flight and Passenger)
INSERT INTO reservation (, flight_id, booking_date, departure_date, no_of_passengers, total_price, status) VALUES
(1, 1, '2025-10-25', '2025-11-15'passenger_id, 2, 599.98, 'CONFIRMED'),
(2, 2, '2025-10-26', '2025-11-16', 1, 249.99, 'BOOKED'),
(3, 3, '2025-10-27', '2025-11-17', 3, 599.97, 'CONFIRMED'),
(4, 4, '2025-10-28', '2025-11-18', 1, 149.99, 'BOOKED'),
(5, 5, '2025-10-29', '2025-11-20', 2, 699.98, 'CONFIRMED'),
(1, 6, '2025-10-30', '2025-11-22', 1, 279.99, 'BOOKED'),
(2, 7, '2025-10-30', '2025-11-25', 2, 259.98, 'CANCELLED');

SELECT * FROM reservation;