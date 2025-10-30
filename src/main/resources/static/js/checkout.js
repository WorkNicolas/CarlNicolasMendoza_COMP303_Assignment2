/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

// File: src/main/resources/static/js/checkout.js
// Extracted from checkout.html: formats card number & expiry fields.

document.addEventListener('DOMContentLoaded', function () {
  const cardNumber = document.getElementById('cardNumber');
  const expiry = document.getElementById('expiry');

  if (cardNumber) {
    cardNumber.addEventListener('input', function (e) {
      // Remove spaces, keep digits only
      let value = e.target.value.replace(/\D/g, '');
      // Group into 4s
      const groups = value.match(/.{1,4}/g);
      e.target.value = groups ? groups.join(' ') : value;
    });
  }

  if (expiry) {
    expiry.addEventListener('input', function (e) {
      // Keep digits only
      let value = e.target.value.replace(/\D/g, '');
      // Auto-insert slash after MM
      if (value.length > 2) value = value.slice(0, 2) + '/' + value.slice(2, 4);
      e.target.value = value.slice(0, 5);
    });
  }
});
