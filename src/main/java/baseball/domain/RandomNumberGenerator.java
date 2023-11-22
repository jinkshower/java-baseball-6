package baseball.domain;

import static baseball.domain.GameConstants.MAX_NUMBER;
import static baseball.domain.GameConstants.MAX_SIZE;
import static baseball.domain.GameConstants.MIN_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    public static List<Integer> draw() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < MAX_SIZE.getValue()) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER.getValue(), MAX_NUMBER.getValue());
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
