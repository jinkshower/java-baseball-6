package baseball.domain;

import baseball.domain.calculator.BallMatchCalculator;
import baseball.domain.calculator.MatchCalculator;
import baseball.domain.calculator.StrikeMatchCalculator;
import baseball.domain.numbers.GameNumbers;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    private static final int STRIKE_INDEX = 0;
    private static final int BALL_INDEX = 1;

    private final List<MatchCalculator<Integer>> calculators;

    public Referee() {
        this.calculators = initializeCalculators();
    }

    private List<MatchCalculator<Integer>> initializeCalculators() {
        List<MatchCalculator<Integer>> calculators = new ArrayList<>();
        calculators.add(new StrikeMatchCalculator<>());
        calculators.add(new BallMatchCalculator<>());
        return calculators;
    }

    public Result judge(GameNumbers computerNumbers, GameNumbers userNumbers) {
        List<Integer> calculatedMatch = calculate(computerNumbers, userNumbers);
        calculatedMatch.set(STRIKE_INDEX, calculatedMatch.get(BALL_INDEX) - calculatedMatch.get(STRIKE_INDEX));
        return Result.of(calculatedMatch);
    }

    private List<Integer> calculate(GameNumbers computerNumbers, GameNumbers userNumbers) {
        return calculators.stream()
                .mapToInt(i -> i.countMatch(computerNumbers.getNumbers(), userNumbers.getNumbers()))
                .boxed()
                .collect(Collectors.toList());
    }
}
