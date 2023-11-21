package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class StrikeMatchCalculatorTest {

    @DisplayName("주어진 두 리스트의 인덱스와 값을 비교한다")
    @ParameterizedTest
    @MethodSource("provideTwoSampleLists")
    <T> void calculateStrikeCount(List<T> input, List<T> computer, int expected) {
        MatchCalculator<T> matchCalculator = new StrikeMatchCalculator<>();

        int actual = matchCalculator.countMatch(input, computer);

        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> provideTwoSampleLists() {
        return Stream.of(
                Arguments.of(List.of(1,2,3), List.of(1,2,3), 3),
                Arguments.of(List.of("1","3","2"), List.of("2","3","4"), 1));
    }
}