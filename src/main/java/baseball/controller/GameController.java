package baseball.controller;

import baseball.domain.ApplicationStatus;
import baseball.domain.numbers.GameNumbers;
import baseball.domain.numbers.RandomNumberGenerator;
import baseball.service.GameService;
import baseball.view.InputView;
import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class GameController {

    private final InputView inputView;
    private final Map<ApplicationStatus, Supplier<ApplicationStatus>> gameGuide;
    private  GameService gameService;

    public GameController(InputView inputView) {
        this.inputView = inputView;
        this.gameGuide = initializeGameGuide();
    }

    private Map<ApplicationStatus, Supplier<ApplicationStatus>> initializeGameGuide() {
        Map<ApplicationStatus, Supplier<ApplicationStatus>> gameGuide = new EnumMap<>(ApplicationStatus.class);
        gameGuide.put(ApplicationStatus.SET_UP_GAME, this::setUp);
        gameGuide.put(ApplicationStatus.RETRY, this::retryOrExit);
        gameGuide.put(ApplicationStatus.PLAYING, this::playRound);
        return gameGuide;
    }

    private ApplicationStatus setUp() {
        GameNumbers computerNumbers = GameNumbers.of(RandomNumberGenerator::draw);
        gameService = new GameService(computerNumbers);
        return ApplicationStatus.PLAYING;
    }

    private ApplicationStatus playRound() {
        GameNumbers userNumbers = GameNumbers.of(inputView::readUserNumbers);
        return gameService.playRound(userNumbers);
    }

    private ApplicationStatus retryOrExit() {
        int answer = inputView.readRetryOrExit();
        validateRetryAnswer(answer);
        if (answer == 1) {
            return ApplicationStatus.SET_UP_GAME;
        }
        return ApplicationStatus.APPLICATION_EXIT;
    }

    private void validateRetryAnswer(int answer) {
        if (answer != 1 && answer != 2) {
            throw new IllegalArgumentException();
        }
    }

    public void run() {
        ApplicationStatus applicationStatus = process(ApplicationStatus.SET_UP_GAME);
        while (applicationStatus.playable()) {
            applicationStatus = process(applicationStatus);
        }
    }

    private ApplicationStatus process(ApplicationStatus applicationStatus) {
        while (true) {
            try {
                return gameGuide.get(applicationStatus).get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
