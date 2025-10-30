/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

// File: src/main/resources/static/js/reservations.js
// Handles confirm dialogs for destructive actions.
document.addEventListener('DOMContentLoaded', function () {
  function attachConfirm(selector) {
    document.addEventListener('click', function (e) {
      const el = e.target.closest(selector);
      if (!el) return;
      const msg = el.getAttribute('data-confirm') || 'Are you sure?';
      if (!window.confirm(msg)) {
        e.preventDefault();
        e.stopPropagation();
      }
    });
  }
  // Any <a> (or clickable element) with a data-confirm attribute will be guarded.
  attachConfirm('a[data-confirm], button[data-confirm]');
});
