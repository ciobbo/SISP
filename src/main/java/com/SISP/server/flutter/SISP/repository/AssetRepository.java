package com.SISP.server.flutter.SISP.repository;

import com.SISP.server.flutter.SISP.entity.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AssetRepository extends JpaRepository <Asset, Long>{

    @Override
    List<Asset> findAll();
}
