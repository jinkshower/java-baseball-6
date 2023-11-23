package baseball.service;

import baseball.domain.ApplicationStatus;
import baseball.domain.Hint;
import baseball.domain.Referee;
import baseball.domain.Result;
import baseball.domain.numbers.GameNumbers;
import baseball.view.OutputVIew;

public class GameService {

    private final GameNumbers computerNumbers;
    private Result result;

    public GameService(GameNumbers computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public String playOneRound(GameNumbers userNumbers) {
        Referee referee = new Referee();
        result = referee.judge(computerNumbers, userNumbers);
        return result.getFormattedResult();
    }

    public ApplicationStatus checkWin() {
        if (result.isThreeStrike()) {
            return ApplicationStatus.RETRY;
        }
        return ApplicationStatus.PLAYING;
    }
}
