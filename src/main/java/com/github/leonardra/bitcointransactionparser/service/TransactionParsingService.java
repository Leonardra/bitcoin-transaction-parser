package com.github.leonardra.bitcointransactionparser.service;


import org.bitcoinj.core.*;
import org.bitcoinj.params.TestNet3Params;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class TransactionParsingService {

    private static final Logger LOG = LoggerFactory.getLogger(TransactionParsingService.class);

    private final NetworkParameters networkParameters = TestNet3Params.get();


    public void parsingTransactionHex(String transactionHex){
        Transaction transaction = new Transaction(networkParameters, org.bitcoinj.core.Utils.HEX.decode(transactionHex));

        LOG.info(transaction.toString());
        LOG.info("Version: {}", transaction.getVersion());
        LOG.info("Locktime: " + transaction.getLockTime());

        System.out.println("Inputs:");
        for (int i = 0; i < transaction.getInputs().size(); i++) {
            TransactionInput input = transaction.getInput(i);
            LOG.info("  Input {}", (i + 1));
            LOG.info("    Previous Transaction Hash: {}", input.getOutpoint().getHash());
            LOG.info("    Previous Transaction Index: {} ", input.getOutpoint().getIndex());
            LOG.info("    Script: {}", Utils.HEX.encode(input.getScriptBytes()));
        }

        LOG.info("Outputs:");
        for (int i = 0; i < transaction.getOutputs().size(); i++) {
            TransactionOutput output = transaction.getOutput(i);
            LOG.info("  Output {}",  (i + 1));
            LOG.info("    Value: {}",  output.getValue().toPlainString());
            LOG.info("    Script: {}", Utils.HEX.encode(output.getScriptBytes()));
        }
        LOG.info(transaction.toString());
    }
}
