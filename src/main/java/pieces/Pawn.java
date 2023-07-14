package pieces;

import exceptions.NotFoundEnemyException;
import exceptions.OccupiedPathException;
import exceptions.OccupiedSameColorPiece;
import exceptions.WrongDirectionException;
import softeer2nd.Board;
import utils.Direction;
import utils.Position;

import java.util.List;

public class Pawn extends Piece {
    private Pawn(Color color, Type type, Position pos) {
        super(color, type, pos);
    }

    public static Piece createBlack(Position pos) {
        return new Pawn(Color.BLACK, Type.PAWN, pos);
    }

    public static Piece createWhite(Position pos) {
        return new Pawn(Color.WHITE, Type.PAWN, pos);
    }

    @Override
    public void verifyMovePosition(Board board, Position targetPosition) {
        Position sourcePosition = getPosition();
        Position.checkBoundary(targetPosition);
        Piece targetPiece = board.findPiece(targetPosition);
        int xDir = targetPosition.getX() - sourcePosition.getX();
        int yDir = targetPosition.getY() - sourcePosition.getY();

        Direction dir = Direction.valueOf(xDir, yDir);
        if (isBlack() && dir == Direction.SOUTH) {
            if (!targetPiece.isBlank()) {
                throw new OccupiedPathException();
            }
            return;
        } else if (isBlack() && Direction.blackPawnDirection().contains(dir)) {
            if (targetPiece.isBlank()) {
                throw new NotFoundEnemyException();
            }
            if (equalsColor(targetPiece.getColor())) {
                throw new OccupiedSameColorPiece();
            }
            return;
        } else if (isWhite() && dir == Direction.NORTH) {
            if (!targetPiece.isBlank()) {
                throw new OccupiedPathException();
            }
            return;
        } else if (isWhite() && Direction.whitePawnDirection().contains(dir)) {
            if (targetPiece.isBlank()) {
                throw new NotFoundEnemyException();
            }
            if (equalsColor(targetPiece.getColor())) {
                throw new OccupiedSameColorPiece();
            }
            return;
        }
        throw new WrongDirectionException();
    }

    @Override
    public List<Direction> getDirectionList() {
        if (isBlack()) {
            return Direction.blackPawnDirection();
        }
        return Direction.whitePawnDirection();
    }
}
