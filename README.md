# Java Reservation System

## 🛠 Used technologies
* Java 21
* Spring Boot 4.0.1
* PostgreSQL (Docker)
* Flyway
* MapStruct
* Lombok
* Global Exception Handling

## 🚀 Database command : 
docker-compose up -d

## 📡 API Endpoints

* Base URL: http://localhost:8080
  
### Create reservation (POST)
* Endpoint: /api/reservations

#### Body (JSON):
 {
  "roomId": 1,
 "customerName": "Jan Novák",
 "startTime": "2024-02-01T10:00:00",
 "endTime": "2024-02-01T12:00:00"
 }

#### Return codes:
* 201 Created - Successfully created
* 409 Conflict - The room is occupied at the given time
  
### List of reservations (GET)
* Endpoint: /api/reservations

#### Response (JSON):
   {
    "id": 1,
    "roomId": 1,
    "customerName": "Jan Novák",
    "startTime": "2024-02-01T10:00:00",
    "endTime": "2024-02-01T12:00:00"
   }
  
#### Return codes:
* 200 OK
