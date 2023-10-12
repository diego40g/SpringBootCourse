package com.dipaz.spring.user.service.user.service.model;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="usuarios")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "email")
    private String email;
    @Column(name = "active")
    private boolean active;
    public User() {
        super();
    }

    public User(String firstname, String lastname, String email, boolean active) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.active = active;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
