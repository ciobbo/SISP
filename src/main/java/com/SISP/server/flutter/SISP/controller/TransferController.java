package com.SISP.server.flutter.SISP.controller;

import com.example.demo.controller.intface.ITransferController;
import com.example.demo.entity.Transfer;
import com.example.demo.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.SISP.server.flutter.SISP.costants.Endpoint.*;

@RestController
@RequestMapping(TRANSFER_HISTORY)
public class TransferController implements ITransferController {


    @Autowired
    TransferService transferService;

    @Override
    public List<Transfer> getTransfer() {
         return transferService.getAll();
    }

    @Override
    public Transfer getTransferById(Long id) throws Exception {
        return transferService.getById(id);
    }

    @Override
    public Transfer deleteTransfer(Long id) throws Exception {
        transferService.deleteTransfer(id);
        return transferService.getById(id);
    }


}
