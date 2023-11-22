package baseball.controller;

import baseball.domain.GameNumbers;
import baseball.domain.RandomNumberGenerator;
import baseball.util.ExceptionHandler;
import baseball.view.InputView;
import java.util.List;

public class GameController {

    private final InputView inputView;

    public GameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
       GameNumbers userNumbers = ExceptionHandler.repeatUntilValid(this::getUserNumber);
    }

    private GameNumbers getUserNumber() {
        return GameNumbers.of(inputView::readUserNumbers);
    }
}
