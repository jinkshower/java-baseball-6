package baseball.domain;

import static baseball.domain.GameConstants.MAX_NUMBER;
import static baseball.domain.GameConstants.MAX_SIZE;
import static baseball.domain.GameConstants.MIN_NUMBER;

import java.util.List;
import java.util.Set;

public class GameNumberValidator {

    private GameNumberValidator() {}

    public static void validate(List<Integer> generatedNumbers) {
        validateDuplication(generatedNumbers);
        validateRange(generatedNumbers);
        validateSize(generatedNumbers);
    }

    private static void validateDuplication(List<Integer> generatedNumbers) {
        if (Set.copyOf(generatedNumbers).size() != generatedNumbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateRange(List<Integer> generatedNumbers) {
        if (generatedNumbers.stream().anyMatch(GameNumberValidator::isOutOfRange)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isOutOfRange(int number) {
        return number < MIN_NUMBER.getValue() || number > MAX_NUMBER.getValue();
    }

    private static void validateSize(List<Integer> generatedNumbers) {
        if (generatedNumbers.size() != MAX_SIZE.getValue()) {
            throw new IllegalArgumentException();
        }
    }


}
