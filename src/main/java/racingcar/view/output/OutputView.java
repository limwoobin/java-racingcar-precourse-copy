package racingcar.view.output;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    public static final String ERROR_HEADER_MESSAGE = "[ERROR]";

    private OutputView() {}

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_HEADER_MESSAGE + " " + message);
    }

    public static void carsRaceStatus(Cars cars) {
        for (Car car : cars.getCars()) {
            raceStatus(car);
        }
    }
    private static void raceStatus(Car car) {
        System.out.println(car.getName() + ": " + car.getDistanceByDash());
    }
}
