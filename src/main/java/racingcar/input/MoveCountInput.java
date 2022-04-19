package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.validator.InputValidator;

public class MoveCountInput {
    private final InputValidator inputValidator;
    private final int moveCount;

    public MoveCountInput(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
        String moveCountInput = this.receiveMoveCountInput();
        this.moveCount = Integer.parseInt(moveCountInput);
    }

    private String receiveMoveCountInput() {
        String moveCountInput = Console.readLine();
        inputValidator.validate(moveCountInput);
        return moveCountInput;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
