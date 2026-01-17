# EmployeeAPI

A full-stack Employee Management REST API built using Spring Boot, JWT authentication, and role-based access control. 
This project supports secure CRUD operations, pagination, and modern REST standards, designed for learning and production-ready backend architecture.

## Features
- User Authentication with JWT
- Role-Based Authorization (ADMIN / USER)
- Create, Read, Update, Delete (CRUD) Employees
- Pagination & Sorting
- Global Exception Handling
- DTO Mapping (Request & Response)
- Secure REST APIs using Spring Security
- Postgre SQL Database Integration
- Clean Layered Architecture (Controller, Service, Repository)

## Tech Stack
- Java 17+
- Spring Boot
- Spring Security + JWT
- Spring Data JPA (Hibernate)
- PostGre SQL
- Maven
- Lombok
- IntelliJ IDEA
- Git & GitHub

## Project Structure
employeeapi
┣ controller
┣ service
┣ repository
┣ dto
┣ security
┣ exception
┣ response
┗ config

## Setup & Run Locally
1. Clone the repository:
git clone https://github.com/yourusername/EmployeeAPI.git

2.Configure postgresql in application.properties:
spring.datasource.url=.
spring.datasource.username=root
spring.datasource.password=yourpassword

3.Run the application:
mvn spring-boot:run

4.Access API:
http://localhost:8080

API Endpoints
Method	Endpoint	Description
POST	/api/auth/login	User login
POST	/api/employees	Add employee (ADMIN)
GET	/api/employees	Get all employees
PUT	/api/employees/{id}	Update employee
DELETE	/api/employees/{id}	Delete employee

## 👨‍💻 Author
Amrutha A
Final Year CSE | Aspiring Software Development Engineer
Preparing for SDE Internship 
Full Stack | Java | Spring Boot | DSA | Web Development


📄 License
This project is open-source and available to collaboration under the MIT License.

