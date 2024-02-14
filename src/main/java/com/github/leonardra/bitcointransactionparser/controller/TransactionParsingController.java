package com.github.leonardra.bitcointransactionparser.controller;

import com.github.leonardra.bitcointransactionparser.service.TransactionParsingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bitcoin/transaction")
public class TransactionParsingController {

    private final TransactionParsingService transactionParsingService;

    public TransactionParsingController(TransactionParsingService transactionParsingService) {
        this.transactionParsingService = transactionParsingService;
    }


    @GetMapping("/parse")
    public void parseTransaction(@RequestParam String transactionHex){
        transactionParsingService.parsingTransactionHex(transactionHex);
    }
}
