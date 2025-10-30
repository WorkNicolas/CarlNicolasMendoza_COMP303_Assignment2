/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

// File: src/main/resources/static/js/reservation-form.js
// Dynamic price preview
document.addEventListener('DOMContentLoaded', function () {
  const container = document.getElementById('priceContext');
  const passengersInput = document.getElementById('no_of_passengers');
  const totalEl = document.getElementById('totalPrice');

  if (!container || !passengersInput || !totalEl) return;

  const pricePerSeat = parseFloat(container.dataset.price || '0');

  function updateTotal() {
    const passengers = Math.min(
      Math.max(parseInt(passengersInput.value || '1', 10), parseInt(passengersInput.min || '1', 10)),
      parseInt(passengersInput.max || '10', 10)
    );
    const total = pricePerSeat * passengers;
    if (isFinite(total) && total > 0) {
      totalEl.textContent = '$' + total.toFixed(2);
    }
  }

  passengersInput.addEventListener('input', updateTotal);
  updateTotal();
});
