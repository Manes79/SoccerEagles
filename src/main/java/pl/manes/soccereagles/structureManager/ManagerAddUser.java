package pl.manes.soccereagles.structureManager;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ManagerAddUser {

    private String addUser;

    public ManagerAddUser(String addUser) {
        this.addUser = addUser;
    }

    public String getAddUser() {
        return addUser;
    }

    @Override
    public String toString() {
        return "ManagerAddUser{" +
                "addUser='" + addUser + '\'' +
                '}';
    }
}
