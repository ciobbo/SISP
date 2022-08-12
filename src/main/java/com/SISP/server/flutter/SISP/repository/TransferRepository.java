package com.SISP.server.flutter.SISP.repository;

import com.example.demo.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

    Optional<Transfer> findById(Long id);

    @Modifying
    @Query(
            value = "UPDATE moneymanagment.transfer SET transfer.flag_delete = 1 WHERE id_transfer= :id_transfer",
            nativeQuery = true)
    @Transactional
    void cancelTransferById(@Param("id_transfer") Long id);
}
