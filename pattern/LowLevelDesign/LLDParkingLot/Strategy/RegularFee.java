package LLDParkingLot.Strategy;

import LLDParkingLot.Ticket;

public class RegularFee implements FeeStrategy{

    @Override
    public double calculateFee(Ticket ticket) {
        return  10;
    }
}
