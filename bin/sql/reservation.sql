CREATE DATABASE Reservation CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci;
CREATE USER 'nico'@'localhost' IDENTIFIED BY 'Cnnmcn54$';
GRANT ALL PRIVILEGES ON Reservation.* TO 'nico'@'localhost';
FLUSH PRIVILEGES;
