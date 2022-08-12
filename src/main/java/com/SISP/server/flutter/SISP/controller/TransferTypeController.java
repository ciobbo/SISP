package com.SISP.server.flutter.SISP.controller;

import com.example.demo.controller.intface.ITransferTypeController;
import com.example.demo.entity.TransferType;
import com.example.demo.service.TransferTypeService;
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
