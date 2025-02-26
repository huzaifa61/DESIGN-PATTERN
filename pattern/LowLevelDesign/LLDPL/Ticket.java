package LLDPL;

public class Ticket {

    private FeeStrategy feeStrategy;

    Ticket(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    private double getTotalFee() {
        return feeStrategy.calculate(this);
    }

}
