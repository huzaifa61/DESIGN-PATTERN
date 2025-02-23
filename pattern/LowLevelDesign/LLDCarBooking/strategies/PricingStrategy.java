package LLDCarBooking.strategies;


import LLDCarBooking.model.Location;
import org.springframework.stereotype.Component;

@Component
public interface PricingStrategy {
    Double findPrice(Location fromPoint, Location toPoint);
}
