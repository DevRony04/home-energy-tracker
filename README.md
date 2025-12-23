# 🏠 Home Energy Tracker
**Event-Driven Microservices Platform for Real-Time Energy Monitoring**

A **production-ready Home Energy Tracking System** built using **Spring Boot microservices** and an **event-driven architecture** to ingest, process, and analyze real-time energy consumption data from IoT devices.

This project demonstrates **scalable backend system design**, asynchronous data processing, and modern cloud-ready architecture.

---

## 🚀 Key Features

- 📡 Real-time IoT energy data ingestion
- 🧩 Microservices-based architecture
- 🔄 Event-driven processing using Apache Kafka
- 📊 Time-series storage for energy usage analytics
- 🚨 Threshold-based alerting system
- 🧠 Insight & AI layer for analytics and predictions
- 🔐 Centralized API Gateway (auth, routing, rate limiting)
- 🐳 Fully Dockerized setup

---

## 🏗️ System Architecture

**Architecture Style:** Event-Driven Microservices

This system is documented using **both High-Level Design (HLD)** and  
**Low-Level Design (LLD)** to clearly separate *conceptual architecture* from *actual implementation*.

---

### 🔷 High-Level Architecture (HLD – Conceptual View)

This diagram represents the **overall event-driven design** and communication flow.

- Shows **synchronous (REST)** vs **asynchronous (Kafka)** interactions
- Highlights **Kafka as the central event backbone**
- Explains how ingestion, usage, alerts, and insights are loosely coupled

<img width="1354" height="811" alt="home-energy-tracker-HLD-design" src="https://github.com/user-attachments/assets/54976081-9fbb-4262-9533-21468ca44a8d" />


**Legend**
- ➝ Solid arrows → Synchronous REST calls  
- ➝ Dashed arrows → Asynchronous Kafka events  

---

### 🔷 Low-Level Architecture (LLD – Implementation View)

This diagram represents the **actual production-oriented implementation**.

- API Gateway routing
- Individual Spring Boot microservices
- Kafka producers & consumers
- Databases (MySQL, Time-Series DB)
- AI & Alert services
- Deployment-ready system view

<img width="1472" height="704" alt="home-energy-tracker-LLD-design" src="https://github.com/user-attachments/assets/6393a079-1b49-4f86-a04c-613bc5a318cc" />


> 📌 HLD explains *how the system works logically*,  
> while LLD shows *how the system is actually built and deployed*.


## 🧱 Core Services

### API Gateway
- Single entry point for all clients
- Handles authentication, routing, and rate limiting

### Device Service
- Device registration and metadata management
- Persists device data in MySQL

### User Service
- User authentication and profile management
- Persists user data in MySQL

### Ingestion Service
- Receives raw energy readings from IoT devices
- Publishes events to Kafka

### Usage Service
- Consumes energy events
- Aggregates energy usage (hourly / daily / monthly)
- Stores data in Time-Series Database

### Alert Service
- Consumes usage events
- Triggers threshold-based alerts
- Designed for asynchronous notifications

### Insight Service
- Performs analytics and trend analysis
- Integrates with AI/ML engine

---

## 🔄 Event Streaming (Kafka)

A single Kafka cluster is used with multiple topics:

| Topic Name | Description |
|-----------|------------|
| energy-readings | Raw energy readings from IoT devices |
| usage-events | Aggregated usage data |
| alert-events | Alert-triggering events |

This enables loose coupling, scalability, and fault tolerance.

---

## 🗄️ Data Storage

| Storage | Purpose |
|------|--------|
| MySQL | User and device metadata |
| Time-Series DB | Energy usage history |

---

## 🧠 Design Decisions

- Event-driven architecture to handle high-volume IoT data
- Kafka for decoupled and fault-tolerant communication
- Time-series database optimized for temporal queries
- Microservices allow independent scaling and deployment
- API Gateway improves security and observability

---

## 🛠️ Tech Stack

- Backend: Java, Spring Boot
- Architecture: Microservices, Event-Driven
- Messaging: Apache Kafka
- Databases: MySQL, Time-Series DB
- Containerization: Docker, Docker Compose
- Build Tool: Maven
- Version Control: Git & GitHub

---

## 📦 Local Setup (High-Level)

```bash
git clone https://github.com/<your-username>/home-energy-tracker.git
cd home-energy-tracker
docker compose -v up -d
```

## 🛑 Stop the system

```bash
docker compose down
```

## 📈 Scalability & Future Enhancements

- Kafka partitions and consumer groups
- Dead-letter queues (DLQ)
- Prometheus + Grafana monitoring
- Role-based access control (RBAC)
- Cloud deployment (AWS / GCP)
  
## 📄 License

- This project is licensed under the MIT License.

## 👨‍💻 Author

- Deepyaman Mondal
- Backend / Software Engineer
- Focused on scalable systems, microservices, and event-driven architectures.
