package LLDPaymentGateway.transaction;

import LLDPaymentGateway.instrument.InstrumentDo;

public class Processor {

    public void processPayment(InstrumentDo sender,InstrumentDo reciever){
        System.out.println("Inside processPayment");
    }
}
