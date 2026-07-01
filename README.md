## GetHired-Job-Portal / Job Service

## 📌 Overview
The Job Service is a core microservice of the AI-Powered Job Portal responsible for managing job postings and job-related operations. It allows recruiters to create, update, delete, and manage job listings while enabling job seekers to browse and search available jobs. The service follows a RESTful Microservices Architecture and communicates with other services through Spring Cloud Eureka and OpenFeign. It is secured by the API Gateway, where JWT authentication and role-based authorization are performed.

---

## 🚀 Features
- Create Job
- Update Job
- Delete Job
- Get Job by ID
- Get All Jobs
- Search Jobs
- Filter Jobs
- Recruiter Job Management
- MySQL Database Integration
- Spring Data JPA
- Bean Validation
- Exception Handling
= Eureka Client Registration
= Docker Support

---

## 🏗 Microservice Architecture

<img width="1536" height="1024" alt="ChatGPT Image Jul 1, 2026, 07_37_16 PM" src="https://github.com/user-attachments/assets/54696d9f-a306-4abe-b25e-03fb53e2a7e0" />


---

## 🛠 Tech Stack
## Backend
- Java 21
- Spring Boot
- Spring Data JPA
- Spring Validation
- Spring Web
- OpenFeign
- Maven
## Database
- MySQL 8+
## Service Discovery
- Netflix Eureka Client
## Build Tool
- Maven

---

## 📦 Maven Dependencies
The project uses the following dependencies:
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter Validation
- Spring Boot Starter Test
- Spring Cloud OpenFeign
- Spring Cloud Netflix Eureka Client
- MySQL Connector
- Lombok

---

## 📁 Project Structure
<img width="527" height="863" alt="Screenshot 2026-07-01 193556" src="https://github.com/user-attachments/assets/5f60043d-2a32-49d9-aaf1-c0080ca99bc4" />

---

## 🗄 Database Configuration

## Database Name

- job_db

- Create Database

- CREATE DATABASE job_db;

## application.properties
- spring.datasource.url=jdbc:mysql://localhost:3306/job_db

- spring.datasource.username=root

- spring.datasource.password=your_password

- spring.jpa.hibernate.ddl-auto=update

- spring.jpa.show-sql=true

- spring.jpa.properties.hibernate.format_sql=true

---

## 📡 REST API Endpoints
## Create Job
- POST /jobs

- Request

- {
-  "title":"Java Developer",
-  "company":"ABC Technologies",
-  "location":"Pune",
-  "jobType":"Full-Time",
-  "experience":"2 Years",
-  "salary":800000,
-  "skills":"Java, Spring Boot, MySQL",
-  "description":"Looking for experienced Java developers."
- }
## Get All Jobs
- GET /jobs
## Get Job By ID
- GET /jobs/{id}
## Update Job
- PUT /jobs/{id}
## Delete Job
- DELETE /jobs/{id}
## Search Jobs
- GET /jobs/search?keyword=java

---

## ▶ Running the Service

## Clone Repository

- git clone https://github.com/yourusername/job-service.git

## Move into Project

- cd job-service

## Build Project

- mvn clean install

## Run Application

- mvn spring-boot:run
