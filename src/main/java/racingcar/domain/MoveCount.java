package racingcar.domain;

public final class MoveCount {
    private int moveCount;

    public MoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public void move() {
        this.moveCount--;
    }

    public int getRemainingMoveCount() {
        return moveCount;
    }
}
