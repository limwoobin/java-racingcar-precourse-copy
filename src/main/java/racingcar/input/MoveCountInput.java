package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.MoveCount;
import racingcar.domain.validator.InputValidator;

public class MoveCountInput {
    private final InputValidator inputValidator;
    private final int moveCountInteger;

    public MoveCountInput(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
        String moveCountInput = this.receiveMoveCountInput();
        this.moveCountInteger = Integer.parseInt(moveCountInput);
    }

    private String receiveMoveCountInput() {
        String moveCountInput = Console.readLine();
        inputValidator.validate(moveCountInput);
        return moveCountInput;
    }

    public MoveCount getMoveCount() {
        return new MoveCount(moveCountInteger);
    }
}
