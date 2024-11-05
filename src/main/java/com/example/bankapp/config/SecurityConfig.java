package com.example.bankapp.config;


import com.example.bankapp.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    AccountService accountService; // Injects the AccountService for user details

    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Defines BCryptPasswordEncoder as the password encoder
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disables CSRF protection
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/register").permitAll() // Allows public access to the register page
                        .anyRequest().authenticated() // Requires authentication for all other requests
                )
                .formLogin(form -> form
                        .loginPage("/login") // Sets custom login page URL
                        .loginProcessingUrl("/login") // Sets the URL for processing login requests
                        .defaultSuccessUrl("/dashboard", true) // Redirects to dashboard on successful login
                        .permitAll() // Allows everyone access to the login page
                )
                .logout(logout -> logout
                        .invalidateHttpSession(true) // Invalidates the session on logout
                        .clearAuthentication(true) // Clears authentication data on logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // URL for logout
                        .logoutSuccessUrl("/login?logout") // Redirects to login with a logout message
                        .permitAll() // Allows everyone access to the logout URL
                )
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.sameOrigin()) // Allows frames from the same origin
                );

        return http.build(); // Builds the security configuration
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountService).passwordEncoder(passwordEncoder());
    }



















}
