package baseball.domain;

import java.util.List;

public interface MatchCalculator<T> {
    int countMatch(List<T> input, List<T> computer);
}
