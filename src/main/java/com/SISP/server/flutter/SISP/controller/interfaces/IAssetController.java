package com.SISP.server.flutter.SISP.controller.interfaces;

import com.example.demo.entity.Asset;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.SISP.server.flutter.SISP.costants.Endpoint.*;
import static com.example.demo.Constant.SHOW_ASSET;

@RestController
public interface IAssetController {

    @GetMapping(SHOW_ASSET)
     List<Asset> getAsset();
}
