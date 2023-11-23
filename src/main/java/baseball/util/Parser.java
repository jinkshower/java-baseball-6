package baseball.util;

import java.util.Arrays;
import java.util.List;

public class Parser {

    private Parser() {
    }

    public static List<Integer> parseStringToInt(String text) {
        return Arrays.stream(text
                        .replace(" ", "")
                        .split(""))
                .map(Integer::parseInt)
                .toList();
    }
}
