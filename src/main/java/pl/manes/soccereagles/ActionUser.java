package pl.manes.soccereagles;

import java.util.Objects;

public enum ActionUser {

    ADD("add"), LIST("list"), EVENT_STATUS("eventStatus"), HELP("help"), ANNOUNCEMENT("announcement"), QUIT("quit");

    private final String userMeaning;

    ActionUser(String userMeaning) {
        this.userMeaning = userMeaning;
    }

    public static ActionUser of(String userMeaning) {
        for (ActionUser actionUser : values()) {
            if (Objects.equals(actionUser.userMeaning, userMeaning)) {
                return actionUser;
            }
        }
        throw new IllegalArgumentException("Unknown ActionUser" + userMeaning);
    }
}
