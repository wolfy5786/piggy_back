![image](https://github.com/user-attachments/assets/3bd1c187-701e-477b-8f86-b7c0a8402a79)

---

# 🚖 Piggyback — Cab Booking Service

A full-stack cab booking system built with **Spring Boot**, **Java**, **PostgreSQL**, and **Docker**, providing secure REST APIs and a simple frontend for booking, managing, and tracking cab rides.

---

## ✨ Features

- User Registration & Authentication
- Cab Ride Booking, Updating, and Cancellation
- Real-Time Ride Tracking
- Payment Processing Module
- REST API with **Swagger** Documentation
- **Dockerized** Deployment for Easy Setup

---

## 🛠️ Tech Stack

| Layer      | Technology                         |
|------------|-------------------------------------|
| Backend    | Java, Spring Boot                   |
| Database   | PostgreSQL                          |
| Frontend   | HTML, CSS, JavaScript *(or specify)* |
| Build Tool | Gradle                              |
| Containerization | Docker, Docker Compose         |
| API Testing| Postman                             |
| Documentation | Swagger (OpenAPI)                |

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- Gradle
- Docker & Docker Compose
- PostgreSQL (or Docker container)

### Setup Instructions

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/piggyback-cab-booking.git
   cd piggyback-cab-booking
   ```

2. **Configure Database**
   
   Update your `application.properties` file:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/piggybackdb
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   ```

3. **Build and Run**

   To build the project:
   ```bash
   ./gradlew build
   ```

   To run with Docker Compose:
   ```bash
   docker-compose up
   ```

4. **Access Application**
   - API Documentation (Swagger): [http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)
   - Frontend UI: [http://localhost:8080/](http://localhost:8080/)

---

## 📚 API Endpoints (Examples)

| Method | Endpoint              | Description            |
|:------:|:----------------------|:-----------------------|
| `POST` | `/api/auth/register`   | Register a user         |
| `POST` | `/api/auth/login`      | Login and receive token |
| `POST` | `/api/rides/book`      | Book a new cab ride     |
| `GET`  | `/api/rides/{rideId}`  | Get ride status         |
| `DELETE` | `/api/rides/cancel`  | Cancel an active booking |


