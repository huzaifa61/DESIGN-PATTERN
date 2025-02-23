package calendar;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    private List<Events> events;

    public EventManager() {
        events = new ArrayList<Events>();
    }


    public void addEvent(Events event) {
        events.add(event);
    }

    public void removeEvent(Events event) {
        events.remove(event);
    }

    public List<Events> getEvents() {
        return events;
    }

    public void setAttendies(Events event, User user) {
        event.getAttendies().add(user);

    }

}
