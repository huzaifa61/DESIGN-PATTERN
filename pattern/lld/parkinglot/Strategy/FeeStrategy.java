package parkinglot.Strategy;

import parkinglot.Ticket;

public interface FeeStrategy {
    double calculateFee(Ticket ticket);
}
