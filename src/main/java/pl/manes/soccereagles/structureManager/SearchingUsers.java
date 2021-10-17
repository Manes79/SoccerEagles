package pl.manes.soccereagles.structureManager;

import lombok.EqualsAndHashCode;

@SuppressWarnings("ALL")
@EqualsAndHashCode
public class SearchingUsers {

    private final String searchUser;

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
