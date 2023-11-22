package baseball.domain.numbers;

import java.util.List;
import java.util.function.Supplier;

public class GameNumbers {

    private final List<Integer> numbers;

    private GameNumbers(List<Integer> generatedNumbers) {
        this.numbers = List.copyOf(generatedNumbers);
    }

    public static GameNumbers of(Supplier<List<Integer>> numbers) {
        List<Integer> generatedNumbers = numbers.get();
        GameNumberValidator.validate(generatedNumbers);

        return new GameNumbers(generatedNumbers);
    }

    public List<Integer> getNumbers() {
        return List.copyOf(numbers);
    }

}
