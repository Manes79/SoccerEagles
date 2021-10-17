package pl.manes.soccereagles.structureManager;

import lombok.EqualsAndHashCode;

@SuppressWarnings("ALL")
@EqualsAndHashCode
public class ManagerDecisionEvent {

    private final String decisionEvent;

    public ManagerDecisionEvent(String decisionEvent) {
        this.decisionEvent = decisionEvent;
    }

    public String getDecisionEvent() {
        return decisionEvent;
    }

    @Override
    public String toString() {
        return "ManagerDecisionEvent{" +
                "decisionEvent='" + decisionEvent + '\'' +
                '}';
    }
}
