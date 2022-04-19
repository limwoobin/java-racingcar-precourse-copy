package racingcar.domain.validator.impl;

import racingcar.domain.ExceptionType;
import racingcar.domain.validator.InputValidator;

public class MoveCountValidator implements InputValidator {
    private static final String MOVE_COUNT_REGEX = "^[1-9]$";

    @Override
    public void validate(String input) {
        if (!input.matches(MOVE_COUNT_REGEX)) {
            throw new IllegalArgumentException(ExceptionType.INVALID_MOVE_COUNT_INPUT.getMessage());
        }
    }
}
