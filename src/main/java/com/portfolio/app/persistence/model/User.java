package com.portfolio.app.persistence.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "emergency_phone")
    private String emergencyPhoneNumber;

    @OneToOne(mappedBy = "user")
    private UserCredentials credentials;

    @Override
    public String toString() {
        return String.format(
                """
                First name: %s
                Last name: %s
                Email: %s
                Phone: %s
                Emergency phone: %s
                """,
                firstName,
                lastName,
                email,
                phoneNumber,
                emergencyPhoneNumber);
    }
}