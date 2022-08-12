package com.SISP.server.flutter.SISP.service.interfaces;

import com.example.demo.entity.TransferType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITransferTypeService {

    List<TransferType> getAll();
}
