package baseball.domain;

import java.util.List;
import java.util.function.Supplier;

public class ComputerNumbers {

    private final List<Integer> computerNumbers;

    private ComputerNumbers(List<Integer> generatedNumbers) {
        this.computerNumbers = List.copyOf(generatedNumbers);
    }

    public static ComputerNumbers of(Supplier<List<Integer>> numbers) {
        List<Integer> generatedNumbers = numbers.get();
        GameNumberValidator.validate(generatedNumbers);

        return new ComputerNumbers(generatedNumbers);
    }

    public List<Integer> getComputerNumbers() {
        return List.copyOf(computerNumbers);
    }

}
