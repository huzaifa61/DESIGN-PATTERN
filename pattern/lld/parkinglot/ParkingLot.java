package parkinglot;

public class ParkingLot {

    private static ParkingLot parkingLot;

    private  ParkingLot() {};

    public static synchronized ParkingLot getParkingLot(){
        if(parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }




}
