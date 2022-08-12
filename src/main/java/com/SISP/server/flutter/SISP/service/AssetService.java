package com.SISP.server.flutter.SISP.service;

import com.SISP.server.flutter.SISP.entity.Asset;
import com.SISP.server.flutter.SISP.repository.AssetRepository;
import com.SISP.server.flutter.SISP.service.interfaces.IAssetService;
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
