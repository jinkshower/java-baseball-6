package baseball.domain.calculator;

import baseball.domain.Hint;
import java.util.List;
import java.util.Map;

public interface MatchCalculator<T> {
    int countMatch(List<T> input, List<T> computer);
    Map<Hint, Integer> assignHint(List<T> input, List<T> computer);
}
