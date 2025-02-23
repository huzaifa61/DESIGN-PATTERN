package paymentgateway.transaction;

import paymentgateway.instrument.InstrumentDo;

public class Processor {

    public void processPayment(InstrumentDo sender,InstrumentDo reciever){
        System.out.println("Inside processPayment");
    }
}
