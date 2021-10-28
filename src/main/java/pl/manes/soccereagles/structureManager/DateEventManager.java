package pl.manes.soccereagles.structureManager;

import lombok.EqualsAndHashCode;

@SuppressWarnings("ALL")
@EqualsAndHashCode
public class DateEventManager {

    private final String eventDate;

    public DateEventManager(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventDate() {
        return eventDate;
    }

    @Override
    public String toString() {
        return "DateEventManager{" +
                "eventDate='" + eventDate + '\'' +
                '}';
    }
}