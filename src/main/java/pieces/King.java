package pieces;

import softeer2nd.Board;
import utils.Position;

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


    public boolean verifyMovePosition(Board board, Position targetPosition) {
        return verifyMovePossible(board, targetPosition);
    }
}
