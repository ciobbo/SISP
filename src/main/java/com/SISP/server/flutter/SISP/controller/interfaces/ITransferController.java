package com.SISP.server.flutter.SISP.controller.interfaces;

import com.SISP.server.flutter.SISP.entity.Transfer;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.SISP.server.flutter.SISP.costants.Endpoint.*;

@RestController
public interface ITransferController {

    @GetMapping(SHOW_HISTORY)
    List<Transfer> getTransfer();

    @GetMapping(ID)
    Transfer getTransferById(@PathVariable Long id) throws Exception;

    @PutMapping(ID)
    Transfer deleteTransfer(@PathVariable Long id) throws Exception;

}
