package com.SISP.server.flutter.SISP.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


//ciao andrei guarda come mi diverto
@Table
@Entity(name = "USERS_SISP")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    //prova
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name_user")
    private String name;
    @Column(name = "psw")
    private String psw;
    @Column(name="enable_request")
    private int enableRequest;

    //valore 0 per user attivo
    //valore 1 per user non attivo
    @Column(name = "flag_deleted")
    private int flagDeleted;

    /*
     un utente può anche non avere asset associati,
     ma un asset deve essere mandatoriamente associato ad un utente
     l'associazione avverà nell'insert dell'asset mentre get user mostrerà gli asset associati
     */
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private Set<Asset> asset = new HashSet<>();





/*
    @Column(name = "asset")
    @OneToMany
    @JoinColumn(name="asset", referencedColumnName = "id_asset")
    private List<Asset> asset;*/



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
