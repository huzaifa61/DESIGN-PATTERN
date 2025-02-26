package LLDPL;

public class parkingSpotFactory {

    public ParkingSpot getParkingSpot(String type){
        if(type.equalsIgnoreCase("car")){
            return new CompactSpot();
        }else if(type.equalsIgnoreCase("truck")){
            return new LargeSpot();
        }
        return null;
    }
}
