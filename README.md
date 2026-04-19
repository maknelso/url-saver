🔗 URL-Saver Backend
A production-ready Spring Boot 3.4 service for persisting and managing URLs, built with a focus on clean architecture and immutability.

🛠 Tech Stack
Java 17 (LTS) - Core runtime

Spring Boot 3.4.x - Application framework

PostgreSQL - Relational database

Lombok - Boilerplate reduction

JUnit 5 / Mockito - Unit and integration testing

🚀 Key Features
RESTful API: Full CRUD support for URL records.

Constructor Injection: Strictly follows Spring's recommended Dependency Injection patterns for better testability.

Modern Testing: Utilizes MockMvc and @MockBean to achieve high test coverage without database overhead.

🏗 Architectural Decisions
Immutability: All dependencies are marked final and injected via @RequiredArgsConstructor to prevent side effects.

LTS Stability: Built on Java 17 to ensure long-term support and industry alignment.

🧪 Getting Started
Clone & Build:

Bash
git clone https://github.com/nelson-mak/url-saver.git
./mvnw clean test
Run Locally:

Bash
./mvnw spring-boot:run