package pieces;

import exceptions.BlankMoveException;
import softeer2nd.Board;
import utils.Direction;
import utils.Position;

import java.util.ArrayList;
import java.util.List;

public class Blank extends Piece {

    private Blank(Piece.Color color, Piece.Type type, Position pos) {
        super(color, type, pos);
    }

    public static Piece createBlank(Position pos) {
        return new Blank(Color.NOCOLOR, Type.NO_PIECE, pos);
    }

    @Override
    public void verifyMovePosition(Board board, Position targetPosition) {
        throw new BlankMoveException();
    }

    @Override
    public List<Direction> getDirectionList() {
        return new ArrayList<>();
    }
}
