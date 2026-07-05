# 📓 JournalApp2026

A secure and scalable **Spring Boot REST API** for managing personal journal entries with **JWT Authentication**, **Role-Based Authorization**, **MongoDB Atlas**, **Redis Cloud**, **Apache Kafka (Confluent Cloud)**, **Weather API**, **Email Notifications**, **Sentiment Analysis**, and **Docker** support.

---

## 🚀 Features

- 🔐 JWT Authentication & Authorization
- 👤 User Registration & Login
- 📝 Create, Read, Update & Delete (CRUD) Journal Entries
- 🛡️ Spring Security Integration
- 🌤️ Weather API Integration
- 💌 Email Notification Service
- 😊 Sentiment Analysis using Kafka
- ⚡ Redis Cloud Caching
- 📦 Apache Kafka with Confluent Cloud
- 🗄️ MongoDB Atlas Database
- 🐳 Dockerized Application
- ⏰ Scheduled Tasks (Cron Jobs)
- 👨‍💼 Role-Based Access Control (Admin/User)

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| Java 17 | Programming Language |
| Spring Boot | Backend Framework |
| Spring Security | Authentication & Authorization |
| JWT | Secure Authentication |
| MongoDB Atlas | Database |
| Redis Cloud | Caching |
| Apache Kafka | Event Streaming |
| Confluent Cloud | Managed Kafka Service |
| Docker | Containerization |
| Maven | Dependency Management |

---

## 🏗️ Architecture

```
                 Client
                    │
                    ▼
          Spring Security + JWT
                    │
                    ▼
             REST Controllers
                    │
                    ▼
              Service Layer
          ↙         ↓         ↘
     MongoDB     Redis      Kafka
       Atlas      Cloud   (Confluent)
```

---

## 📂 Project Structure

```
src
├── controller
├── service
├── repository
├── entity
├── config
├── scheduler
├── cache
├── api
├── model
├── enums
├── utils
└── resources
```

---

## ⚙️ Environment Variables

Configure the following environment variables before running the application:

- MongoDB URI
- MongoDB Database Name
- JWT Secret Key
- Redis Host
- Redis Port
- Redis Password
- Kafka Bootstrap Servers
- Kafka API Key
- Kafka API Secret
- Gmail Username
- Gmail App Password
- Weather API Key

> **Note:** Never commit real credentials to GitHub. Use environment variables or secret managers.

---

## ▶️ Running the Application

### Clone Repository

```bash
git clone https://github.com/Ashu-444/journalApp2026.git
cd journalApp2026
```

### Build

```bash
mvn clean install
```

### Run

```bash
mvn spring-boot:run
```

---

## 🐳 Docker

Build Docker Image

```bash
docker build -t journalapp .
```

Run Container

```bash
docker run -p 8080:8080 journalapp
```

---

## 📌 REST APIs

- User APIs
- Journal Entry APIs
- Admin APIs
- Public APIs

---

## 🔒 Security

- JWT Authentication
- Spring Security
- Password Encryption
- Role-Based Authorization

---

## 🚀 Deployment

The application is designed for cloud deployment and can be deployed on platforms such as **Render** using environment variables for secure configuration.

---

## 🔮 Future Enhancements

- Swagger/OpenAPI Documentation
- CI/CD Pipeline
- Kubernetes Deployment
- Monitoring with Prometheus & Grafana
- API Rate Limiting
- OAuth2 Login
- Unit & Integration Test Coverage Improvements

---

## 👨‍💻 Author

**Ashutosh Srivastava**

GitHub: https://github.com/Ashu-444
