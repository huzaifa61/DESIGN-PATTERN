package cabbooking.database;



import cabbooking.exceptions.RiderAlreadyExistsException;
import cabbooking.exceptions.RiderNotFoundException;
import cabbooking.model.Rider;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RideManager {
    Map<String, Rider> riders = new HashMap<>();

    public void createRider(@NonNull final Rider newRider) {
        if (riders.containsKey(newRider.getId())) {
            throw new RiderAlreadyExistsException();
        }

        riders.put(newRider.getId(), newRider);
    }

    public Rider getRider(@NonNull final String riderId) {
        if (!riders.containsKey(riderId)) {
            throw new RiderNotFoundException();
        }
        return riders.get(riderId);
    }
}