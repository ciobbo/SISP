package com.SISP.server.flutter.SISP.service;

import com.SISP.server.flutter.SISP.entity.TransferType;
import com.SISP.server.flutter.SISP.repository.TransferTypeRepository;
import com.SISP.server.flutter.SISP.service.interfaces.ITransferTypeService;
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
