package pieces;

import softeer2nd.Board;
import utils.Position;

public class Bishop extends Piece {

    private Bishop(Piece.Color color, Piece.Type type, Position pos) {
        super(color, type, pos);
    }

    public static Piece createBlack(Position pos) {
        return new Bishop(Color.BLACK, Type.BISHOP, pos);
    }

    public static Piece createWhite(Position pos) {
        return new Bishop(Color.WHITE, Type.BISHOP, pos);
    }

    @Override
    public boolean verifyMovePosition(Board board, Position targetPosition) {
        return verifyMovePossible(board, targetPosition);
    }
}
