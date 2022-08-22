package com.SISP.server.flutter.SISP.controller;


import com.SISP.server.flutter.SISP.controller.interfaces.IAssetController;
import com.SISP.server.flutter.SISP.entity.Asset;
import com.SISP.server.flutter.SISP.entity.User;
import com.SISP.server.flutter.SISP.service.AssetService;
import com.SISP.server.flutter.SISP.service.UserService;
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

     @Autowired
     UserService userService;


    public List<Asset> getAsset() {
        return assetService.getAsset();
    }

    @Override
    public Asset addAsset(Asset asset) throws Exception {

        assetService.insertAsset(asset);

        //User user = userService.getUserById(asset.getUser().getId());
        return asset;
    }

    @Override
    public User deleteAsset(Long id) throws Exception {
        assetService.deleteAsset(id);

        User user = userService
                .getUserById(assetService
                        .getAssetById(id)
                        .getUser()
                        .getId()
                );
        return user;
    }


}
