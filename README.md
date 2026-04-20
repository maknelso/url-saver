URL-Saver Backend
Prod-ready Spring Boot 3.4 service for persisting and managing URLs in PostgreSQL db,
built with a focus on clean architecture and immutability.

Developed a high-performance URL management service using Spring Boot and PostgreSQL. Implemented a decoupled architecture using Dependency Injection and Spring Data JPA, and established a full-scale observability pipeline using Prometheus and Grafana for real-time monitoring.

Tech Stack
- Java 17
- Spring Boot 3.4
- PostgreSQL db
- Lombok for boilerplate reduction
- JUnit 5 / Mockito for testing
- Github actions for CI/CD
- Prometheus and Grafana for monitoring and visualization

Key Features
- RESTful API: Full CRUD support for URL records.
- Constructor Injection: Follows Spring's recommended Dependency Injection patterns for better testability.
- Testing: Utilizes MockMvc and @MockBean to achieve high test coverage without database overhead.

Learnings
1. Multi layered service
Follows separation of concerns to ensure web logic, business logic, and data persistence are decoupled.
- Presentation Layer (Spring Web): Implemented RESTful controllers using @RestController. Layer handles HTTP request mapping,
- status codes, JSON serial and deserial
- Data Access Layer (Spring Data JPA): Used Repository pattern by extending `JpaRepository`. This allows for all CRUD ops without writing manual SQL.
- Domain Model (JPA Entities): Used `@Entity` and `@Table` anontations to map Java objs directly to PostgreSQL schema. 

2. DI and IoC
- Constructor Injection: `UrlController` specifies its dependency on `UrlRepository` via constructor. Allows for testability and loose coupling.

3. Automated DB Lifecycle
- Use Hibernate's ddl-auto feature to synch Java Entity state with PostgreSQL db

4. Observability Stack
- Spring Boot Actuator: Exposes `/metrics` endpoint that provides insights into JVM and app health
- Micrometer: Translates Spring internal metrics to readable format for Prometheus
- Prometheus & Grafana: Orchestrated via Docker Compose. Prometheus scrapes app data at regular intervals and
Grafana visualizes scrapped data

5. Build and Dependency Management (Maven)
- Managed project using Maven. Configured `pom.xml` to package app as standalone executable JAR 

6. Containerization (Docker)
Where infra (PostgreSQL, Prometheus, and Grafana) are containerized. 

Architectural Decisions
- Immutability: All dependencies are marked final and injected via @RequiredArgsConstructor to prevent side effects.
- LTS Stability: Built on Java 17 to ensure long-term support and industry alignment.

Future implementation:
- Alerts
- Distributed tracing with (Jaeger or Zipkin)
- Log aggregation (Loki)
- Docker Volumes for persistence 

Getting Started
Clone and build
```bash
git clone https://github.com/nelson-mak/url-saver.git
cd url-saver
./mvnw clean package -DskipTests
```

Launch infra
```bash
docker-compose up -d
```

Run app
```bash
./mvnw spring-boot:run
```

Observability dashboards (once app is running)
Prometheus: http://localhost:9090
Grafana: http://localhost:3000 
Health Check: http://localhost:8080/actuator/health