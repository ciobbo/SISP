package com.SISP.server.flutter.SISP.User;

import javax.persistence.*;


//ciao andrei guarda come mi diverto
@Table
@Entity(name = "USERS_SISP")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name_user;
    private String psw;
    private int enable_request;

    public User() {
    }

    public User(int id, String name_user, String psw, int enable_request) {
        this.id = id;
        this.name_user = name_user;
        this.psw = psw;
        this.enable_request = enable_request;
    }

    public User(String name, String psw, int enable_request) {
        this.name_user = name;
        this.psw = psw;
        this.enable_request = enable_request;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_user() {
        return name_user;
    }

    public void setName_user(String name) {
        this.name_user = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public int getEnable_request() {
        return enable_request;
    }

    public void setEnable_request(int enable_request) {
        this.enable_request = enable_request;
    }

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
