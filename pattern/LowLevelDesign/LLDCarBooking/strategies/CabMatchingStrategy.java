package LLDCarBooking.strategies;

import LLDCarBooking.model.Cab;
import LLDCarBooking.model.Location;
import LLDCarBooking.model.Rider;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CabMatchingStrategy {

    Cab matchCabToRider(Rider rider, List<Cab> candidateCabs, Location fromPoint, Location toPoint);
}
