package racingcar.input;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.MoveCount;
import racingcar.domain.validator.InputValidator;
import racingcar.view.OutputView;

public class MoveCountInput {
    private final InputValidator inputValidator;
    private final int moveCountInteger;

    public MoveCountInput(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
        this.moveCountInteger = Integer.parseInt(receiveMoveCountInput());
    }

    private String receiveMoveCountInput() {
        String moveCountInput = "";

        try {
            moveCountInput = Console.readLine();
            inputValidator.validate(moveCountInput);
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e.getMessage());
            return receiveMoveCountInput();
        }

        return moveCountInput;
    }

    public MoveCount getMoveCount() {
        return new MoveCount(moveCountInteger);
    }
}
