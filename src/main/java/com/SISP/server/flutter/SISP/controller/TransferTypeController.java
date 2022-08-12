package com.SISP.server.flutter.SISP.controller;

import com.SISP.server.flutter.SISP.controller.interfaces.ITransferTypeController;
import com.SISP.server.flutter.SISP.entity.TransferType;
import com.SISP.server.flutter.SISP.service.TransferTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import static com.SISP.server.flutter.SISP.costants.Endpoint.*;

import java.util.List;

@RestController
public class TransferTypeController implements ITransferTypeController {

    @Autowired
    TransferTypeService transferTypeService;

    @Override
    public List<TransferType> getAll() {
        return transferTypeService.getAll();
    }
}
