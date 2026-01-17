# Java Reservation System

## 🛠 Used technologies
* Java 17
* Spring Boot 3.4
* PostgreSQL (Docker)
* Flyway
* MapStruct
* Lombok
* Global Exception Handling

## 🚀 Database command : 
docker-compose up -d

## 📡 API Endpoints

* Base URL: http://localhost:8080
* Create reservation (POST)
* Endpoint: /api/reservations
* 
### Body (JSON):
{
  "roomId": 1,
  "customerName": "Jan Novák",
  "startTime": "2024-02-01T10:00:00",
  "endTime": "2024-02-01T12:00:00"
}

### Return codes:
* 201 Created - Úspěšně vytvořeno
* 409 Conflict - Místnost je v daném čase obsazena
  
* Seznam rezervací (GET)
* Endpoint: /api/reservations

### Response (JSON):
  {
    "id": 1,
    "roomId": 1,
    "customerName": "Jan Novák",
    "startTime": "2024-02-01T10:00:00",
    "endTime": "2024-02-01T12:00:00"
  }
Return codes:
* 200 OK
