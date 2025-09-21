
# TechExchange Hub

A lightweight **Q&A platform skeleton** with a Spring Boot backend and a React (CDN) frontend.
- **Backend**: Java 17, Spring Boot 3, MongoDB, simple JWT utility, CORS enabled
- **Frontend**: React via CDN (no build step), minimal fetch demo
- **Infra**: Docker Compose for MongoDB

> This repo is intentionally minimal so recruiters can skim fast and you can extend quickly.

## Quick Start

### 1) Start MongoDB (Docker)
```bash
docker-compose up -d
# Mongo runs on localhost:27017 (user/pass not required for local dev)
```

### 2) Run Backend (Spring Boot)
```bash
# from backend/
./mvnw spring-boot:run    # if mvnw not available, use: mvn spring-boot:run
# Backend on http://localhost:8080
```

### 3) Frontend (static React page via Node or any static server)
```bash
# from frontend/
node server.js
# Frontend on http://localhost:3000
```

## Test Endpoints
- `GET /api/health` → `{"status":"ok"}`
- `GET /api/questions` → list questions (seeded in memory if Mongo empty)
- `POST /api/auth/login` → `{ token: "<jwt>" }` (demo only; not for production)
- CORS is enabled for `http://localhost:3000`

## Notes
- JWT auth is **demo** only; extend with Spring Security filters to enforce protection on routes.
- Mongo repository and entity are provided; you can wire real CRUD quickly.
