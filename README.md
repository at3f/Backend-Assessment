# Backend-Assessment

This is a simple Spring Boot application for managing accounts and financial transactions.

## Prerequisites

- Docker
- Docker Compose

## Getting Started

Follow these steps to run the project:

### 1. Build the Spring Boot Application

```bash
./mvnw clean package
```
### 2. Build the Docker Image

```bash
docker-compose build
```
### 3. Run the Docker Compose Setup

```bash
docker-compose up
```
The application will be accessible at [http://localhost:8080](http://localhost:8080).

## 4. Access Swagger Documentation

The Swagger documentation for the API can be accessed at [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html).

## API Endpoints

### Open Account

- **Endpoint:** `POST /api/accounts/open`
- **Returns:** Account ID

### Get Account Balance

- **Endpoint:** `GET /api/accounts/{accountId}/balance`
- **Returns:** Account Balance

### Deposit Funds

- **Endpoint:** `POST /api/transactions/deposit`
- **Returns:** Transaction ID

### Withdraw Funds

- **Endpoint:** `POST /api/transactions/withdraw`
- **Returns:** Transaction ID

## Important Notes

- Make sure to have Docker and Docker Compose installed.
- Update PostgreSQL connection details in `application.properties` and `docker-compose.yml` as needed.
- Adjust the database name, username, and password accordingly.

