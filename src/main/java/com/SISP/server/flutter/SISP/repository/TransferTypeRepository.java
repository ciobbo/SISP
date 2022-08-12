package com.SISP.server.flutter.SISP.repository;

import com.SISP.server.flutter.SISP.entity.TransferType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferTypeRepository extends JpaRepository<TransferType, Long> {

    @Override
    List<TransferType> findAll();
}
