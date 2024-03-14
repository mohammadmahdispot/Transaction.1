package com.example.Transaction.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferRequest {

    private String fromAccountNumber;
    private String toAccountNumber;
    private double amount;
}
