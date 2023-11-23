package baseball.domain.calculator;

import java.util.List;
import java.util.stream.IntStream;

public class StrikeMatchCalculator<T> implements MatchCalculator<T> {

    @Override
    public int countMatch(List<T> input, List<T> computer) {
        return (int) IntStream.range(0, computer.size())
                .filter(index -> isSameValue(input.get(index), computer.get(index)))
                .count();
    }

    private boolean isSameValue(T inputValue, T computerValue) {
        return inputValue.equals(computerValue);
    }
}

