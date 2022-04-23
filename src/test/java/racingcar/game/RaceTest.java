package racingcar.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.MoveCount;

public class RaceTest {

    @Nested
    @DisplayName("레이싱카 주행 테스트")
    class RacingCarDriveTest {
        private MockedStatic<Randoms> randoms;

        @BeforeEach
        void before() {
            randoms = mockStatic(Randoms.class);
        }

        @AfterEach
        void after() {
            randoms.close();
        }

        @DisplayName("시도할 회수가 n 이라면 자동차 이동 시도 역시 n번이 발생해야 한다")
        @ParameterizedTest
        @ValueSource(ints = {1,3,5,7,9})
        void racing_car_move_test(int 시도할_회수) {
            Cars cars = mock(Cars.class);
            MoveCount moveCount = new MoveCount(시도할_회수);

            Race race = new Race(cars, moveCount);
            race.start();
            verify(cars, times(시도할_회수)).move();
        }

        @DisplayName("4이상의 랜덤값이 2번 나오면 이동한 거리, dash 는 2 가 증가해야한다")
        @Test
        void racing_car_move_test_v2() {
            Cars cars = new Cars("test");
            MoveCount moveCount = new MoveCount(5);

            when(Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(3,4,5,1,2);

            Race race = new Race(cars, moveCount);
            race.start();
            List<Car> carList = cars.getCars();

            assertThat(carList.get(0).getDistanceCount()).isEqualTo(2);
            assertThat(carList.get(0).getDistanceByDash()).isEqualTo("--");
        }

        @DisplayName("4이상의 랜덤값이 5번 나오면 이동한 거리, dash 는 5 가 증가해야한다")
        @Test
        void racing_car_move_test_v3() {
            Cars cars = new Cars("test");
            MoveCount moveCount = new MoveCount(8);

            when(Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1,2,3,4,5,6,7,8);

            Race race = new Race(cars, moveCount);
            race.start();
            List<Car> carList = cars.getCars();

            assertThat(carList.get(0).getDistanceCount()).isEqualTo(5);
            assertThat(carList.get(0).getDistanceByDash()).isEqualTo("-----");
        }
    }
}
