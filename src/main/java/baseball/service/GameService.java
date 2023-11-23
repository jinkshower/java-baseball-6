package baseball.service;

import baseball.domain.ApplicationStatus;
import baseball.domain.Hint;
import baseball.domain.Referee;
import baseball.domain.Result;
import baseball.domain.numbers.GameNumbers;

public class GameService {

    private final GameNumbers computerNumbers;

    public GameService(GameNumbers computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public ApplicationStatus playRound(GameNumbers userNumbers) {
        Referee referee = new Referee();
        Result result = referee.judge(computerNumbers, userNumbers);

        if (result.getMatchResult().getOrDefault(Hint.STRIKE, 0) == 3) {
            return ApplicationStatus.APPLICATION_EXIT;
        }
        return ApplicationStatus.PLAYING;
    }
}
