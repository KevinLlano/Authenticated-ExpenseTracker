# SpringBoot Expense Tracker

## Overview
> This Project Showcases Crud-based MVC  

## How to Replicate the Project

Step 1. **Project Setup with Spring Boot and Thymeleaf**
    - Initialize a Spring Boot project with dependencies for Spring Data JPA, Thymeleaf, and Web. Organize the structure into `config`, `controller`, `model`, `repository`, and `service` packages.

Step 2. **Database Configuration**
    - Configure `application.properties` with MySQL database credentials, Hibernate settings, and datasource URL.

Step 3. **Entity and Repository Creation**
    - Define `Account` and `Transaction` entities in `model`. Create `AccountRepository` and `TransactionRepository` for database operations.

Step 4. **Service Layer Implementation**
    - Implement `AccountService` in `service` to handle business logic.

Step 5. **Controller Setup**
    - Use `BankController` in `controller` to handle routes for dashboard, deposit, withdraw, and transfer operations.

Step 6. **Frontend with Thymeleaf Templates**
    - Develop Thymeleaf templates (`dashboard.html`, `login.html`, `register.html`, etc.) to display data from the backend.

Step 7. **Security Configuration**
    - Configure `SecurityConfig` in `config` to manage login and access control.

Step 8. **Testing CRUD Operations**
    - Test:
        - **Create**: Register new accounts.
        - **Read**: View account details and balance.
        - **Update**: Perform deposits, withdrawals, and transfers.
        - **Delete**: Withdraw to reduce balance.

Step 9. **Run and Verify the Application**
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
![image](https://github.com/user-attachments/assets/7675f5fd-2b9c-4cfc-94c1-a555084398f5)
![image](https://github.com/user-attachments/assets/60a5cccb-75c6-4c83-8e91-65d617bb6469)
![image](https://github.com/user-attachments/assets/dcaad99e-f740-41d9-add9-a96eca1070eb)
![image](https://github.com/user-attachments/assets/a7f23848-7b1f-4f7d-a4ea-a37467144bc0)
![image](https://github.com/user-attachments/assets/89fa3169-a438-4fd2-b67d-1019fa99685b)













