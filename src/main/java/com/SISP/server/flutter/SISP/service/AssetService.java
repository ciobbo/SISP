package com.SISP.server.flutter.SISP.service;

import com.SISP.server.flutter.SISP.entity.Asset;
import com.SISP.server.flutter.SISP.entity.User;
import com.SISP.server.flutter.SISP.repository.AssetRepository;
import com.SISP.server.flutter.SISP.repository.UserRepository;
import com.SISP.server.flutter.SISP.service.interfaces.IAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService implements IAssetService {

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;


    @Override
    public List<Asset> getAsset() {
        return assetRepository.findAll();
    }

    @Override
    public Asset getAssetById(Long id) throws Exception {
        return assetRepository.findById(id).orElseThrow(()-> new Exception("Asset not found"));
    }

    @Override
    public void insertAsset(Asset asset) throws Exception {
System.out.println(asset.getAssetValue());
        System.out.println(asset.getUser());

        User user = userService
                .getUserById(asset
                        .getUser()
                        .getId());

        asset.setUser(user);
        assetRepository.save(asset);
    }

    @Override
    public void deleteAsset(Long idAsset) throws Exception {
        Asset asset = assetRepository
                .findById(idAsset)
                .orElseThrow(()-> new Exception("Asset not found"));
        assetRepository.deleteById(asset.getIdAsset());
    }
}
