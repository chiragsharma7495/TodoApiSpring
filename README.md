# FirstSpringProject

## Overview

This project is a small Spring Boot REST API built with Java 17 and Spring Boot 4.1.0.
So far, we have created a simple in-memory TODO application that can return and create todo items.

## What has been done so far

- Set up the Spring Boot application entry point in `FirstSpringProjectApplication`.
- Created a `Todo` model with the following fields:
  - `id`
  - `completed`
  - `title`
  - `userId`
- Added a `TodoController` REST controller.
- Seeded the application with two initial todo items in memory.
- Implemented a `GET /todos` endpoint to return all todos.
- Implemented a `POST /todos` endpoint to add a new todo to the list.
- Added a basic Spring Boot test to verify that the application context loads.

## Current API

### `GET /todos`
Returns the current list of todo items.

### `POST /todos`
Accepts a JSON todo object in the request body and adds it to the in-memory list.

Example request body:

```json
{
  "id": 3,
  "completed": false,
  "title": "Learn Spring Boot",
  "userId": 1
}
```

## Project structure

- `src/main/java/org/example/firstspringproject/FirstSpringProjectApplication.java` - Spring Boot startup class
- `src/main/java/org/example/firstspringproject/Todo.java` - Todo model
- `src/main/java/org/example/firstspringproject/TodoController.java` - REST controller
- `src/test/java/org/example/firstspringproject/FirstSpringProjectApplicationTests.java` - smoke test

## How to run

Use the Gradle wrapper from the project root:

```powershell
.\gradlew bootRun
```

To run the tests:

```powershell
.\gradlew test
```

## Notes

- The todo list is stored only in memory, so all data is reset when the application restarts.
- This is an early version of the project, and more features can be added later such as update, delete, and persistent storage.
