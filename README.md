--- Employee Management REST API
A secure, production-ready Employee Management System built using **Spring Boot**, **JWT Authentication**, and **PostgreSQL**, deployed on **Render Cloud** with Docker.

---
## 🚀 Live Demo
Base URL:
[https://employeeapi-1-ub9x.onrender.com/](https://employeeapi-1-ub9x.onrender.com/)

**Swagger API Docs:**
[https://employeeapi-1-ub9x.onrender.com/swagger-ui/index.html](https://employeeapi-1-ub9x.onrender.com/swagger-ui/index.html)

## 📌 Features

*  JWT Authentication & Authorization
*  Role-based Access Control (Admin / User)
*  Employee CRUD Operations
*  Pagination & Sorting
*  PostgreSQL Cloud Database
*  Dockerized Application
*  Deployed on Render
*  Swagger API Documentation
*  pring Security with BCrypt Password Encoding

## 🛠 Tech Stack
Backend:
* Java 17
* Spring Boot 3
* Spring Security
* Spring Data JPA
* JWT (JSON Web Token)

Database:
* PostgreSQL (Render Cloud)

DevOps & Tools:
* Docker
* Maven
* Render Cloud
* Swagger OpenAPI


## 🔑 Authentication APIs
| Method | Endpoint             | Description           |
| ------ | -------------------- | --------------------- |
| POST   | `/api/auth/register` | Register new user     |
| POST   | `/api/auth/login`    | Login & get JWT token |

## 👨‍💼 Employee APIs

| Method | Endpoint              | Description        |
| ------ | --------------------- | ------------------ |
| GET    | `/api/employees`      | Get all employees  |
| GET    | `/api/employees/{id}` | Get employee by ID |
| POST   | `/api/employees`      | Create employee    |
| PUT    | `/api/employees/{id}` | Update employee    |
| DELETE | `/api/employees/{id}` | Delete employee    |

⚙ Local Setup

```bash
git clone https://github.com/Amrutha-space/EmployeeAPI.git
cd EmployeeAPI
mvn clean install
mvn spring-boot:run
```

## 🐳 Docker Run

```bash
docker build -t employeeapi .
docker run -p 8080:8080 employeeapi
```

## 📂 Project Structure

```
com.example.employeeapi
 ├── controller
 ├── service
 ├── repository
 ├── security
 ├── entity
 └── config
```

## 🎯 Learning Outcomes

* Secure REST API design
* JWT implementation
* Spring Security filters
* Cloud deployment with Docker
* PostgreSQL production configuration
* Role-based authorization
* Swagger documentation
* DevOps deployment workflow
* 
## ⭐ If you like this project

Please give a ⭐ on GitHub and feel free to fork and contribute.
