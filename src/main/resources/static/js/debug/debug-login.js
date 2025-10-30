/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

// File: src/main/resources/static/js/debug/debug-login.js
// Input items into login.html.

document.addEventListener('DOMContentLoaded', function() {
        const autoLoginBtn = document.getElementById('autoLoginBtn');
        const usernameInput = document.getElementById('username');
        const passwordInput = document.getElementById('password');
        const loginForm = document.getElementById('loginForm');

        if (autoLoginBtn) {
            autoLoginBtn.addEventListener('click', function() {
                // Auto-fill credentials for debugging
                usernameInput.value = 'john.doe@example.com';
                passwordInput.value = 'password123';
                
                // Auto-submit the form
                loginForm.submit();
            });
        }
    });