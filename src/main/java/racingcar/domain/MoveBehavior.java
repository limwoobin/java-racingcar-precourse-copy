package racingcar.domain;

public class MoveBehavior {
    private final RandomNumber randomNumber;

    private static final int MOVABLE_STANDARD_VALUE = 4;

    public MoveBehavior() {
        this.randomNumber = new RandomNumber();
    }

    public boolean isMovable() {
        return randomNumber.getRandomNumber() >= MOVABLE_STANDARD_VALUE;
    }
}
