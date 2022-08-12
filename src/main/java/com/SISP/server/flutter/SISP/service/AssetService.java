package com.SISP.server.flutter.SISP.service;

import com.example.demo.entity.Asset;
import com.example.demo.repository.AssetRepository;
import com.example.demo.service.intface.IAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService implements IAssetService {

    @Autowired
    AssetRepository assetRepository;


    @Override
    public List<Asset> getAsset() {
        return assetRepository.findAll();
    }
}
