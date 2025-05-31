# Multi-Project Java Maven Repository

This repository contains multiple **independent Java projects**, each managed using **Apache Maven**. Every project is located in its own directory with its own `pom.xml` and `main` class.

Each project is **self-contained** and can be opened, built, and run separately using any Java IDE.

---

## Prerequisites

To get started, you need to have the following installed on your machine:

### 🔹 Java Development Kit (JDK)

- Install JDK 11 or newer (LTS versions like JDK 17 are recommended)
- You can download it from:
    - Oracle JDK: https://www.oracle.com/java/technologies/javase-downloads.html
    - OpenJDK: https://jdk.java.net/
- Follow the installation instructions for your operating system
- Make sure you set JAVA_HOME

### 🔹 Apache Maven

- Install the latest stable version of Apache Maven
- Download it from: https://maven.apache.org/download.cgi
- Follow the installation instructions for your operating system
- Make sure you set MAVEN_HOME

### 🔹 Docker Compose

Some projects have defined a docker compose file in the `resources/docker/docker-compose.yml` which can be used to start required docker images:

1. Open a terminal in the root of the project where the `resources/docker/docker-compose.yml` file is located

2. Run the following command:
   docker-compose up --build

3. Wait for all containers to start. Services will be accessible via the ports defined in the compose file.

4. To stop all services, press Ctrl+C and run:
   docker-compose down

---

## How to Build and Run a Project

Each subdirectory in this repository represents a standalone Maven project. To build and run any project:

1. Open the project in your preferred Java IDE, such as:
    - IntelliJ IDEA
    - Eclipse
    - Visual Studio Code (with Java extensions)

2. Build the project using the following Maven command:
   mvn clean install

3. Run the main class:
    - Locate the class annotated with **@SpringBootApplication**
    - Run it from your IDE

   The main class is usually found in `io.learnstuff.main`.

---

## Importing API Requests into Postman

Some projects in the repository include a file named `resources/postman/request-examples.json`, which contains a Postman collection of API requests related to the project.

To import this collection into Postman:

1. Open Postman

2. Click on the **"Import"** button (top-left corner)

3. Select the **request-examples.json** file from this project

4. Click **"Import"** to load the collection into your workspace

You will now see a folder in Postman containing predefined requests. 
Make sure your local services are running before sending requests.

## Notes

- These projects are not connected and do not use a shared parent pom.xml
- There is no multi-module setup — each is intended to run individually

---

> More resources at:\
> https://www.tritechdigital.io/
