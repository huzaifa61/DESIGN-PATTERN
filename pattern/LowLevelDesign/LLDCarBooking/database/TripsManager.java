package LLDCarBooking.database;


import LLDCarBooking.exceptions.NoCabsAvailableException;
import LLDCarBooking.exceptions.TripNotFoundException;
import LLDCarBooking.model.Cab;
import LLDCarBooking.model.Location;
import LLDCarBooking.model.Rider;
import LLDCarBooking.model.Trip;
import LLDCarBooking.strategies.CabMatchingStrategy;
import LLDCarBooking.strategies.PricingStrategy;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TripsManager {
    public static final Double MAX_ALLOWED_TRIP_MATCHING_DISTANCE = 10.0;
    public  Map<String, List<Trip>> trips = new HashMap<>();

    private CabsManager cabsManager;
    private RideManager riderManger;
    private CabMatchingStrategy cabMatchingStrategy;
    private PricingStrategy pricingStrategy;
    public TripsManager( CabsManager cabsManager,
                        RideManager riderManger,
                        CabMatchingStrategy cabMatchingStrategy,
                        PricingStrategy pricingStrategy) {
        this.cabsManager = cabsManager;
        this.riderManger = riderManger;
        this.cabMatchingStrategy = cabMatchingStrategy;
        this.pricingStrategy = pricingStrategy;
    }


public void createTrips(
        @NonNull final Rider rider,
        @NonNull final Location fromPoint,
        @NonNull final Location toPoint){

    final List<Cab> closeByCabs =
            cabsManager.getAllCabs(fromPoint, TripsManager.MAX_ALLOWED_TRIP_MATCHING_DISTANCE);
    final List<Cab> closeByAvailableCabs = closeByCabs.stream().filter(cab -> cab.getCurrentTrip()==null).collect(Collectors.toList());

    final Cab selectedCab =
            cabMatchingStrategy.matchCabToRider(rider, closeByAvailableCabs, fromPoint, toPoint);
    if (selectedCab == null) {
        throw new NoCabsAvailableException();
    }

    final Double price = pricingStrategy.findPrice(fromPoint, toPoint);
    final Trip newTrip = new Trip(rider, selectedCab, price, fromPoint, toPoint);

    if (!trips.containsKey(rider.getId())) {
        trips.put(rider.getId(), new ArrayList<>());
    }
    trips.get(rider.getId()).add(newTrip);
    selectedCab.setCurrentTrip(newTrip);

}

  public List<Trip> getHistory(@NonNull final Rider rider) {
      System.out.println("getHistory");
       return trips.get(rider.getId());

  }

    public void endTrip(@NonNull final Cab cab) {
        if (cab.getCurrentTrip() == null) {
            throw new TripNotFoundException();
        }

        cab.getCurrentTrip().endTrip();
        cab.setCurrentTrip(null);
    }


}

