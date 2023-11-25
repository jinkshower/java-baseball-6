package baseball.domain.calculator;

import baseball.domain.Hint;
import java.util.List;
import java.util.stream.IntStream;

public class StrikeMatchCalculator<T> implements MatchCalculator<T> {

    @Override
    public int countMatch(List<T> input, List<T> computer) {
        int count = 0;
        for (int i = 0; i < computer.size(); i++) {
            if (input.get(i).equals(computer.get(i))) {
                count++;
            }
        }
        return count;
    }
}

