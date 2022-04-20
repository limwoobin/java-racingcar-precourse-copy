package racingcar.domain;

public class Car {
    private final String name;
    private final MoveBehavior moveBehavior;
    private final Distance distance;

    public Car(String name, MoveBehavior moveBehavior) {
        this.name = name;
        this.moveBehavior = moveBehavior;
        this.distance = new Distance();
    }

    public String getName() {
        return name;
    }

    public void move() {
        if (moveBehavior.isMovable()) {
            this.distance.advance();
        }
    }

    public int getDistanceCount() {
        return distance.getDistanceCount();
    }
}
