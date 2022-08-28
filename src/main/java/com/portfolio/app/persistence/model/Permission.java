package com.portfolio.app.persistence.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "permissions")
@NoArgsConstructor
@Getter
@Setter
public class Permission {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "permissions", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Role> roles;
}