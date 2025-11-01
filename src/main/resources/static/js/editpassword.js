// Custom Modal JavaScript
document.addEventListener('DOMContentLoaded', function() {
    const modal = document.getElementById('passwordModal');
    const openBtn = document.getElementById('openPasswordModal');
    const closeBtn = document.getElementById('closePasswordModal');
    const cancelBtn = document.getElementById('cancelPasswordModal');

    // Open modal
    if (openBtn) {
        openBtn.addEventListener('click', function() {
            modal.classList.add('active');
            document.body.style.overflow = 'hidden'; // Prevent background scrolling
        });
    }

    // Close modal function
    function closeModal() {
        modal.classList.remove('active');
        document.body.style.overflow = ''; // Restore scrolling
        // Clear form fields
        document.getElementById('passwordChangeForm').reset();
    }

    // Close on X button
    if (closeBtn) {
        closeBtn.addEventListener('click', closeModal);
    }

    // Close on Cancel button
    if (cancelBtn) {
        cancelBtn.addEventListener('click', closeModal);
    }

    // Close on overlay click
    modal.addEventListener('click', function(e) {
        if (e.target === modal) {
            closeModal();
        }
    });

    // Close on ESC key
    document.addEventListener('keydown', function(e) {
        if (e.key === 'Escape' && modal.classList.contains('active')) {
            closeModal();
        }
    });
});