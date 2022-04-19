package racingcar.domain.validator;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.validator.impl.CarNamesOverlapValidator;
import racingcar.domain.validator.impl.CarNamesLengthValidator;
import racingcar.domain.validator.impl.CarQtyValidator;

public class CarNamesValidatorGroup {
    private final List<InputValidator> validators;

    public CarNamesValidatorGroup() {
        validators = Arrays.asList(
                new CarQtyValidator(),
                new CarNamesLengthValidator(),
                new CarNamesOverlapValidator()
        );
    }

    public void validate(String input) {
        for (InputValidator validator : validators) {
            validator.validate(input);
        }
    }
}
