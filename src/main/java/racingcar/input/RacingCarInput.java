package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.validator.CarNamesValidatorGroup;

public class RacingCarInput {
    private final CarNamesValidatorGroup carNamesValidatorGroup;
    private final String carNames;

    public RacingCarInput(CarNamesValidatorGroup carNamesValidatorGroup) {
        this.carNamesValidatorGroup = carNamesValidatorGroup;
        carNames = this.validateCarNames();
    }

    private String validateCarNames() {
        String carNamesInput = Console.readLine();
        this.carNamesValidatorGroup.validate(carNamesInput);
        return carNamesInput;
    }

    public String getCarNames() {
        return carNames;
    }
}
