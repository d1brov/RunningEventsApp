package com.portfolio.app.persistence.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "emergency_phone")
    private String emergencyPhoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credentials_id", referencedColumnName = "id")
    private UserCredentials credentials;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Record> records;

    public void setEmail(String email) {
        this.email = email;
        this.credentials.setUsername(email);
    }
}