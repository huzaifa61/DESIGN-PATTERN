package cabbooking.strategies;

import cabbooking.model.Cab;
import cabbooking.model.Location;
import cabbooking.model.Rider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CabMatchingStrategy {

    Cab matchCabToRider(Rider rider, List<Cab> candidateCabs, Location fromPoint, Location toPoint);
}
