package com.SISP.server.flutter.SISP.controller.interfaces;

import com.SISP.server.flutter.SISP.entity.Asset;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.SISP.server.flutter.SISP.costants.Endpoint.*;

@RestController
public interface IAssetController {

    @GetMapping(SHOW_ASSET)
     List<Asset> getAsset();
}
