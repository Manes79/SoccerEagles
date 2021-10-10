package pl.manes.soccereagles.structureUser;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class NotConfirmedEvent {

    private String decline;

    public NotConfirmedEvent(String decline) {
        this.decline = decline;
    }

    public String getDecline() {
        return decline;
    }

    @Override
    public String toString() {
        return "NotConfirmedEvent{" +
                "decline='" + decline + '\'' +
                '}';
    }
}
