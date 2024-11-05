package com.example.bankapp.model;

import jakarta.persistence.*;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

// Specifies that this class is a JPA entity mapped to a database table
@Entity
public class Account implements UserDetails {

    // Primary key with auto-generated value using the IDENTITY strategy
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Username for the account
    private String username;

    // Password for the account
    private String password;

    // Balance in the account, represented as a BigDecimal
    private BigDecimal balance;

    // One-to-many relationship with the Transaction entity, mapped by the "account" field in Transaction
    @OneToMany(mappedBy = "account")
    private List<Transaction> transactions;

    // Transient field that holds the authorities or roles, not stored in the database
    @Transient
    private Collection<? extends GrantedAuthority> authorities;

    // Default constructor for JPA
    public Account() {
    }

    // Parameterized constructor for setting initial values for account properties
    public Account(String username, String password, BigDecimal balance, List<Transaction> transactions, Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.transactions = transactions;
        this.authorities = authorities;
    }

    // Returns the authorities/roles assigned to this account (required by UserDetails interface)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    // Setter for authorities
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    // Getter for account ID
    public Long getId() {
        return id;
    }

    // Setter for account ID
    public void setId(Long id) {
        this.id = id;
    }

    // Getter for username
    public String getUsername() {
        return username;
    }

    // Setter for username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter for password (required by UserDetails interface)
    @Override
    public String getPassword() {
        return password;
    }

    // Setter for password
    public void setPassword(String password) {
        this.password = password;
    }

    // Getter for account balance
    public BigDecimal getBalance() {
        return balance;
    }

    // Setter for account balance
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    // Getter for list of transactions associated with this account
    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Setter for transactions
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
