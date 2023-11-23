package baseball;

import baseball.controller.GameController;
import baseball.view.InputView;
import baseball.view.OutputVIew;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputView inputView = new InputView();
        OutputVIew outputVIew = new OutputVIew();

        GameController gameController = new GameController(inputView, outputVIew);
        gameController.run();
    }
}
