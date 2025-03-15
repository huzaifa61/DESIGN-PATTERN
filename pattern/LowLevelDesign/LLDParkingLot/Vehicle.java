package LLDParkingLot;

import lombok.Data;

@Data
class Vehicle {
    private String licenseNumber;
    private VehicleType vehicleType;

    public Vehicle(String licenseNumber, VehicleType vehicleType) {
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
    }

}