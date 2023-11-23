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

    public int readRetryOrExit() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        try {
            String text = Console.readLine();
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
