package pl.manes.soccereagles.structureUser;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ConfirmedEvent {

    private String confirm;

    public ConfirmedEvent(String confirm) {
        this.confirm = confirm;
    }

    public String getConfirm() {
        return confirm;
    }

    @Override
    public String toString() {
        return "ConfirmedEvent{" +
                "confirm='" + confirm + '\'' +
                '}';
    }
}
