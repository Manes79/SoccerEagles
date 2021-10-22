package pl.manes.soccereagles.structureManager;

import lombok.EqualsAndHashCode;

@SuppressWarnings("ALL")
@EqualsAndHashCode
public class DateEventManager {

    private final String dateEvent;

    public DateEventManager(String dataEvent) {
        this.dateEvent = dataEvent;

    }

    public String getDataEvent() {
        return dateEvent;
    }

    @Override
    public String toString() {
        return "DataEventManager{" +
                "dataEvent='" + dateEvent + '\'' +
                '}';
    }
}
