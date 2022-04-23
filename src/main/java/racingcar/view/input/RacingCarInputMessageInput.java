package racingcar.view.input;

public class RacingCarInputMessageInput implements InputPrintMessage {

    @Override
    public void messageOutput() {
        System.out.println("경주 할 자동차 이름 (이름은 쉼표(,) 기준으로 구분)");
    }
}
