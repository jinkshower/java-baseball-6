package baseball.view;

import baseball.util.Parser;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public List<Integer> readUserNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        try {
            String text = Console.readLine();
            return Parser.parseStringToInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
