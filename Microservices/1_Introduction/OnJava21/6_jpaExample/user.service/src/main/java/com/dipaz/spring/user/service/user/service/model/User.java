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
    }
}
