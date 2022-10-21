# SpringBootServerForAndroidBluetoothApp

A web server developed, using Spring Boot and a PostgreSQL database. The server will be able to receive data from a BluetoothAndroidApp and store them in the database.
These data will include: 
  - the location of the user (latitude, longitude, city, country)
  - the number of the nearby devices to the user at that specific location and time (using Bluetooth scan)

Furthermore, the android app will be able to retrieve that data from the server and use them to export statistics such as in which countries the highest overcrowding 
is observed, in which cities, days etc.


- Spring Boot
- Spring Data JPA
- Spring Security
- Spring Authentication and Authorization
- PostgreSQL 
