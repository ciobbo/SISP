package com.SISP.server.flutter.SISP.controller.interfaces;

import com.SISP.server.flutter.SISP.entity.TransferType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface ITransferTypeController {

    @GetMapping("/get-transfer-type")
    List<TransferType> getAll();
}
