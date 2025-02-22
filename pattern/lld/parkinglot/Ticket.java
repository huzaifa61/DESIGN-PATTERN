package parkinglot;

import parkinglot.Strategy.FeeStrategy;

public class Ticket {
    private FeeStrategy feeStrategy;

    public Ticket(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    private double calculateFee() {
        return feeStrategy.calculateFee(this);
    }
}
