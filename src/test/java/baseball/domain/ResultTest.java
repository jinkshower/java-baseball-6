package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.numbers.GameNumbers;
import java.util.List;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void createBallTest() {
        GameNumbers computerNumbers = GameNumbers.of(() -> List.of(5,2,1));
        GameNumbers userNumbers = GameNumbers.of(() -> List.of(1,5,2));

        Referee referee = new Referee();
        Result result = referee.judge(computerNumbers, userNumbers);
        System.out.println(result.getFormattedResult());
    }

}