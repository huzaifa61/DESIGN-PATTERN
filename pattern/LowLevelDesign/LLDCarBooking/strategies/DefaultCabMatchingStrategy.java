package LLDCarBooking.strategies;

import LLDCarBooking.model.Cab;
import LLDCarBooking.model.Location;
import LLDCarBooking.model.Rider;

import java.util.List;

public class DefaultCabMatchingStrategy implements CabMatchingStrategy {



    @Override
    public Cab matchCabToRider(Rider rider, List<Cab> candidateCabs, Location fromPoint, Location toPoint) {
        if (candidateCabs.isEmpty()) {
            return null;
        }
        return candidateCabs.get(0);
    }
}