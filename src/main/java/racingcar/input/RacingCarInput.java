package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.validator.CarNamesValidatorGroup;
import racingcar.view.OutputView;

public class RacingCarInput {
    private final CarNamesValidatorGroup carNamesValidatorGroup;
    private final String carNames;

    public RacingCarInput(CarNamesValidatorGroup carNamesValidatorGroup) {
        this.carNamesValidatorGroup = carNamesValidatorGroup;
        carNames = this.validateCarNames();
    }

    private String validateCarNames() {
        String carNamesInput = "";

        try {
            carNamesInput = Console.readLine();
            this.carNamesValidatorGroup.validate(carNamesInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return validateCarNames();
        }

        return carNamesInput;
    }

    public String getCarNames() {
        return carNames;
    }
}
