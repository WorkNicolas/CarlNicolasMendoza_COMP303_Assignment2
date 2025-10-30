/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

CREATE DATABASE Reservation CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
CREATE USER 'nico'@'localhost' IDENTIFIED BY 'Cnnmcn54$';
GRANT ALL PRIVILEGES ON Reservation.* TO 'nico'@'localhost';
FLUSH PRIVILEGES;
