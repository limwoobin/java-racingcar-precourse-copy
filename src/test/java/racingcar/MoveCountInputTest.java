package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Console;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.MockedStatic;
import racingcar.domain.ExceptionType;
import racingcar.domain.validator.InputValidator;
import racingcar.domain.validator.impl.MoveCountValidator;
import racingcar.input.MoveCountInput;

public class MoveCountInputTest {
    private MockedStatic<Console> console;

    @BeforeEach
    void before() {
        console = mockStatic(Console.class);
    }

    @AfterEach
    void after() {
        console.close();
    }

    @DisplayName("시도 횟수를 1~9 사이의 정상적인 값을 입력하면 validator 에 통과해 반환되어야 한다")
    @ParameterizedTest(name = "input={0}")
    @MethodSource("정상적인_이동횟수_입력값")
    void move_count_success_test(String input) {
        InputValidator validator = new MoveCountValidator();

        when(Console.readLine())
                .thenReturn(input);

        MoveCountInput moveCountInput = new MoveCountInput(validator);
        assertEquals(moveCountInput.getMoveCount(), Integer.parseInt(input));
    }

    private static Stream<? extends Arguments> 정상적인_이동횟수_입력값() {
        return Stream.of(
                Arguments.of("1"),
                Arguments.of("2"),
                Arguments.of("3"),
                Arguments.of("5"),
                Arguments.of("7"),
                Arguments.of("8"),
                Arguments.of("9")
        );
    }

    @DisplayName("시도 횟수를 1~9 사이 이외의 값을 입력하면 IllegalArgumentException 를 반환해야 한다")
    @ParameterizedTest(name = "input={0}")
    @MethodSource("올바르지_않은_이동횟수_입력값")
    void move_count_failed_test(String input) {
        InputValidator validator = new MoveCountValidator();

        when(Console.readLine())
                .thenReturn(input);

        assertThatThrownBy(() -> new MoveCountInput(validator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionType.INVALID_MOVE_COUNT_INPUT.getMessage());
    }

    private static Stream<? extends Arguments> 올바르지_않은_이동횟수_입력값() {
        return Stream.of(
                Arguments.of("123"),
                Arguments.of("12"),
                Arguments.of("0"),
                Arguments.of("a"),
                Arguments.of("qq"),
                Arguments.of("-5"),
                Arguments.of("-2")
        );
    }
}
