package pl.manes.soccereagles.structureManager;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class SearchingUsers {

    private String searchUser;

    public SearchingUsers(String searchUser) {
        this.searchUser = searchUser;
    }

    public String getSearchUser() {
        return searchUser;
    }

    @Override
    public String toString() {
        return "SearchingUsers{" +
                "searchUser='" + searchUser + '\'' +
                '}';
    }
}
