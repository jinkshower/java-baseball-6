package baseball.domain.calculator;

import java.util.List;

public class BallMatchCalculator<T> implements MatchCalculator<T> {

    @Override
    public int countMatch(List<T> input, List<T> computer) {
        return (int) input.stream()
                .filter(computer::contains)
                .count();
    }
}
