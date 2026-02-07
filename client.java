package com.example.demo.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "advisor_id", nullable = false)
    private FinancialAdvisor advisor;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Security> securities;

    // Constructor initializing all fields
    public Client(Long clientId, String firstName, String lastName,
                  FinancialAdvisor advisor, List<Security> securities) {
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.advisor = advisor;
        this.securities = securities;
    }

    // No-arg constructor
    public Client() {}

    public Long getClientId() {
        return clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public FinancialAdvisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(FinancialAdvisor advisor) {
        this.advisor = advisor;
    }

    public List<Security> getSecurities() {
        return securities;
    }

    public void setSecurities(List<Security> securities) {
        this.securities = securities;
    }
}
