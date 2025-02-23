package calendar;

import calendar.strategy.EventStrategy;
//import org.springframework.boot.autoconfigure.condition.SearchStrategy;

import java.util.List;

public class SearchManager {

    private EventStrategy searchStrategy;

    public void setStrategy(EventStrategy strategy) {
        this.setStrategy(strategy);
    }

    public List<Events> searchEvents(List<Events> events, String keyword) {
        return searchStrategy.searchEvents(events, keyword);
    }

}
