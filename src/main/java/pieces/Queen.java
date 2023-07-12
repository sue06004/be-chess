package pieces;

import softeer2nd.Board;
import utils.Position;

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
    public boolean verifyMovePosition(Board board, Position targetPosition) {
        return verifyMovePossible(board, targetPosition);
    }
}
