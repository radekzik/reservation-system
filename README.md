# Java Reservation System

## 🛠 Used technologies
* Java 21
* Spring Boot
* PostgreSQL (Docker)
* Flyway
* MapStruct
* Lombok
* Global Exception Handling

## 🚀 Database command
docker-compose up -d

## 📡 API Endpoints

* Base URL: http://localhost:8080
  
### Create reservation (POST)
* Endpoint: /api/reservations

#### Body (JSON):
 {<br>
  &emsp;"roomId": 1,<br>
 &emsp;"customerName": "Jan Novák",<br>
 &emsp;"startTime": "2024-02-01T10:00:00",<br>
 &emsp;"endTime": "2024-02-01T12:00:00"<br>
 }

#### Return codes:
* 201 Created - Successfully created
* 409 Conflict - The room is occupied at the given time
  
### List of reservations (GET)
* Endpoint: /api/reservations

#### Response (JSON):
[<br>
   &emsp;{<br>
    &emsp;&emsp;"id": 1,<br>
    &emsp;&emsp;"roomId": 1,<br>
    &emsp;&emsp;"customerName": "Jan Novák",<br>
    &emsp;&emsp;"startTime": "2024-02-01T10:00:00",<br>
    &emsp;&emsp;"endTime": "2024-02-01T12:00:00"<br>
   &emsp;}<br>
]
#### Return codes:
* 200 OK
