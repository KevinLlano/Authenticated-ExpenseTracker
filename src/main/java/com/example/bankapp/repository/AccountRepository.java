package com.example.bankapp.repository;

// Importing the Account model and JpaRepository for database interactions
import com.example.bankapp.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// AccountRepository interface for managing Account entities in the database
// Extends JpaRepository to provide CRUD operations and query methods
public interface AccountRepository extends JpaRepository<Account, Long> {

    // Custom query method to find an Account by its username
    // Returns an Optional<Account> to handle cases where the account might not exist
    Optional<Account> findByUsername(String username);
}