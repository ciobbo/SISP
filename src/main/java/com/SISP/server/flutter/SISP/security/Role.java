package com.SISP.server.flutter.SISP.security;

import com.SISP.server.flutter.SISP.entity.Cart;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

@Entity(name= "ROLE")
@NoArgsConstructor
@AllArgsConstructor
@Table
@Getter
@Setter
public class Role {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "role_id")
    private Long id;
    @Column(name = "role_name")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "addedRoles")
    private Set<User> user = new HashSet<>();

}
