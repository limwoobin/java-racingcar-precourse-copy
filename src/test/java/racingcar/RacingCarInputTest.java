package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
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
import racingcar.domain.validator.CarNamesValidatorGroup;
import racingcar.input.RacingCarInput;

public class RacingCarInputTest {
    private MockedStatic<Console> console;

    @BeforeEach
    void before() {
        console = mockStatic(Console.class);
    }

    @AfterEach
    void after() {
        console.close();
    }

    @DisplayName("자동차 이름을 정상적으로 입력하면 정상적으로 validator 에 통과해 반환되어야 한다")
    @ParameterizedTest(name = "input={0}")
    @MethodSource("정상적인_자동차_이름_input")
    void racingCarInput_success_test(String input) {
        CarNamesValidatorGroup carNamesValidatorGroup = new CarNamesValidatorGroup();

        when(Console.readLine())
                .thenReturn(input);

        RacingCarInput racingCarInput = new RacingCarInput(carNamesValidatorGroup);
        assertThat(racingCarInput.getCarNames()).isEqualTo(input);
    }

    private static Stream<? extends Arguments> 정상적인_자동차_이름_input() {
        return Stream.of(
                Arguments.of("wood , mask , 1123 , 2"),
                Arguments.of("test , qq , 2 , mycar"),
                Arguments.of("test1 , test2 , test3 , test4 , test5 , test6")
        );
    }

    @DisplayName("자동차 이름의 길이가 5를 넘는다면 IllegalArgumentException 를 반환해야 한다")
    @ParameterizedTest(name = "input={0}")
    @MethodSource("길이가5_이상인_자동차_이름_input")
    void racingCarInput_length_failed_test(String input) {
        CarNamesValidatorGroup carNamesValidatorGroup = new CarNamesValidatorGroup();

        when(Console.readLine())
                .thenReturn(input);

        assertThatThrownBy(() -> new RacingCarInput(carNamesValidatorGroup))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionType.IS_NAME_LENGTH_OVER_FIVE.getMessage());
    }

    private static Stream<? extends Arguments> 길이가5_이상인_자동차_이름_input() {
        return Stream.of(
                Arguments.of("wood , mask23 , 1123789 , 2"),
                Arguments.of("test , qq , 2 , mycar55"),
                Arguments.of("test10 , test11 , test12 , test13")
        );
    }

    @DisplayName("자동차 개수가 2미만이라면 IllegalArgumentException 를 반환해야 한다")
    @ParameterizedTest(name = "input={0}")
    @MethodSource("개수가_2미만인_자동차_이름_input")
    void racingCarInput_count_failed_test(String input) {
        CarNamesValidatorGroup carNamesValidatorGroup = new CarNamesValidatorGroup();

        when(Console.readLine())
                .thenReturn(input);

        assertThatThrownBy(() -> new RacingCarInput(carNamesValidatorGroup))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionType.IS_CAR_QTY_UNDER_TWO.getMessage());
    }

    private static Stream<? extends Arguments> 개수가_2미만인_자동차_이름_input() {
        return Stream.of(
                Arguments.of("wood"),
                Arguments.of("test"),
                Arguments.of("test1"),
                Arguments.of(",,,")
        );
    }

    @DisplayName("자동차의 이름이 중복된다면 IllegalArgumentException 를 반환해야 한다")
    @ParameterizedTest(name = "input={0}")
    @MethodSource("중복된_자동차_이름_input")
    void racingCarInput_overlap_failed_test(String input) {
        CarNamesValidatorGroup carNamesValidatorGroup = new CarNamesValidatorGroup();

        when(Console.readLine())
                .thenReturn(input);

        assertThatThrownBy(() -> new RacingCarInput(carNamesValidatorGroup))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ExceptionType.NOT_CONTAINS_CAR_NAMES_OVERLAP.getMessage());
    }

    private static Stream<? extends Arguments> 중복된_자동차_이름_input() {
        return Stream.of(
                Arguments.of("wood, wood"),
                Arguments.of("test, test"),
                Arguments.of("test1, test1")
        );
    }
}
