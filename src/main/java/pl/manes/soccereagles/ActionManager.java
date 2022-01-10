package pl.manes.soccereagles;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public enum ActionManager {

    ADD("add"), LIST("list"), DECISION("decision"), STATUS_CONFIRMED("statusConfirmed"), STATUS_DECLINED("statusDeclined"),
    HELP("help"), FROM_USERS("fromUsers"), QUIT("quit"), RESET("reset"), RANDOM_PLAYER("randomPlayer");

    private final String meaning;

    ActionManager(String meaning) {
        this.meaning = meaning;
    }

    public static @NotNull ActionManager of(String meaning) {
        for (ActionManager actionManager : values()) {
            if (Objects.equals(actionManager.meaning, meaning)) {
                return actionManager;
            }
        }
        throw new IllegalArgumentException("Unknown ActionManger" + meaning);

    }
}
