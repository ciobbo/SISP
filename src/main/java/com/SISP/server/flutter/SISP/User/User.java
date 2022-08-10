package com.SISP.server.flutter.SISP.User;

import javax.persistence.*;


//ciao andrei guarda come mi diverto
@Table
@Entity(name = "USERS_SISP")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name_user")
    private String name;
    private String psw;
    @Column(name="enable_request")
    private int enableRequest;



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name_user='" + name_user + '\'' +
                ", psw='" + psw + '\'' +
                ", enable_request=" + enable_request +
                '}';
    }
}
