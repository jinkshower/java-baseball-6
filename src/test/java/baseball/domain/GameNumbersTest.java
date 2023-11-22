package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class GameNumbersTest {

    @DisplayName("생성한 숫자 리스트에 중복이 있을때 예외가 발생한다")
    @ParameterizedTest
    @MethodSource("provideDuplicatedNumbersList")
    void throwExceptionForDuplication(List<Integer> input) {
        assertThatThrownBy(() -> GameNumbers.of(()-> input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> provideDuplicatedNumbersList() {
        return Stream.of(
                Arguments.of(List.of(1,2,2)),
                Arguments.of(List.of(1,1,3)),
                Arguments.of(List.of(1,3,3))
        );
    }

    @DisplayName("생성한 숫자가 3개가 아닐 때 예외가 발생한다")
    @ParameterizedTest
    @MethodSource("provideInvalidSizeNumbersList")
    void throwExceptionForInvalidSize(List<Integer> input) {
        assertThatThrownBy(() -> GameNumbers.of(()-> input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> provideInvalidSizeNumbersList() {
        return Stream.of(
                Arguments.of(List.of(1,2)),
                Arguments.of(List.of(1,1,3,3)),
                Arguments.of(Collections.emptyList())
        );
    }

    @DisplayName("생성한 숫자가 범위를 벗어날때 예외가 발생한다")
    @ParameterizedTest
    @MethodSource("provideInvalidRangeNumbersList")
    void throwExceptionForInvalidRange(List<Integer> input) {
        assertThatThrownBy(() -> GameNumbers.of(()-> input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> provideInvalidRangeNumbersList() {
        return Stream.of(
                Arguments.of(List.of(0,3,4)),
                Arguments.of(List.of(5,8,10)),
                Arguments.of(List.of(1,2,-1))
        );
    }
}