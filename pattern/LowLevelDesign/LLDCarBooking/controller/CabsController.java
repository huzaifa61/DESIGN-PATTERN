package LLDCarBooking.controller;

import LLDCarBooking.database.CabsManager;
import LLDCarBooking.database.TripsManager;
import LLDCarBooking.model.Cab;
import LLDCarBooking.model.Location;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CabsController {
    private final CabsManager cabsManager;
    private final TripsManager tripManager;

    public CabsController(CabsManager cabsManager,TripsManager tripManager) {
        this.cabsManager = cabsManager;
        this.tripManager = tripManager;
    }

    @RequestMapping(value = "/register/cab" , method = RequestMethod.POST)
    public ResponseEntity registerCab(final  String cab,final String driverName){
        cabsManager.createCab(new Cab(cab, driverName));
        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/update/cab/location" , method = RequestMethod.POST)
    public ResponseEntity updateCabLocation(final  String cabId,final Double newX, final Double newY){
        cabsManager.updateCabLocation(cabId, new Location(newX,newY));
        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/update/cab/avalability" , method = RequestMethod.POST)
    public ResponseEntity updateCabAvalailability(final  String cabId,final Boolean newAvailaibility){
        cabsManager.updateCabAvalailability(cabId,newAvailaibility );
        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/update/cab/end/trip" , method = RequestMethod.POST)
    public ResponseEntity updateEndTrip(final  String cabId){
        tripManager.endTrip(cabsManager.getCab(cabId) );
        return ResponseEntity.ok("");
    }




}
