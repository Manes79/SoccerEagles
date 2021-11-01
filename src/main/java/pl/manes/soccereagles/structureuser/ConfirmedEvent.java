package pl.manes.soccereagles.structureuser;

import lombok.Data;

@Data
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
                "confirmingName='" + confirmingName + '\'' + '}';
    }
}
