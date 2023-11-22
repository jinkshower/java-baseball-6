package baseball.controller;

import baseball.domain.numbers.GameNumbers;
import baseball.util.ExceptionHandler;
import baseball.view.InputView;

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
