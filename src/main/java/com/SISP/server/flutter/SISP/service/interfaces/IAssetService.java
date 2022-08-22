package com.SISP.server.flutter.SISP.service.interfaces;

import com.SISP.server.flutter.SISP.entity.Asset;
import com.SISP.server.flutter.SISP.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAssetService {

    List<Asset> getAsset();

    Asset getAssetById(Long id) throws Exception;

    void insertAsset(Asset asset) throws Exception;

    void deleteAsset(Long idAsset) throws Exception;


}
