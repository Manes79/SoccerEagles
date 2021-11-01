package pl.manes.soccereagles.structuremanager;

import lombok.Data;

@SuppressWarnings("ALL")
@Data
public class EventManager {

    private final String event;

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