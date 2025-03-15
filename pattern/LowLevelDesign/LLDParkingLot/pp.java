package LLDParkingLot;

import LLDParkingLot.parkingSpot.ParkingSpot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingFloor {
    private int floorId;
    private Map<ParkingSpotType, List<ParkingSpot>> parkingSpots;
    private ParkingDisplayBoard displayBoard;

    public ParkingFloor(int floorId) {
        this.floorId = floorId;
        this.parkingSpots = new HashMap<>();
        this.displayBoard = new ParkingDisplayBoard();
    }


    // Find an available spot based on vehicle type
    public ParkingSpot findAvailableSpot(Vehicle vehicle) {
        ParkingSpotType spotType = getSpotTypeForVehicle(vehicle.getVehicleType());
        List<ParkingSpot> spots = parkingSpots.get(spotType);
        if (spots != null) {
            for (ParkingSpot spot : spots) {
                if (spot.isAvailable) {
                    return spot;
                }
            }
        }
        return null; // No available spots
    }

    // Update the display board with the number of free spots
    public void updateDisplayBoard(Vehicle vehicle, int spots) {
        ParkingSpotType spotType = getSpotTypeForVehicle(vehicle.getVehicleType());
        displayBoard.updateFreeSpots(spotType, spots);
    }

    private ParkingSpotType getSpotTypeForVehicle(VehicleType vehicleType) {
        switch (vehicleType) {
            case CAR:
                return ParkingSpotType.CAR_PARKING;
            case BIKE:
                return ParkingSpotType.BIKE_PARKING;
            case TRUCK:
                return ParkingSpotType.TRUCK_PARKING;
            default:
                throw new IllegalArgumentException("Unknown vehicle type");
        }
    }
}
