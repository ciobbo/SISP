package com.SISP.server.flutter.SISP.controller.interfaces;

import com.SISP.server.flutter.SISP.entity.Asset;
import com.SISP.server.flutter.SISP.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.SISP.server.flutter.SISP.costants.Endpoint.*;

@RestController
public interface IAssetController {

    @GetMapping(SHOW_ASSET)
    List<Asset> getAsset();

    @PostMapping(INSERT_ASSET)
    Asset addAsset(@RequestBody Asset asset) throws Exception;

    @DeleteMapping(DELETE_ASSET+ID)
    User deleteAsset(@PathVariable Long id) throws Exception;
}
