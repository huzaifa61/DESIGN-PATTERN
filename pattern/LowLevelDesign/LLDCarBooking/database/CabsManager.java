package LLDCarBooking.database;

import LLDCarBooking.exceptions.CabAlreadyExistsException;
import LLDCarBooking.exceptions.CabNotFoundException;
import LLDCarBooking.model.Cab;
import LLDCarBooking.model.Location;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CabsManager {

    Map<String, Cab> cabMap = new HashMap<>();

    public void createCab(@NonNull final Cab cab) {
        if(cabMap.containsKey(cab.getId())){
            throw new CabAlreadyExistsException();
        }
        cabMap.put(cab.getId(), cab);
    }

    public Cab getCab(@NonNull final String id) {

        if(!cabMap.containsKey(id)){
            throw new CabNotFoundException();
        }
        return cabMap.get(id);
    }

    public void updateCabLocation(@NonNull final String cabId, @NonNull final Location newLocation) {
        if (!cabMap.containsKey(cabId)) {
            throw new CabNotFoundException();
        }

        cabMap.get(cabId).setCurrentLocation(newLocation);
    }

    public void updateCabAvalailability(final  String cabId,final Boolean newAvailaibility){
        if (!cabMap.containsKey(cabId)) {
            throw new CabNotFoundException();
        }

        cabMap.get(cabId).setIsAvailable(newAvailaibility);
    }

    public List<Cab> getAllCabs( @NonNull final Location fromPoint, @NonNull final Double distance){
        List<Cab> cabList = new ArrayList<>();
        for(Cab cab : cabMap.values()){
            if(cab.getIsAvailable() && cab.getCurrentLocation().distance(fromPoint) <= distance){
                cabList.add(cab);
            }
        }

        return cabList;
    }
}
