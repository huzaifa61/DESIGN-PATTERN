package LLDCalendar.state;

import LLDCalendar.Events;

public class EventStateContext {

    private EventState eventState;

    public EventStateContext() {
        this.eventState= new CreatedState();
    }

    public void setState(EventState state) {
        this.eventState = state;
    }

    public void handleEvent(Events events) {
        eventState.currenState(events);

    }



}
