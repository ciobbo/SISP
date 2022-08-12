package com.SISP.server.flutter.SISP.service;

import com.SISP.server.flutter.SISP.entity.Transfer;
import com.SISP.server.flutter.SISP.repository.TransferRepository;
import com.SISP.server.flutter.SISP.service.interfaces.ITransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferService implements ITransferService {
    @Autowired
    TransferRepository transferRepository;


    @Override
    public List<Transfer> getAll() {
        return transferRepository.findAll();
    }

    public Transfer getById(Long id) throws Exception {
        return transferRepository
                .findById(id).orElseThrow(()-> new Exception("risorsa non trovata"));
    }

    @Override
    public void deleteTransfer(Long id) throws Exception {
        Transfer t = transferRepository
                .findById(id)
                .orElseThrow(()-> new Exception("risorsa non trovata"));
        t.setDeletedTransfer(1);
        transferRepository.save(t);
    }




}
