package LLDParkingLot.Strategy;

import LLDParkingLot.Ticket;

public class PremiumFee implements FeeStrategy{
    @Override
    public double calculateFee(Ticket ticket) {
        return 20;
    }
}
