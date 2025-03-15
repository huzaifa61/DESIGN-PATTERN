package LLDParkingLot;

public class ExitGate implements Gate {
    private int exitId;
    private Payment payment;


    public Exit(int exitId,Payment payment) {
        this.exitId = exitId;
        this.payment= payment;

    }

    @Override
    public void open() {
        System.out.println("Exit gate " + exitId + " is open.");
    }

    @Override
    public void close() {
        System.out.println("Exit gate " + exitId + " is closed.");
    }

    public PaymentInfo processPayment(Ticket ticket, PaymentType paymentType) {
        System.out.println("Processing payment for ticket: " + ticket.getParkingTicketId());
        Payment payment = new Payment();
        return payment.makePayment(ticket, paymentType);
    }
}