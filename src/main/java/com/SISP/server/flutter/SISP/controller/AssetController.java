package com.SISP.server.flutter.SISP.controller;


import com.SISP.server.flutter.SISP.controller.interfaces.IAssetController;
import com.SISP.server.flutter.SISP.entity.Asset;
import com.SISP.server.flutter.SISP.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static com.SISP.server.flutter.SISP.costants.Endpoint.*;

import java.util.List;


@RestController
@RequestMapping(ASSET)
public class AssetController implements IAssetController {

     @Autowired
    AssetService assetService;


    public List<Asset> getAsset() {
        return assetService.getAsset();
    }
}
