package LLDParkingLot.Strategy;

import LLDParkingLot.Ticket;

public interface FeeStrategy {
    double calculateFee(Ticket ticket);
}
