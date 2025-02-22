package parkinglot.Strategy;

import parkinglot.Ticket;

public class PremiumFee implements FeeStrategy{
    @Override
    public double calculateFee(Ticket ticket) {
        return 20;
    }
}
