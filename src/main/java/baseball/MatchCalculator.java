package baseball;

import static baseball.Constant.THREE_STRIKE;
import static baseball.GameController.hasWon;

import java.util.List;

public class MatchCalculator {

    public int[] checkMatch(List<Integer> computerNum, List<Integer> userNum) {
        int strikeCount = countStrike(computerNum, userNum);
        int ballCount = countBall(computerNum, userNum) - strikeCount;
        checkWin(strikeCount);
        return new int[]{strikeCount, ballCount};
    }

    public int countStrike(List<Integer> computerNum, List<Integer> userNum) {
        int count = 0;
        for (int i = 0; i < computerNum.size(); i++) {
            if (computerNum.get(i).equals(userNum.get(i))) {
                count++;
            }
        }
        return count;
    }

    public int countBall(List<Integer> computerNum, List<Integer> userNum) {
        int count = 0;
        for (int i = 0; i < computerNum.size(); i++) {
            if (computerNum.contains(userNum.get(i))) {
                count++;
            }
        }
        return count;
    }

    public void checkWin(int strikeCount) {
        if (strikeCount == THREE_STRIKE) {
            hasWon();
        }
    }
}
