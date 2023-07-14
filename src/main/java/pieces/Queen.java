package pieces;

import utils.Direction;
import utils.Position;

import java.util.List;

public class Queen extends Piece {

    private Queen(Color color, Type type, Position pos) {
        super(color, type, pos);
    }

    public static Piece createBlack(Position pos) {
        return new Queen(Color.BLACK, Type.QUEEN, pos);
    }

    public static Piece createWhite(Position pos) {
        return new Queen(Color.WHITE, Type.QUEEN, pos);
    }

    @Override
    public List<Direction> getDirectionList() {
        return Direction.everyDirection();
    }
}
