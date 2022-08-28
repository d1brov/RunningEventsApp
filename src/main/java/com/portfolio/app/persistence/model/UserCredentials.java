package com.portfolio.app.persistence.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "user_credentials")
@SuppressWarnings("checkstyle:MemberName")
public class UserCredentials {
    @Id
    @Column(name = "user_id")
    private Integer user_id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "is_enabled")
    private boolean isEnabled;

    @Column(name = "is_email_confirmed")
    private boolean isEmailConfirmed;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "user_credentials_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
}