package utils;

import exceptions.OutOfBoardBoundaryException;

import java.util.Objects;

import static softeer2nd.Board.BOARD_LENGTH;

public class Position {

    private int x;
    private int y;

    private Position(String pos) {
        char x = pos.charAt(0);
        char y = pos.charAt(1);


        this.x = x - 'a';
        this.y = Character.getNumericValue(y);
    }

    public static Position createPosition(String pos) {
        return new Position(pos);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static void checkBoundary(Position pos) {
        if(!(pos.getY() > 0 && pos.getY() <= BOARD_LENGTH && pos.getX() >= 0 && pos.getX() < BOARD_LENGTH)){
            throw new OutOfBoardBoundaryException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (o instanceof Position) {
            Position pos = (Position) o;
            return x == pos.getX() && y == pos.getY();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
