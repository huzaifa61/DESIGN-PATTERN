package cabbooking.strategies;

import cabbooking.model.Cab;
import cabbooking.model.Location;
import cabbooking.model.Rider;

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