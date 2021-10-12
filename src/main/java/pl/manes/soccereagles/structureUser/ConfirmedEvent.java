package pl.manes.soccereagles.structureUser;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ConfirmedEvent {

    private final String confirmingName;

    public ConfirmedEvent(String confirm) {
        this.confirmingName = confirm;
    }

    public String getConfirmingName() {
        return confirmingName;
    }

    @Override
    public String toString() {
        return "ConfirmedEvent{" +
                "confirmingName='" + confirmingName + '\'' +
                '}';
    }
}
