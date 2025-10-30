# Database Tables
Please run everything the following order.
## Reservation
The name of the database is `Reservation`. It has three tables that automatically get created when the Spring Boot app runs.

**Flight**
- flight_id (Primary Key, Auto-increment)
- airline_name
- origin
- destination
- departure_time
- arrival_time
- price

**Passenger**
- passenger_id (Primary Key, Auto-increment)
- email
- password
- firstname
- lastname
- address
- city
- postal_code

**Reservation**
- reservation_id (Primary Key, Auto-increment)
- passenger_id (Foreign Key to Passenger)
- flight_id (Foreign Key to Flight)
- booking_date
- departure_date
- no_of_passengers
- total_price
- status