package baseball.service;

import baseball.domain.numbers.GameNumbers;
import baseball.domain.numbers.RandomNumberGenerator;

public class GameService {

    private final GameNumbers computerNumbers;

    public GameService(GameNumbers computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public void playRound(GameNumbers userNumbers) {
        GameNumbers computerNumbers = GameNumbers.of(RandomNumberGenerator::draw);
    }
}
