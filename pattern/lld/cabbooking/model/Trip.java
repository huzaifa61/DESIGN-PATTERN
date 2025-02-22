package cabbooking.model;


import lombok.NonNull;
import lombok.ToString;

import static cabbooking.model.TripStatus.COMPLETED;
import static cabbooking.model.TripStatus.IN_PROGRESS;

enum TripStatus {
    IN_PROGRESS,
    COMPLETED,
}

@ToString
public class Trip {
    private Rider rider;
    private Cab cab;
    private TripStatus tripStatus;
    private Double price;
    private Location fromPointer;
    private Location toPointer;
    public Trip(
            @NonNull final Rider rider,
            @NonNull final Cab cab,
            @NonNull final Double price,
            @NonNull final Location fromPoint,
            @NonNull final Location toPoint) {
        this.rider = rider;
        this.cab = cab;
        this.price = price;
        this.fromPointer = fromPoint;
        this.toPointer = toPoint;
        this.tripStatus = IN_PROGRESS;
    }

    public void endTrip(){
        this.tripStatus = COMPLETED;
    }
}
