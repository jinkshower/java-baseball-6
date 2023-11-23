package baseball.domain;

public enum ApplicationStatus {

    SET_UP_GAME,
    PLAYING,
    RETRY,
    APPLICATION_EXIT;

    public boolean playable() {
        return this != APPLICATION_EXIT;
    }
}
