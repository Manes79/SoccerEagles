package pl.manes.soccereagles.structureManager;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class InformationForUser {

    private String infoForUser;

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
