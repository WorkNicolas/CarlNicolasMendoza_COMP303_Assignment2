/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

-- Insert Passengers with BCrypt hashed passwords (Execute SECOND)
-- Password for all users is: "password123"
-- BCrypt hash: $2a$10$8zKN4h5Z5Z5Z5Z5Z5Z5Z5eFqGqKqKqKqKqKqKqKqKqKqKqKqKqKq

INSERT INTO passenger (email, password, firstname, lastname, address, city, postal_code) VALUES
('john.doe@example.com', '$2a$10$Z.vjSN91Vna82fzUvMopWOCkQGVxf2VLGEVtYwYFMksTTgokbQDzW', 'John', 'Doe', '123 Main St', 'Toronto', '123456'),
('jane.smith@example.com', '$2a$10$Z.vjSN91Vna82fzUvMopWOCkQGVxf2VLGEVtYwYFMksTTgokbQDzW', 'Jane', 'Smith', '456 Oak Ave', 'Vancouver', '654321'),
('mike.wilson@example.com', '$2a$10$Z.vjSN91Vna82fzUvMopWOCkQGVxf2VLGEVtYwYFMksTTgokbQDzW', 'Mike', 'Wilson', '789 Pine Rd', 'Calgary', '789012'),
('sarah.jones@example.com', '$2a$10$Z.vjSN91Vna82fzUvMopWOCkQGVxf2VLGEVtYwYFMksTTgokbQDzW', 'Sarah', 'Jones', '321 Elm St', 'Montreal', '345678'),
('david.brown@example.com', '$2a$10$Z.vjSN91Vna82fzUvMopWOCkQGVxf2VLGEVtYwYFMksTTgokbQDzW', 'David', 'Brown', '654 Maple Dr', 'Ottawa', '901234');

-- All these users have password: password123

SELECT * FROM passenger;
