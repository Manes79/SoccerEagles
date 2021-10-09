package pl.manes.soccereagles.structureManager;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class EventManager {

    // type of event
    private String event;

    public EventManager(String event) {
        this.event = event;
    }

    public String getEvent() {
        return event;
    }

    @Override
    public String toString() {
        return "EventManager{" +
                "event='" + event + '\'' +
                '}';
    }
}
