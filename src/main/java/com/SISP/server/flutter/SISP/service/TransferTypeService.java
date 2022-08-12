package com.SISP.server.flutter.SISP.service;

import com.example.demo.entity.TransferType;
import com.example.demo.repository.TransferTypeRepository;
import com.example.demo.service.intface.ITransferTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransferTypeService implements ITransferTypeService {

    @Autowired
    TransferTypeRepository transferTypeRepository;

    @Override
    public List<TransferType> getAll() {
        return transferTypeRepository.findAll();
    }
}
