package LLDParkingLot;

import java.util.List;

public class ParkingLot {

    private int parkingLotId;
    private String parkingLotName;
    private List<EntranceGate> entryGates;
    private List<ExitGate> exitGates;

    private static ParkingLot parkingLot;

    private  ParkingLot() {};

    public static synchronized ParkingLot getParkingLot(){
        if(parkingLot == null) {
            parkingLot = new ParkingLot();
        }
        return parkingLot;
    }




}
