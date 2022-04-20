package racingcar.view;

public class OutputView {
    public static final String ERROR_HEADER_MESSAGE = "[ERROR]";

    private OutputView() {}

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_HEADER_MESSAGE + " " + message);
    }
}
