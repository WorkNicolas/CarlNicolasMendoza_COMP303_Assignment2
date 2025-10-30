/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

// File: src/main/resources/static/js/debug/debug-register.js
// Input items into register.html.

document.addEventListener('DOMContentLoaded', function() {
        const autoRegisterBtn = document.getElementById('autoRegisterBtn');
        const registerForm = document.getElementById('registerForm');

        if (autoRegisterBtn) {
            autoRegisterBtn.addEventListener('click', function() {
                // Generate random user to avoid email conflicts
                const randomId = Math.floor(Math.random() * 10000);
                
                // Auto-fill all form fields for debugging
                document.getElementById('firstname').value = 'Test';
                document.getElementById('lastname').value = 'User';
                document.getElementById('email').value = `testuser${randomId}@example.com`;
                document.getElementById('password').value = 'password123';
                document.getElementById('address').value = '123 Test Street';
                document.getElementById('city').value = 'Toronto';
                document.getElementById('postalCode').value = '12345';
                
                // Show a confirmation with the email that will be used
                alert(`Form filled with test data!\nEmail: testuser${randomId}@example.com\nPassword: password123\n\nClick "Create Account" to register.`);
            });
        }
    });