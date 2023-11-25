package baseball.domain;

import baseball.domain.calculator.BallMatchCalculator;
import baseball.domain.calculator.MatchCalculator;
import baseball.domain.calculator.StrikeMatchCalculator;
import baseball.domain.numbers.GameNumbers;
import java.util.EnumMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Referee {

    private final List<MatchCalculator<Integer>> calculators;

    public Referee() {
        this.calculators = initializeCalculators();
    }

    private List<MatchCalculator<Integer>> initializeCalculators() {
        List<MatchCalculator<Integer>> calculators = new LinkedList<>();
        calculators.add(new BallMatchCalculator<>());
        calculators.add(new StrikeMatchCalculator<>());
        return calculators;
    }

    public Result judge(GameNumbers computerNumbers, GameNumbers userNumbers) {
        return Result.of(calculate(computerNumbers, userNumbers));
    }

    private Map<Hint, Integer> calculate(GameNumbers computerNumbers, GameNumbers userNumbers) {
        Map<Hint, Integer> assignedResult = new EnumMap<>(Hint.class);
        for (MatchCalculator<Integer> matchCalculator: calculators) {
            assignedResult.putAll(
                    matchCalculator.assignHint(computerNumbers.getNumbers(), userNumbers.getNumbers())
            );
        }
        return assignedResult;
    }
}
