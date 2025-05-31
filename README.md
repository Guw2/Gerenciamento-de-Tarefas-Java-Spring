
# --- Task Management API ---  

![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-green)  
![Java](https://img.shields.io/badge/Java-21-blue)  
![MySQL](https://img.shields.io/badge/MySQL-8.0-orange)  
![Docker](https://img.shields.io/badge/Docker-✓-lightblue)  

A RESTful API built with Spring Boot for efficient task management. This project demonstrates clean architecture, robust validation, pagination, filtering, and containerization using Docker.  

> 🌎 [README em português disponível na pasta raiz do projeto](README-pt.md)

## ✨ ————— Features ————— ✨  

- **CRUD Operations**: Create, read, update, and delete tasks  
- **Advanced Filtering**: Filter tasks by status  
- **Pagination & Sorting**: Efficient data handling  
- **Input Validation**: Using Spring Validation  
- **API Documentation**: OpenAPI with Swagger UI  
- **Containerization**: Docker integration (Java/Spring Boot App + MySQL)  

## 🛠️ ————— Technologies ————— 🛠️  

- **Java 21**  
- **Spring Boot 3.5.0**  
- **Spring Data JPA**  
- **MySQL 8.0**  
- **Docker**  
- **Springdoc OpenAPI (Swagger)**  
- **Spring Boot Validation**  

## 🚀 ————— Getting Started ————— 🚀  

### 🐳 Docker Setup  

```bash  
git clone https://github.com/Guw2/TaskManagementApp.git  
cd TaskManagementApp  
docker-compose up --build  
```  

### Local Setup 💻  

1. Create MySQL database:  
```sql  
CREATE DATABASE SS_user_auth;  
```  

2. Update `application.properties`:  
```properties  
spring.datasource.url=jdbc:mysql://localhost:3306/SS_user_auth?useTimezone=true&serverTimezone=UTC  
spring.datasource.username=root  
spring.datasource.password=root  
```  

3. Run the application:  
```bash  
./mvnw spring-boot:run  
```  

## => ————— API Endpoints ————— =>  

| METHOD | ENDPOINT | DESCRIPTION |  
|--------|----------|-------------|  
| GET | `/task` | Get all tasks |  
| POST | `/task` | Create new task |  
| GET | `/task?status={status}` | Get tasks filtered by status |  
| PUT | `/task/{id}` | Update existing task |  
| DELETE | `/task/{id}` | Delete task by ID |  

### 🔍 Pagination Example  
```  
GET /task?page=0&size=10  
```  

## 📝————— Request Example ————— 📝  

```json  
{  
    "title": "Sample Title",  
    "description": "Sample description.",  
    "status": "PENDING"  
}  
```  

## 🛡️————— Validation Rules ————— 🛡️  

- `@NotBlank` for title and description  
- `@NotNull` for status  
- Global exception handler returns user-friendly error messages  

## 📚 ————— Documentation ————— 📚  

Access interactive API documentation at:  
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)