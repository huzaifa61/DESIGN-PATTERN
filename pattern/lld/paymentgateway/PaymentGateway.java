package paymentgateway;

import paymentgateway.instrument.InstrumentController;
import paymentgateway.instrument.InstrumentDo;
import paymentgateway.instrument.InstrumentType;
import paymentgateway.transaction.Transaction;
import paymentgateway.transaction.TransactionController;
import paymentgateway.transaction.TransactionDo;

import java.util.List;

public class PaymentGateway {
public static void main(String args[]) {

    InstrumentController instrumentController = new InstrumentController();
    UserController userController = new UserController();
    TransactionController transactionController = new TransactionController();
//1. add USER1
    UserDo user1 = new UserDo();
    user1.setName("Sj");
    user1.setEmail("sj@conceptandcoding.com");
    UserDo user1Details = userController.addUser(user1);
//1. add USER2
    UserDo user2 = new UserDo();
    user2.setName("Pj");
    user2.setEmail("Pj@conceptandcoding.com");
    UserDo user2Details = userController.addUser(user2);
//add bank to User1
    InstrumentDo bankInstrumentDo = new InstrumentDo();
    bankInstrumentDo.setAccountNumber("234324234324324");
    bankInstrumentDo.setInstrumentType(InstrumentType.BANK);
    bankInstrumentDo.setUserId(user1Details.getUserId());
    bankInstrumentDo.setIfscCode("'ER3223E");
    InstrumentDo user1BankInstrument = instrumentController.addInstrument(bankInstrumentDo);
    System.out.println("Bank Instrument created for User1: " + user1BankInstrument.getInstrumentId());
//add Card to User2
    InstrumentDo cardInstrumentDo = new InstrumentDo();
    cardInstrumentDo.setCardNumber("1230099");
    cardInstrumentDo.setInstrumentType(InstrumentType.CARD);
    cardInstrumentDo.setCvv("0000");
    cardInstrumentDo.setUserId(user2Details.getUserId());
    InstrumentDo user2CardInstrument = instrumentController.addInstrument(cardInstrumentDo);
    System.out.println("Card Instrument created for User2: " + user2CardInstrument.getInstrumentId());

    TransactionDo transactionDo = new TransactionDo();
    transactionDo.setCreditAmount(10);
    transactionDo.setSenderId(user1Details.getUserId());
    transactionDo.setReceiverId(user2Details.getUserId());
//    transactionDo.setSenderId(user1BankInstrument.getInstrumentId());
//    transactionDo(user2CardInstrument.getInstrumentIDO);
    transactionController.makePayment(transactionDo);
//get All instruments of USER1
    List<InstrumentDo> user1Instruments = instrumentController.getAllInstrument(user1Details.getUserId());
    for(InstrumentDo instrumentDO : user1Instruments) {
        System.out.println("User1 InstID: " + instrumentDO.getInstrumentId() +
                ": UserID: " +instrumentDO.getUserId() +
                ": InstrumentType: " +instrumentDO.getInstrumentType().name());
    }
//get All instruments of user
    List<InstrumentDo> user2Instruments = instrumentController.getAllInstrument(user2Details.getUserId());
    for(InstrumentDo instrumentDO : user2Instruments) {
        System.out.println("User2 InstID: " + instrumentDO.getInstrumentId() +
                ": UserID: " +instrumentDO.getUserId() +
                ": InstrumentType: " +instrumentDO.getInstrumentType ().name ());
    }
//get All transaction history
    List<Transaction> userTransactionList = transactionController.getTransactionHistory(user1Details.getUserId());
    for(Transaction transaction : userTransactionList) {
        System.out.println("transaction "+transaction.getTransactionId());
    }
}}