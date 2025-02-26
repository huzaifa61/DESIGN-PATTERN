package LLDPL;

import LLDParkingLot.Strategy.FeeStrategy;
import LLDParkingLot.Ticket;

public class RegularFee implements FeeStrategy {
    @Override
    public double calculateFee(Ticket ticket) {
        return 10;
    }
}
