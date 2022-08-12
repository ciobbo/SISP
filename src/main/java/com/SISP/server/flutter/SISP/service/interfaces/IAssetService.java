package com.SISP.server.flutter.SISP.service.interfaces;

import com.example.demo.entity.Asset;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IAssetService {

    List<Asset> getAsset();
}
