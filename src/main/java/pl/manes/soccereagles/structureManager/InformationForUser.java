package pl.manes.soccereagles.structureManager;

import lombok.EqualsAndHashCode;

@SuppressWarnings("ALL")
@EqualsAndHashCode
public class InformationForUser {

    private final String infoForUser;

    public InformationForUser(String infoForUser) {
        this.infoForUser = infoForUser;
    }

    public String getInfoForUser() {
        return infoForUser;
    }

    @Override
    public String toString() {
        return "InformationForUser{" +
                "infoForUser='" + infoForUser + '\'' +
                '}';
    }
}
