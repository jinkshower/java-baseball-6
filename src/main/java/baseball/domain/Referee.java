package baseball.domain;

import baseball.domain.calculator.BallMatchCalculator;
import baseball.domain.calculator.MatchCalculator;
import baseball.domain.calculator.StrikeMatchCalculator;
import baseball.domain.numbers.GameNumbers;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Referee {

    private final List<MatchCalculator<Integer>> calculators;

    public Referee() {
        this.calculators = initializeCalculators();
    }

    private List<MatchCalculator<Integer>> initializeCalculators() {®
        List<MatchCalculator<Integer>> calculators = new LinkedList<>();
        calculators.add(new BallMatchCalculator<>());
        calculators.add(new StrikeMatchCalculator<>());
        return calculators;
    }

    public Result judge(GameNumbers computerNumbers, GameNumbers userNumbers) {
        List<Integer> calculatedMatch = calculate(computerNumbers, userNumbers);
        return Result.of(calculatedMatch);
    }

    private List<Integer> calculate(GameNumbers computerNumbers, GameNumbers userNumbers) {
        return calculators.stream()
                .mapToInt(i -> i.countMatch(userNumbers.getNumbers(), computerNumbers.getNumbers()))
                .boxed()
                .collect(Collectors.toList());
    }
}
