package com.SISP.server.flutter.SISP.service;

import com.example.demo.entity.Transfer;
import com.example.demo.repository.TransferRepository;
import com.example.demo.service.intface.ITransferService;
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
