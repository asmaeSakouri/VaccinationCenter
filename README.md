# VitalGuard Vaccination Center Management System

## Overview

VitalGuard is a web application built with Spring Boot and Thymeleaf to manage vaccination centers and citizens efficiently. It provides features like adding new citizens, vaccination centers, and searching for citizens based on vaccination centers.

## Features

- **Add a New Citizen:** Easily add new citizens to the system with relevant details.
- **Add a New Vaccination Center:** Register new vaccination centers along with their details.
- **Search Citizens by Vaccination Center:** Find citizens associated with a specific vaccination center.
- **Error Handling:** Properly handle errors to enhance user experience.

## Technologies Used

- Spring Boot
- Thymeleaf
- MySQL (MariaDB)
- Bootstrap

## Prerequisites

Before running the application, ensure you have:

- Java Development Kit (JDK) installed
- MySQL/MariaDB database configured
- IDE (like IntelliJ or Eclipse) for development

## Configuration

Configure your database settings in the `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/vaccination_db?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MariaDBDialect
spring.jpa.show-sql=true
server.port=8090
