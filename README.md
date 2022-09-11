# RunningEventsWebApp

---

RESTfull web app for creating running events (existing services examples: [this](https://athletic-events.com/calendar) or [this](https://www.runbritainrankings.com/results/resultslookup.aspx)).

It is an educational project to learn Spring framework (MVC, persistence, security etc).

WORK IN [PROGRESS](#progress)


## TOC
* [Tech stack](#tech-stack)
* [Progress](#progress)
  * [General](#general)
  * [Security](#security)
  * [Testing](#testing)
* [Endpoints](#endpoints)
* [Current DB schema](#current-db-schema)

## Tech stack
<details>
 <summary>List</summary>

* Building tool:
  * Gradle


* MVC:
  * Spring boot starter web


* Security:
  * Spring boot starter security


- Persistence:
  * PostgreSQL database (I run it in Docker container)
  * Flyway Migrations
  * JPA for high level data CRUD


* Dev tools:
  * Lombok


* Documentation
  * OpenAPI 3.0
  * Swagger

</details>

## Progress

My todo list right now:
1. implement [endpoints](#endpoints). Just to make it work.
2. implement JWT
3. setup Swagger security
4. document endpoints for Swagger
5. write tests & refactor

### General
- [x] setup projects plugins(test coverage, code quality)
- [x] setup PostgreSQL DB (I run Docker image)
- [x] setup Flyway to manage DB migrations
- [x] setup OpenAPI documentation with Swagger
- implement endpoints (see [Endpoints](#endpoints) for details)
- write Swagger documentation for endpoints
- implement email notifications on (registration/sign-up/update/cancel/delete). Use Docker with MailHog for testing

### Security
- [x] roles (ADMIN, EVENT_ADMIN, USER) & permissions access separation (see [Endpoints](#endpoints) for details)
- implement JWT
- implement registration confirmation by email
- configure Swagger security

### Testing
*Haven't done any testing yet. Most things are new for me, so I'm trying to make it work for now. TDD one love :)*

- unit testing
  - unit testing of RoleRepository
  - unit testing of UserCredentialsRepository
  - unit testing of EventRepository
  - unit testing of UserRepository


- integration testing
  - integration testing for /events endpoint
  - integration testing for /register endpoint
  - integration testing for /users endpoints
  - integration testing for /accounts endpoints


- security testing
    - security testing for /register endpoint
    - security testing for /events endpoint
    - security testing for /users endpoints
    - security testing for /accounts endpoint


- end-to-end testing
  - registration
  - user account operations (get, update, delete)
  - user event operations (sign-up, show events, show upcoming events)
  - event operations (create event, update event, delete event)

## Endpoints
![](/readme_images/endpoints.png)

## Current DB schema
![](/readme_images/db_schema.png)