package baseball.service;

import baseball.domain.ApplicationStatus;
import baseball.domain.Hint;
import baseball.domain.Referee;
import baseball.domain.Result;
import baseball.domain.numbers.GameNumbers;
import baseball.view.OutputVIew;

public class GameService {

    private final GameNumbers computerNumbers;

    public GameService(GameNumbers computerNumbers) {
        this.computerNumbers = computerNumbers;
    }

    public ApplicationStatus playRound(GameNumbers userNumbers) {
        Referee referee = new Referee();
        Result result = referee.judge(computerNumbers, userNumbers);

        OutputVIew outputVIew = new OutputVIew();
        outputVIew.printHint(result.getFormattedResult());
        if (result.getMatchResult().getOrDefault(Hint.STRIKE, 0) == 3) {
            outputVIew.printGameOverMessage();
            return ApplicationStatus.RETRY;
        }
        return ApplicationStatus.PLAYING;
    }
}
