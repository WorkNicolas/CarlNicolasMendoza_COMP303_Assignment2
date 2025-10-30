/* Student Name: Carl Nicolas Mendoza
 * Student Number: 301386435
 * Submission Date: 2025-10-30
 */

// File: src/main/resources/static/js/confirmation.js
document.addEventListener('DOMContentLoaded', function () {
  const btn = document.getElementById('printBtn');
  if (btn) btn.addEventListener('click', () => window.print());
});
