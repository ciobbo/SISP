package com.SISP.server.flutter.SISP.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


//ciao andrei guarda come mi diverto
@Table
@Entity(name = "USERS_SISP")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name_user")
    private String name;
    private String psw;
    @Column(name="enable_request")
    private int enableRequest;

    @Column(name = "flag_deleted")
    private int deleted;

    @Column(name = "asset")
    @OneToMany
    @JoinColumn(name="asset", referencedColumnName = "id_asset")
    private Long asset;



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name_user='" + name + '\'' +
                ", psw='" + psw + '\'' +
                ", enable_request=" + enableRequest +
                '}';
    }
}
