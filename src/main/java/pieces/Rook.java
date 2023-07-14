package pieces;

import softeer2nd.Board;
import utils.Position;

public class Rook extends Piece {
    private Rook(Color color, Type type, Position pos) {
        super(color, type, pos);
    }

    public static Piece createBlack(Position pos) {
        return new Rook(Color.BLACK, Type.ROOK, pos);
    }

    public static Piece createWhite(Position pos) {
        return new Rook(Color.WHITE, Type.ROOK, pos);
    }

    @Override
    public void verifyMovePosition(Board board, Position targetPosition) {
        verifyMovePossible(board, targetPosition);
    }
}
