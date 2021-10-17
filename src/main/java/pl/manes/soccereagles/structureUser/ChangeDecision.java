package pl.manes.soccereagles.structureUser;

import lombok.EqualsAndHashCode;

@SuppressWarnings("ALL")
@EqualsAndHashCode
public class ChangeDecision {

    private final String changeDecision;

    public ChangeDecision(String changeDecision) {
        this.changeDecision = changeDecision;
    }

    public String getChangeDecision() {
        return changeDecision;
    }

    @Override
    public String toString() {
        return "ChangeDecision{" +
                "changeDecision='" + changeDecision + '\'' +
                '}';
    }
}
