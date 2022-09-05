package com.SISP.server.flutter.SISP.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Table
@Entity(name = "CART")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cart")
    private Long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "flag_status")
    private String flag_Status;

    @ManyToMany
    @JoinTable(
            name="user_enrolled",
            joinColumns = @JoinColumn(name="id_cart"),
            inverseJoinColumns = @JoinColumn(name="id")
    )
    private Set<User> enrolledUsers = new HashSet<>();

    public Set<User> getEnrolledUsers() {
        return enrolledUsers;
    }

    public void enrollUser(User user) {
        enrolledUsers.add(user);
    }

}
