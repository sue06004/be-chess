package pieces;

import utils.Direction;
import utils.Position;

import java.util.List;

public class King extends Piece {

    private King(Color color, Type type, Position pos) {
        super(color, type, pos);
    }

    public static Piece createBlack(Position pos) {
        return new King(Color.BLACK, Type.KING, pos);
    }

    public static Piece createWhite(Position pos) {
        return new King(Color.WHITE, Type.KING, pos);
    }

    @Override
    public List<Direction> getDirectionList() {
        return Direction.everyDirection();
    }
}
