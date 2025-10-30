/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

-- Insert Flights (Execute FIRST - no dependencies)
INSERT INTO flight (airline_name, origin, destination, departure_time, arrival_time, price) VALUES
('Air Canada', 'Toronto', 'Vancouver', '2025-11-15 10:00:00', '2025-11-15 13:30:00', 299.99),
('WestJet', 'Toronto', 'Calgary', '2025-11-16 14:00:00', '2025-11-16 16:45:00', 249.99),
('Air Canada', 'Montreal', 'Halifax', '2025-11-17 09:00:00', '2025-11-17 11:30:00', 199.99),
('Porter Airlines', 'Toronto', 'Ottawa', '2025-11-18 08:00:00', '2025-11-18 09:15:00', 149.99),
('Air Canada', 'Vancouver', 'Toronto', '2025-11-20 18:00:00', '2025-11-21 02:00:00', 349.99),
('WestJet', 'Calgary', 'Montreal', '2025-11-22 11:00:00', '2025-11-22 17:30:00', 279.99),
('Porter Airlines', 'Ottawa', 'Toronto', '2025-11-25 15:00:00', '2025-11-25 16:15:00', 129.99);

SELECT * FROM flight;