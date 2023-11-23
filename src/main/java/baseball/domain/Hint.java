package baseball.domain;

public enum Hint {

    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String message;

    Hint(String message) {
        this.message = message;
    }

    public String getMessage(Hint hint, int count) {
        if (hint == Hint.NOTHING) {
            return Hint.NOTHING.message;
        }
        return count + message + " ";
    }
}
