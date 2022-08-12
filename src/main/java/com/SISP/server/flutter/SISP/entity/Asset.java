package com.SISP.server.flutter.SISP.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name = "asset_desc")
    private String assetDesc;
    @Column(name = "asset_value")
    private Float assetValue;

}
