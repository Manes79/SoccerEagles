package pl.manes.soccereagles.structureManager;

import lombok.EqualsAndHashCode;

@SuppressWarnings("ALL")
@EqualsAndHashCode
public class DateEventManager {

    private String eventDay;

    private String eventYear;

    private String eventHour;

    public DateEventManager(String eventDay, String eventYear, String eventHour) {
        this.eventDay = eventDay;
        this.eventYear = eventYear;
        this.eventHour = eventHour;
    }

    public DateEventManager(String line) {

    }

    public String getEventDay() {
        return eventDay;
    }

    public String getEventYear() {
        return eventYear;
    }

    public String getEventHour() {
        return eventHour;
    }

    @Override
    public String toString() {
        return "DateEventManager{" +
                "eventDay='" + eventDay + '\'' +
                ", eventYear='" + eventYear + '\'' +
                ", eventHour='" + eventHour + '\'' +
                '}';
    }
}
