package LLDPaymentGateway.transaction;

import LLDPaymentGateway.instrument.InstrumentController;
import LLDPaymentGateway.instrument.InstrumentDo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionService {

    public InstrumentController instrumentController;
    public Processor processor;
    public static Map<Integer, List<Transaction>> userVsTransactionsList = new HashMap<>();


    public TransactionService() {
        instrumentController = new InstrumentController();
        processor = new Processor();

    }

    public List<Transaction> getTransactionHistory(int userID) {
        return userVsTransactionsList.get(userID);
    }

    public TransactionDo makePayment(TransactionDo transactionDo) {
        InstrumentDo senderInstrumentDO = instrumentController.getInstrumentById(transactionDo.getSenderId(), transactionDo.getDebitAmount());
        InstrumentDo receiverInstrumentDO = instrumentController.getInstrumentById(transactionDo.getReceiverId(), transactionDo.getCreditAmount());
        processor.processPayment(senderInstrumentDO, receiverInstrumentDO);

        Transaction txn = new Transaction();
        txn.setAmount(transactionDo.getDebitAmount());
        txn.setSenderId(txn.getSenderId());
        txn.setReceiverId(transactionDo.getReceiverId());
        txn.setTransactionId(transactionDo.getTransactionId());
        txn.setStatus(String.valueOf(TransactionStatus.SUCCESS));
        List<Transaction> senderTxnsList = userVsTransactionsList.get(transactionDo.getSenderId());
        if (senderTxnsList == null) {
            senderTxnsList = new ArrayList<>();
            userVsTransactionsList.put(transactionDo.getSenderId(), senderTxnsList);
        }
        senderTxnsList.add(txn);
        List<Transaction> receiverTxnLists = userVsTransactionsList.get(transactionDo.getReceiverId());
        if (receiverTxnLists == null) {
            receiverTxnLists = new ArrayList<>();
            userVsTransactionsList.put(transactionDo.getReceiverId(), receiverTxnLists);
            receiverTxnLists.add(txn);
            transactionDo.setTransactionId(txn.getTransactionId());
            transactionDo.setStatus(Integer.parseInt(txn.getStatus()));
        }
        return transactionDo;

    }

}
