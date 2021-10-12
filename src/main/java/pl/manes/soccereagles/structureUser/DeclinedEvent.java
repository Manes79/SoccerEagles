package pl.manes.soccereagles.structureUser;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class DeclinedEvent {

    private final String declinedName;

    public DeclinedEvent(String declinedName) {
        this.declinedName = declinedName;
    }

    public String getDeclinedName() {
        return declinedName;
    }

    @Override
    public String toString() {
        return "DeclinedEvent{" +
                "declinedName='" + declinedName + '\'' +
                '}';
    }
}
