package baseball.domain.calculator;

import baseball.domain.Hint;
import java.util.List;
import java.util.Map;

public class BallMatchCalculator<T> implements MatchCalculator<T> {

    @Override
    public int countMatch(List<T> input, List<T> computer) {
        MatchCalculator<T> strikeCalculator = new StrikeMatchCalculator<>();
        int strikeIncludedMatchCount = (int) input.stream()
                .filter(computer::contains)
                .count();
        return strikeIncludedMatchCount - strikeCalculator.countMatch(input, computer);
    }

    public Map<Hint,Integer> assignHint(List<T> input, List<T> computer) {
        int ballCount = countMatch(input, computer);
        return Map.of(Hint.BALL, ballCount);
    }
}
