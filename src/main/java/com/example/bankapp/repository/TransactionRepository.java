package com.example.bankapp.repository;

// Importing the Transaction model and JpaRepository for database operations
import com.example.bankapp.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// TransactionRepository interface for managing Transaction entities in the database
// Extends JpaRepository to inherit standard CRUD operations and query methods
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Custom query method to find all Transactions associated with a specific Account ID
    // Returns a List of Transaction objects that belong to the given Account
    List<Transaction> findByAccountId(Long accountId);
}