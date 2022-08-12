package com.SISP.server.flutter.SISP.service.interfaces;

import com.example.demo.entity.Transfer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ITransferService {

    List<Transfer> getAll();

    Transfer getById(Long id) throws Exception;

    void deleteTransfer(Long id) throws Exception;
}
