Spring Boot JWT Authentication and OAuth Role-Based Authorization

**Project Overview :-
This project is a Spring Boot application that implements user authentication using JWT (JSON Web Token) and role-based authorization using OAuth. 
Users can log in with valid credentials to receive a JWT token for subsequent authenticated requests. The application has two main roles: ADMIN and USER, 
with varying access rights based on the assigned role.

** JWT Authentication and OAuth Role-Based Authorization:-
1.Objective: Implement authentication and authorization for the Spring Boot project.
2.Authentication: Uses JWT (JSON Web Token) for user authentication. On successful login, a JWT token is generated and returned to the client.
3.Authorization: Role-based access control is implemented using OAuth.

** Two roles are defined:
Admin: Has access to all resources and administrative functions.
User: Has limited access to user-specific resources but cannot access admin functionalities.

** Features
1.JWT Authentication: Users authenticate by providing a username and password. A valid JWT token is issued on successful authentication.
2.Role-Based Access Control: Users are granted different access rights based on their assigned role.
3.Admin users can access administrative functions.
4.Normal users are restricted to basic functionality.
5.Password Encryption: User passwords are securely stored using BCryptPasswordEncoder.
6.Stateless API: Security is implemented statelessly using JWT, making session management unnecessary.


** Technologies Used
Java 17
Spring Boot 3.x
Spring Security
Spring Data JPA
JWT (JSON Web Token)
OAuth 2.0
MySQL Database
Hibernate ORM
Maven
Lombok
