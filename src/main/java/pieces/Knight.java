package pieces;

import softeer2nd.Board;
import utils.Direction;
import utils.Position;

import static java.lang.Math.abs;

public class Knight extends Piece {
    private Knight(Color color, Type type, Position pos) {
        super(color, type, pos);
    }

    public static Piece createBlack(Position pos) {
        return new Knight(Color.BLACK, Type.KNIGHT, pos);
    }

    public static Piece createWhite(Position pos) {
        return new Knight(Color.WHITE, Type.KNIGHT, pos);
    }

    @Override
    public boolean verifyMovePosition(Board board, Position targetPosition) {
        return verifyMovePossible(board, targetPosition);
    }
}
