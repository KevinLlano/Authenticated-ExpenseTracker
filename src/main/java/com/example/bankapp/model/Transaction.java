package com.example.bankapp.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    // Primary key for the Transaction entity, auto-generated using IDENTITY strategy
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // The amount involved in the transaction
    private BigDecimal amount;

    // Type of transaction (e.g., "deposit", "withdrawal")
    private String type;

    // Timestamp indicating when the transaction occurred
    private LocalDateTime timestamp;

    // Many-to-one relationship to the Account entity, with a foreign key column "account_id"
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    // Default constructor for JPA
    public Transaction() {}

    // Parameterized constructor to initialize Transaction fields
    public Transaction(BigDecimal amount, String type, LocalDateTime timestamp, Account account) {
        this.amount = amount;
        this.type = type;
        this.timestamp = timestamp;
        this.account = account;
    }

    // Getter for id
    public Long getId() {
        return id;
    }

    // Getter for amount
    public BigDecimal getAmount() {
        return amount;
    }

    // Setter for amount
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    // Getter for type
    public String getType() {
        return type;
    }

    // Setter for type
    public void setType(String type) {
        this.type = type;
    }

    // Getter for timestamp
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Setter for timestamp
    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    // Getter for account
    public Account getAccount() {
        return account;
    }

    // Setter for account
    public void setAccount(Account account) {
        this.account = account;
    }

}
