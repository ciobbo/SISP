package com.SISP.server.flutter.SISP.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "transfer_type")
public class TransferType {

    @Id
    @Column(name = "id_transfertype")
    private Long idTransferType;
    @Column(name = "transfer_desc")
    private String trasferDesc;

}
