package pieces;

import softeer2nd.Board;
import utils.Position;

public class Blank extends Piece {

    private Blank(Piece.Color color, Piece.Type type, Position pos) {
        super(color, type, pos);
    }

    public static Piece createBlank(Position pos) {
        return new Blank(Color.NOCOLOR, Type.NO_PIECE, pos);
    }

    public boolean verifyMovePosition(Board board, Position targetPosition) {
        return false;
    }

}
