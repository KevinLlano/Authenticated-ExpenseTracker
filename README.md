# SpringBoot Expense Tracker

## Overview
> This Project Showcases Crud-based MVC  

## How to Replicate the Project

1. **Project Setup with Spring Boot and Thymeleaf**
    - Initialize a Spring Boot project with dependencies for Spring Data JPA, Thymeleaf, and Web. Organize the structure into `config`, `controller`, `model`, `repository`, and `service` packages.

2. **Database Configuration**
    - Configure `application.properties` with MySQL database credentials, Hibernate settings, and datasource URL.

3. **Entity and Repository Creation**
    - Define `Account` and `Transaction` entities in `model`. Create `AccountRepository` and `TransactionRepository` for database operations.

4. **Service Layer Implementation**
    - Implement `AccountService` in `service` to handle business logic.

5. **Controller Setup**
    - Use `BankController` in `controller` to handle routes for dashboard, deposit, withdraw, and transfer operations.

6. **Frontend with Thymeleaf Templates**
    - Develop Thymeleaf templates (`dashboard.html`, `login.html`, `register.html`, etc.) to display data from the backend.

7. **Security Configuration**
    - Configure `SecurityConfig` in `config` to manage login and access control.

8. **Testing CRUD Operations**
    - Test:
        - **Create**: Register new accounts.
        - **Read**: View account details and balance.
        - **Update**: Perform deposits, withdrawals, and transfers.
        - **Delete**: Withdraw to reduce balance.

9. **Run and Verify the Application**
    - Launch the Spring Boot app on `localhost:8080` and verify all features work as expected.

---

## Highlights - Technologies Used
- **SpringBoot**
- **Thymeleaf**
- **MySQL**


## Key Functionality
- Track and manage user accounts and transactions.
- CRUD operations (Create, Read, Update, Delete) for account management.
- Simple interface for depositing, withdrawing, and transferring funds.

## Challenges Overcome
- Configuring MySQL database authentication with the Spring Boot application.
- Implementing secure authentication and authorization for users.
- Ensuring smooth integration between front-end (Thymeleaf) and back-end (Spring Boot) components.

## Screenshots
> Include screenshots here to demonstrate the setup and deployment.
![img.png](img.png)
![img_3.png](img_3.png)
![img_2.png](img_2.png)
![img_4.png](img_4.png)











