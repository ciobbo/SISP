package com.SISP.server.flutter.SISP.controller;


import com.example.demo.controller.intface.IAssetController;
import com.example.demo.entity.Asset;
import com.example.demo.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.SISP.server.flutter.SISP.costants.Endpoint.*;

import java.util.List;

import static com.example.demo.Constant.*;

@RestController
@RequestMapping(ASSET)
public class AssetController implements IAssetController {

     @Autowired
    AssetService assetService;


    public List<Asset> getAsset() {
        return assetService.getAsset();
    }
}
