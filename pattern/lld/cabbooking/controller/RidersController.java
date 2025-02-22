package cabbooking.controller;


import java.util.List;

import cabbooking.database.RideManager;
import cabbooking.database.TripsManager;
import cabbooking.model.Location;
import cabbooking.model.Rider;
import cabbooking.model.Trip;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RidersController {
    private RideManager ridersManager;
    private TripsManager tripsManager;

    public RidersController(RideManager ridersManager, TripsManager tripsManager) {
        this.ridersManager = ridersManager;
        this.tripsManager = tripsManager;
    }

    @RequestMapping(value = "/register/rider", method = RequestMethod.POST)
    public ResponseEntity registerRider(final String riderId, final String riderName) {
        ridersManager.createRider(new Rider(riderId, riderName));
        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public ResponseEntity book(
            final String riderId,
            final Double sourceX,
            final Double sourceY,
            final Double destX,
            final Double destY) {

        tripsManager.createTrips(
                ridersManager.getRider(riderId),
                new Location(sourceX, sourceY),
                new Location(destX, destY));

        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/book", method = RequestMethod.GET)
    public ResponseEntity fetchHistory(final String riderId) {
        List<Trip> trips = tripsManager.getHistory(ridersManager.getRider(riderId));
        return ResponseEntity.ok(trips);
    }
}