package baseball.domain.calculator;

import java.util.List;

public class BallMatchCalculator<T> implements MatchCalculator<T> {

    @Override
    public int countMatch(List<T> input, List<T> computer) {
        MatchCalculator<T> strikeCalculator = new StrikeMatchCalculator<>();
        int strikeIncludedMatchCount = (int) input.stream()
                .filter(computer::contains)
                .count();
        return strikeIncludedMatchCount - strikeCalculator.countMatch(input, computer);
    }

}
