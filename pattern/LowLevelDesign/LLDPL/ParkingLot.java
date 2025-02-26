package LLDPL;

public class ParkingLot {

    public static ParkingLot parkingLot;

    public ParkingLot getParkingLot() {
        if (parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }
}
