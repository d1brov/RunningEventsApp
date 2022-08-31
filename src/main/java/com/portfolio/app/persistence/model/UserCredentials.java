package com.portfolio.app.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "user_credentials")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class UserCredentials {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @Column(name = "username")
    @NonNull
    private String username;

    @Column(name = "password")
    @NonNull
    private String password;

    @Column(name = "is_email_confirmed")
    @NonNull
    private Boolean isEmailConfirmed;

    @ManyToMany
    @JoinTable(
            name = "user_credentials_roles",
            joinColumns = @JoinColumn(name = "user_credential_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @NonNull
    private Set<Role> roles;
}