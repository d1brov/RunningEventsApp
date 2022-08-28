package com.portfolio.app.persistence.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "permissions")
//@NoArgsConstructor
//@Getter
//@Setter
public class Permission {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "name")
    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "permissions", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Role> roles;
}