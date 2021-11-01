package pl.manes.soccereagles.structuremanager;

import lombok.Data;

@SuppressWarnings("ALL")
@Data
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