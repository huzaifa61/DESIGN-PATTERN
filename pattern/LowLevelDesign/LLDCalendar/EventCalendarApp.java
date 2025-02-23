package LLDCalendar;

import LLDCalendar.Observer.EmailReminderObserver;
import LLDCalendar.Observer.ReminderManager;
import LLDCalendar.decorator.EventCategoriesDecorator;
import LLDCalendar.state.EventStateContext;
import LLDCalendar.state.Ongoing;

import java.util.Arrays;
import java.util.List;

public class EventCalendarApp {

    public static void main(String[] args) {
        // Create users
        User user1 = new User("user1", "john.doe", "john.doe@example.com");
        User user2 = new User("user2", "alice.smith", "alice.smith@example.com");
        List<User> users = Arrays.asList(user1, user2);
        List<User> users3 = Arrays.asList(user1);

        // Create event objects
        Events event1 = new Events(users3,"event1",  "Birthday Party", "2023", "party", "15");

        Events event3 = new Events(users,"event1",  "Birthday Party", "2023", "party", "15");

        // Create event manager
        EventManager eventManager = new EventManager();

        // Create reminder manager
        ReminderManager reminderManager = ReminderManager.getInstance();
        reminderManager.addReminder(event1, new EmailReminderObserver());
//        reminderManager.addReminder(event2, new PushNotificationReminderObserver());

        // Create search manager
        SearchManager searchManager = new SearchManager();
//        searchManager.setStrategy(new DateStrategy());
//        List<Events> searchResults = searchManager.searchEvents(eventManager.getEvents(), "birthday");

        // Add event categories using decorators
        EventCategoriesDecorator eventWithCategory = new EventCategoriesDecorator(event1);
        eventWithCategory.getCategories(); // Returns ["Personal"]

        // Set event state and handle actions
        EventStateContext stateContext = new EventStateContext();
        stateContext.setState(new Ongoing());
        stateContext.handleEvent(event1);
        
    }
}
