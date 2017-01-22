package com.petcare.db.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class AccountHistory {

    public enum ServiceType {PROVIDE, AVAIL}

    private Long id;
    private Account account;
    private ServiceType serviceType;
    private Long balance;

    public AccountHistory() {}

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
