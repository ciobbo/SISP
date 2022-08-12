package com.SISP.server.flutter.SISP.controller.interfaces;

import com.example.demo.entity.Transfer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.SISP.server.flutter.SISP.costants.Endpoint.*;
import static com.example.demo.Constant.*;

@RestController
public interface ITransferController {

    @GetMapping(SHOW_HISTORY)
    List<Transfer> getTransfer();

    @GetMapping(ID)
    Transfer getTransferById(@PathVariable Long id) throws Exception;

    @PutMapping(ID)
    Transfer deleteTransfer(@PathVariable Long id) throws Exception;

}
