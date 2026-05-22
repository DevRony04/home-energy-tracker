# AGENTS.md

Purpose

- Document CI/CD agents, build/test/deploy responsibilities and recommended Dockerfile locations for this repository (
  Spring Boot, Maven, Java 21, SQL, microservice architecture).

Repository snapshot

- Branch: ai-agents-md-file
- Tech stack: Java 21, Spring Boot, Maven, SQL
- Architecture: microservices (multiple services expected)

Agent roles and recommendations

1. Build agent (Maven)
    - Image: `maven:3.9-jdk-21-slim` (or a custom image with Maven and JDK 21).
    - Responsibilities: compile, run unit tests, produce artifacts (`target/*.jar`).

2. Docker build agent
    - Use Docker Buildx (multi-platform) or standard Docker engine.
    - Base image recommendation for runtime: `openjdk:21-jdk-slim`.
    - Recommended Dockerfile pattern per service: `services/<service-name>/Dockerfile`.
    - Provide a single CI-friendly "main" Dockerfile per service using a multi-stage build (build in Maven image, copy
      JAR to runtime image).

3. Test/Integration agent
    - Run unit tests, integration tests, and DB migrations against ephemeral DB (use Testcontainers or a DB container).
    - Responsibilities: code coverage, integration suites, contract tests.

4. Security and scanning agents
    - Static analysis: SpotBugs/PMD/Checkstyle run in build agent.
    - Container scanning: Trivy or Snyk after image build.
    - Dependency scanning: OWASP Dependency-Check or OSS scanning.

5. DB migration agent
    - Run Flyway or Liquibase migrations during CI/CD before integration tests or at deploy time.

6. Deploy agent
    - For Kubernetes: `kubectl` / `helm` runner, or use GitOps agent.
    - For Docker Compose: runner with Docker Compose v2 support.
    - Push images to registry (Docker Hub, GitHub Packages, or private registry) from the Docker build agent.

CI pipeline outline (high-level)

- Checkout
- Set JDK 21
- Build with Maven (skip tests optional), run unit tests
- Run static analysis, coverage
- Build Docker image (multi-stage), tag with semantic version / commit SHA
- Scan image
- Push image to registry
- Deploy to staging (helm/k8s or compose), run integration tests
- Promote to production via manual approval

Files and paths to check / create

- `services/<service-name>/Dockerfile` (one per microservice)
- `docker/Dockerfile` (optional central builder)
- `.github/workflows/ci.yml` (GitHub Actions) or relevant pipeline config
- `docker-compose.yml` (for local multi-service integration)
- Add `AGENTS.md` at repository root (this file)

Notes / conventions

- Use Java 21 as runtime; ensure Maven toolchain/CI sets `JAVA_HOME` accordingly.
- Semantic versioning for images and tags; include commit SHA.
- Prefer ephemeral test DBs (Testcontainers) in CI to avoid shared-state flakiness.

Example Dockerfile pattern (multi-stage)

- Build stage: `maven:3.9-jdk-21-slim` to run `mvn -DskipTests package`
- Runtime stage: `openjdk:21-jdk-slim`, copy `app.jar`, and run with a non-root user

End of `AGENTS.md`
