package baseball.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {

    private static final int THREE_STRIKE = 3;
    private final Map<Hint, Integer> matchResult;

    private Result(Map<Hint, Integer> matchResult) {
        this.matchResult = matchResult;
    }

    public static Result of(List<Integer> calculatedMatch) {
        Map<Hint, Integer> result = new EnumMap<>(Hint.class);
        if (calculatedMatch.stream().reduce(0, Integer::sum) == 0) {
            result.put(Hint.NOTHING, 0);
            return new Result(result);
        }

        result.put(Hint.BALL, calculatedMatch.get(0));
        result.put(Hint.STRIKE, calculatedMatch.get(1));
        result.values().remove(0);
        return new Result(result);
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
