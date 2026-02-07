package com.example.demo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class FinancialAdvisor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advisorId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String passwordHash;

    @OneToMany(mappedBy = "advisor", cascade = CascadeType.ALL)
    private List<Client> clients;

    // Constructor initializing all fields
    public FinancialAdvisor(Long advisorId, String username, String email, String passwordHash, List<Client> clients) {
        this.advisorId = advisorId;
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
        this.clients = clients;
    }

    // No-arg constructor (required by JPA)
    public FinancialAdvisor() {}

    public Long getAdvisorId() {
        return advisorId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
