package pl.manes.soccereagles.structureuser;

import lombok.Data;

@SuppressWarnings("ALL")
@Data
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
