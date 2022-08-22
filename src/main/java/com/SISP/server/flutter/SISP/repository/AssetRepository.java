package com.SISP.server.flutter.SISP.repository;

import com.SISP.server.flutter.SISP.entity.Asset;
import com.SISP.server.flutter.SISP.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;


@Repository
public interface AssetRepository extends JpaRepository <Asset, Long>{

    @Override
    List<Asset> findAll();

    void deleteById(Long idAsset);


}
