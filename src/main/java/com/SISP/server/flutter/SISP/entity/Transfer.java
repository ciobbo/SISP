package com.SISP.server.flutter.SISP.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transfer")
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transfer")
    private Long idTransfer;
    @Column(name = "tr_date")
    private Date date;
    @ManyToOne
    @JoinColumn(name="asset", referencedColumnName = "id_asset")
    private Asset asset;
    @Column(name = "amount")
    private Float amount;
    @ManyToOne
    @JoinColumn(name="tr_type", referencedColumnName = "id_transfertype")
    private TransferType transferType;
    @Column(name = "flag_deleted")
    private Integer deletedTransfer;

}
