package com.SISP.server.flutter.SISP.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "asset")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asset")
    @JoinColumn(name="asset")
    private Long idAsset;


    @JoinColumn(name="user", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL)
    //@JsonIgnore
    private User user;

    @Column(name = "asset_name")
    private String assetName;

    @Column(name = "asset_value")
    private Float assetValue;


}
