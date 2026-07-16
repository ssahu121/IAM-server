🔐 IAM Server (Identity & Access Management)

A secure Identity and Access Management (IAM) Server built using Spring Boot, Spring Security, JWT Authentication, Role-Based Access Control (RBAC), and PostgreSQL. The project provides secure authentication, authorization, user management, role management, permission management, and password recovery APIs.

🚀 Features
Authentication
User Registration
User Login
JWT Token Generation
JWT Authentication
Secure API Access
User Management
View Profile
Update Profile
Change Password
Password Management
Forgot Password
Reset Password using Token
Role Management
Create Role
View Roles
Assign Role to User
Permission Management
Create Permission
View Permissions
Assign Permission to Role
API Documentation
Swagger UI Integration
JWT Authorization Support in Swagger
🛠️ Tech Stack
Java 21
Spring Boot 3.5.x
Spring Security
Spring Data JPA
PostgreSQL
JWT (JSON Web Token)
Maven
Lombok
Swagger / OpenAPI
Hibernate
📂 Project Structure
src
├── controller
├── service
│   ├── impl
├── repository
├── entity
├── dto
├── security
├── config
├── exception
└── util
🔑 Authentication Flow
User registers using the Register API.
User logs in with username and password.
Server authenticates the user.
A JWT Access Token is generated.
Client sends the JWT token in the Authorization header.
Protected APIs are accessed after successful token validation.
🔒 RBAC (Role-Based Access Control)
Users can have multiple Roles.
Roles can have multiple Permissions.
Permissions determine which operations a user is allowed to perform.
Supports scalable authorization using Spring Security.
📌 Main APIs
Authentication
POST /auth/register
POST /auth/login
POST /auth/forgot-password
POST /auth/reset-password
User
GET /users/profile
PUT /users/profile
PUT /users/change-password
Role
POST /roles
GET /roles
Permission
POST /permissions
GET /permissions
Role & Permission
POST /roles/{roleId}/permissions/{permissionId}
POST /users/{userId}/roles/{roleId}
📖 Swagger Documentation
http://localhost:8080/swagger-ui/index.html

Swagger includes JWT Bearer Authentication support for testing secured APIs.

🗄️ Database

Database: PostgreSQL

Main Tables:

users
roles
permissions
user_roles
role_permissions
password_reset_tokens
▶️ Run the Project
Clone Repository
git clone <repository-url>
Configure Database

Update the PostgreSQL configuration in:

application.properties
Run
mvn clean install
mvn spring-boot:run
📷 API Testing

The APIs can be tested using:

Swagger UI
Postman
📈 Future Enhancements
Email-based Password Reset
Refresh Token Support
Audit Logging
Docker Support
Kubernetes Deployment
Unit & Integration Testing
OAuth2 / Google Login
API Rate Limiting
👨‍💻 Author

Shivam Sahu

Java Full Stack Developer

⭐ Project Highlights
JWT Authentication
Spring Security
Role-Based Access Control (RBAC)
Secure REST APIs
PostgreSQL Integration
Swagger Documentation
Clean Architecture
Industry-Oriented IAM Design
