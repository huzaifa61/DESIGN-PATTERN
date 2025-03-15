package LLDParkingLot;

public class EntranceGate implements Gate {
    private int gateId;
    private ParkingAttendant attendant;

    public EntranceGate(int gateId, ParkingAttendant attendant) {
        this.gateId = gateId;
        this.attendant = attendant;
    }

    @Override
    public void open() {
        System.out.println("Entrance gate " + gateId + " is open.");
    }

    @Override
    public void close() {
        System.out.println("Entrance gate " + gateId + " is closed.");
    }

    public Ticket createTicketForVehicle(Vehicle vehicle) {
        System.out.println("Creating ticket for vehicle: " + vehicle.getLicenseNumber());
        return attendant.createTicket(vehicle);
    }
}