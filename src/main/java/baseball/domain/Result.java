package baseball.domain;

import java.util.Map;

public class Result {

    private static final int THREE_STRIKE = 3;
    private final Map<Hint, Integer> matchResult;

    private Result(Map<Hint, Integer> matchResult) {
        this.matchResult = matchResult;
    }

    public static Result of(Map<Hint, Integer> calculatedMatch) {
        if (isNoMatch(calculatedMatch)) {
            calculatedMatch.values().remove(0);
            calculatedMatch.put(Hint.NOTHING, 0);
            return new Result(calculatedMatch);
        }
        return new Result(calculatedMatch);
    }

    private static boolean isNoMatch(Map<Hint, Integer> calculatedMatch) {
        return calculatedMatch.values().stream().reduce(0, Integer::sum) == 0;
    }

    public boolean isThreeStrike() {
        return matchResult.getOrDefault(Hint.STRIKE,0) == THREE_STRIKE;
    }

    public String getFormattedResult() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Hint hint : matchResult.keySet()) {
            String format = hint.getMessage(hint, matchResult.get(hint));
            stringBuilder.append(format);
        }
        return stringBuilder.toString();
    }
}
