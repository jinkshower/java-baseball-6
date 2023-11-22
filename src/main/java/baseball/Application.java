package baseball;

import baseball.controller.GameController;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();

        GameController gameController = new GameController(inputView);
        gameController.run();
    }
}
