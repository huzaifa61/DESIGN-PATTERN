package calendar.Observer;

import calendar.Events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReminderManager {
    private static ReminderManager reminderManager;
    Map<Events, List<ReminderObserver>> observers;

    private ReminderManager() {
        observers = new HashMap<Events, List<ReminderObserver>>();
    }
    public static ReminderManager getInstance() {
        if (reminderManager == null) {
            reminderManager = new ReminderManager();
        }
        return reminderManager;
    }

    public void addReminder(Events event, ReminderObserver manager) {
        List<ReminderObserver> list = observers.get(event);
        if (list == null) {
            list = new ArrayList<ReminderObserver>();
        }
        list.add(manager);
    }

    public void removeReminder(Events event, ReminderObserver manager) {
        List<ReminderObserver> list = observers.get(event);
        if (list != null) {
            list.remove(manager);
        }
    }

    public void notifyReminders(Events event) {
        List<ReminderObserver> list = observers.get(event);
        if (list != null) {
            for (ReminderObserver manager : list) {
                manager.onReminder(event);
            }
        }
    }


}
