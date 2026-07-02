# 🔐 IAM Server (Identity and Access Management)

A centralized **Identity and Access Management (IAM) Server** built using **Spring Boot 3** that provides secure authentication and authorization for enterprise applications using **OAuth2.0** and **OpenID Connect (OIDC)**.

This project aims to provide a production-ready authentication server with support for JWT, Role-Based Access Control (RBAC), Multi-Factor Authentication (MFA), Redis session management, and audit logging.

---

## 🚀 Project Status

> 🟢 Project Initialization Completed

### Completed
- Spring Boot 3 Project Setup
- Java 17 Configuration
- PostgreSQL Integration
- Spring Security Setup
- Spring Data JPA Configuration
- Redis Dependency Added
- Maven Project Configuration

### In Progress
- Database Design
- User Management Module
- OAuth2 Authorization Server
- OpenID Connect (OIDC)
- JWT Authentication
- RBAC
- MFA
- Token Revocation
- Audit Logging

---

# 🛠 Tech Stack

### Backend
- Java 17
- Spring Boot 3
- Spring Security
- Spring Authorization Server
- Spring Data JPA
- PostgreSQL
- Redis
- Maven

### Database
- PostgreSQL

### Cache
- Redis

### Build Tool
- Maven

### IDE
- IntelliJ IDEA

---

# 📁 Project Structure

```
src
├── main
│   ├── java
│   │   └── com.iam.iam_server
│   │       ├── config
│   │       ├── controller
│   │       ├── dto
│   │       ├── entity
│   │       ├── repository
│   │       ├── security
│   │       ├── service
│   │       ├── util
│   │       └── exception
│   │
│   └── resources
│       └── application.properties
│
└── test
```

---

# 🎯 Planned Features

- User Registration
- User Authentication
- OAuth2 Authorization Server
- OpenID Connect (OIDC)
- JWT Authentication
- Role-Based Access Control (RBAC)
- Multi-Factor Authentication (MFA)
- Redis Session Management
- Token Revocation
- Password Encryption (BCrypt)
- Audit Logging
- Rate Limiting
- Docker Deployment

---

# 🗄 Database

Current Database

```
iam_db
```

Database

- PostgreSQL 17

---

# ▶️ Getting Started

## Clone Repository

```bash
git clone https://github.com/<your-username>/iam-server.git
```

---

## Open Project

Open the project in **IntelliJ IDEA**.

---

## Configure Database

Update `application.properties`

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/iam_db
spring.datasource.username=postgres
spring.datasource.password=your_password
```

---

## Run Application

```bash
mvn spring-boot:run
```

Application will start on

```
http://localhost:8080
```

---

# 📅 Development Roadmap

### Phase 1
- Project Initialization
- PostgreSQL Configuration
- Package Structure

### Phase 2
- User Module
- Role Module
- Authority Module

### Phase 3
- Spring Security
- OAuth2 Authorization Server
- JWT

### Phase 4
- OpenID Connect
- MFA
- Redis

### Phase 5
- Audit Logs
- Rate Limiting
- Docker

---

# 👥 Team

This project is being developed collaboratively by a team of **5 members** using **Git** and **GitHub Feature Branch Workflow**.

Workflow

```
main
│
develop
│
├── feature/security
├── feature/user-management
├── feature/oauth2
├── feature/redis-mfa
└── feature/audit
```

---

# 📌 Current Version

```
v0.1.0
```

---

# 📄 License

This project is developed for educational and learning purposes.

---

## ⭐ Future Enhancements

- Single Sign-On (SSO)
- Social Login
- Email Verification
- SMS OTP
- Admin Dashboard
- API Documentation (Swagger)
- Unit & Integration Testing

---

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push the branch
5. Create a Pull Request

---

## 📧 Contact

**Shivam Sahu**

GitHub: https://github.com/ssahu121

LinkedIn: https://www.linkedin.com/in/ssahi121
