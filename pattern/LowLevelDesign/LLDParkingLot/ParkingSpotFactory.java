package LLDParkingLot;

import LLDParkingLot.parkingSpot.CompactSpot;
import LLDParkingLot.parkingSpot.LargeSpot;
import LLDParkingLot.parkingSpot.ParkingSpot;

public class ParkingSpotFactory {

    public static ParkingSpot createSpot(String spotName) {
        switch (spotName) {
            case "Compact": return new CompactSpot();
            case "Large": return new LargeSpot();
            default: throw new IllegalArgumentException("Invalid type");
        }
    }
}

