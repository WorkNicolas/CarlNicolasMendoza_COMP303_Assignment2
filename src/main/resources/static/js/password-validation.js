// Add this script to your register.html template
// Place it at the bottom of the page before </body> or in a <script> tag

document.addEventListener('DOMContentLoaded', function() {
    const password = document.getElementById('password');
    const confirmPassword = document.getElementById('confirmPassword');
    const errorMessage = document.getElementById('password-match-error');
    
    function checkPasswordMatch() {
        // Only check if both fields have values
        if (password.value && confirmPassword.value) {
            if (password.value !== confirmPassword.value) {
                errorMessage.textContent = 'Passwords do not match';
                errorMessage.style.display = 'block';
                confirmPassword.classList.add('is-invalid');
            } else {
                errorMessage.textContent = 'Passwords match';
                errorMessage.style.display = 'block';
                errorMessage.style.color = 'green';
                confirmPassword.classList.remove('is-invalid');
                confirmPassword.classList.add('is-valid');
            }
        } else {
            errorMessage.style.display = 'none';
            confirmPassword.classList.remove('is-invalid', 'is-valid');
        }
    }
    
    // Check on every input change
    password.addEventListener('input', checkPasswordMatch);
    confirmPassword.addEventListener('input', checkPasswordMatch);
});