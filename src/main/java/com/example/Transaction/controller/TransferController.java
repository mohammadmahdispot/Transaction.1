package com.example.Transaction.controller;

import com.example.Transaction.dto.TransferRequest;
import com.example.Transaction.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransferController {

    private final TransferService transferService;

    @PostMapping("/transfer")
    public void transefrMney(@RequestBody TransferRequest transferRequest){
        transferService.transferMoney(transferRequest.getFromAccountNumber(), transferRequest.getToAccountNumber(), transferRequest.getAmount());
    }
}
