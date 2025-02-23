package calendar.strategy;

import calendar.Events;

import java.util.List;

public interface  EventStrategy {
    public List<Events> searchEvents(List<Events> events, String keyword);
}
