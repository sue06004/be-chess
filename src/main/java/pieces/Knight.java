package pieces;

import softeer2nd.Board;
import utils.Position;

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
    public void verifyMovePosition(Board board, Position targetPosition) {
        verifyMovePossible(board, targetPosition);
    }
}
