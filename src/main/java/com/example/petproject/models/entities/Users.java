package com.example.petproject.models.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class Users extends BaseEntity {
    private List<Offers> offers;
    private Roles role;
    private String email;
    private String password;
    private String fullName;
    private Date birthday;

    protected Users() {}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.REMOVE)
    public List<Offers> getOffers() {
        return offers;
    }
    public void setOffers(List<Offers> offers) {
        this.offers = offers;
    }

    @ManyToOne
    @JoinColumn(name = "role_id")
    public Roles getRole() {
        return role;
    }
    public void setRole(Roles role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
