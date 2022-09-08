package com.SISP.server.flutter.SISP.security;

import lombok.*;

import javax.persistence.*;

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
    @Column(name = "id")
    private Long id;
    @Column(name = "role_name")
    private String name;

}
