package pl.manes.soccereagles.structureUser;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class EventStatus {

    private String status;

    public EventStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "EventStatus{" +
                "status='" + status + '\'' +
                '}';
    }
}
