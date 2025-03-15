package LLDParkingLot;

import java.util.Date;

public class PaymentInfo {
    private double amount;
    private Date paymentDate;
    private int transactionId;
    private Ticket parkingTicket;
    private PaymentStatus paymentStatus;


    public PaymentInfo(double amount, Date paymentDate, int transactionId, Ticket parkingTicket, PaymentStatus paymentStatus) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.transactionId = transactionId;
        this.parkingTicket = parkingTicket;
        this.paymentStatus = paymentStatus;
    }

    // Getters and Setters

}
