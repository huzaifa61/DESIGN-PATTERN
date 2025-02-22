package parkinglot;

import parkinglot.parkingSpot.CompactSpot;
import parkinglot.parkingSpot.LargeSpot;
import parkinglot.parkingSpot.ParkingSpot;

public class ParkingSpotFactory {

    public static ParkingSpot createSpot(String spotName) {
        switch (spotName) {
            case "Compact": return new CompactSpot();
            case "Large": return new LargeSpot();
            default: throw new IllegalArgumentException("Invalid type");
        }
    }
}

