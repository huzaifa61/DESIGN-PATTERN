package LLDParkingLot.parkingSpot;

public abstract class ParkingSpot {
    protected int spotNumber;
    protected boolean isOccupied;
    abstract void assignVehicle();

    private boolean isAvailable() {
        return false;
    }
}



