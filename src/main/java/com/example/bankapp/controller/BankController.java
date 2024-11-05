package com.example.bankapp.controller;

import com.example.bankapp.model.Account;
import com.example.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class BankController {

    @Autowired
    private AccountService accountService;

    // Displays the dashboard with account details for the logged-in user
    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Account account = accountService.findAccountByUsername(username);
        model.addAttribute("account", account);
        return "dashboard";
    }

    // Shows the registration form page
    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    // Registers a new account; redirects to login on success or shows error on failure
    @PostMapping("/register")
    public String registerAccount(@RequestParam String username, @RequestParam String password, Model model) {
        try {
            accountService.registerAccount(username, password);
            return "redirect:/login";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }

    // Displays the login page
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // Processes a deposit for the logged-in user, then redirects to dashboard
    @PostMapping("/deposit")
    public String deposit(@RequestParam BigDecimal amount) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Account account = accountService.findAccountByUsername(username);
        accountService.deposit(account, amount);
        return "redirect:/dashboard";
    }

    // Processes a withdrawal; handles insufficient funds and displays error if any
    @PostMapping("/withdraw")
    public String withdraw(@RequestParam BigDecimal amount, Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Account account = accountService.findAccountByUsername(username);

        try {
            accountService.withdraw(account, amount);
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage()); // Error for insufficient funds
            model.addAttribute("account", account); // Reattach account details for display
            return "dashboard";
        }

        return "redirect:/dashboard";
    }

    // Displays transaction history for the logged-in user
    @GetMapping("/transactions")
    public String transactionHistory(Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Account account = accountService.findAccountByUsername(username);
        model.addAttribute("transactions", accountService.getTransactionHistory(account));
        return "transactions";
    }

    // Processes a transfer to another user; shows error if recipient not found or insufficient funds
    @PostMapping("/transfer")
    public String transferAmount(@RequestParam String toUsername, @RequestParam BigDecimal amount, Model model) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        Account fromAccount = accountService.findAccountByUsername(username);

        try {
            accountService.transferAmount(fromAccount, toUsername, amount);
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage()); // Error message on failure
            model.addAttribute("account", fromAccount); // Reattach account details for display
            return "dashboard";
        }

        return "redirect:/dashboard";
    }
}
