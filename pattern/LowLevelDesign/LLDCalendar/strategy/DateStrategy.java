package LLDCalendar.strategy;

import LLDCalendar.Events;

import java.util.List;

public class DateStrategy implements EventStrategy {
    @Override
    public List<Events> searchEvents(List<Events> events, String date) {
        return List.of();
    }
}
