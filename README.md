# Implementation of frontend and backend of a fictional public transport company's website
The website implements all the fundamental options of safe login, database Oracle SQL Database connection with CRUD operations and Role Based Access to stored data. 
### Technologies used:
* Spring Boot and Spring Security
* Jakarta Persistance (for more elegant object handling than with JDBC)
* Project Lombok (for more readable, boilerplate-free code)
### Basic overeview:
The project has a fairly standard structure, with JpaRepository interfaces for each table from the database and model and service classes to handle the tables' representation as Java object and the CRUD operations on them. 
User interactions are handled by web controllers and they are divided into two roles of "admin" and "employee" with different privileges and separate web controllers.
### Features:
* Division between user roles
* Performing CRUD operations
