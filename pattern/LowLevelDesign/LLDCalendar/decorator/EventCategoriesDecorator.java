package LLDCalendar.decorator;

import LLDCalendar.Events;

import java.util.ArrayList;
import java.util.List;

public class EventCategoriesDecorator extends Events {
    private Events events;

    public EventCategoriesDecorator(Events events) {
        super(events.getAttendies(),events.getLocation(), events.getTitle(), events.getTime(), events.getDescription(), events.getEventId());
        this.events = events;

    }

    public List<String> getCategories() {
        List<String> categories = new ArrayList<>();
        categories.add("Personal");
        return categories;
    }
}
