package pieces;

import softeer2nd.Board;
import utils.Direction;
import utils.Position;

import static java.lang.Math.abs;

public class Pawn extends Piece{
    private Pawn(Color color, Type type, Position pos) {
        super(color, type, pos);
    }

    public static Piece createBlack(Position pos){
        return new Pawn(Color.BLACK, Type.PAWN, pos);
    }
    public static Piece createWhite(Position pos){
        return new Pawn(Color.WHITE, Type.PAWN, pos);
    }

    @Override
    public boolean verifyMovePosition(Board board, Position targetPosition){
        Position sourcePosition = getPosition();
        if (Board.checkBoundary(targetPosition)) {
            Piece targetPiece = board.findPiece(targetPosition);
            int xDir = targetPosition.getX() - sourcePosition.getX();
            int yDir = targetPosition.getY() - sourcePosition.getY();

            Direction dir = Direction.valueOf(xDir, yDir);
            if (isBlack() && dir == Direction.SOUTH) {
                return targetPiece.isBlank();
            } else if (isBlack() && Direction.blackPawnDirection().contains(dir)){
                return !equalsColor(targetPiece.getColor()) ;
            } else if (isWhite() && dir == Direction.NORTH){
                return targetPiece.isBlank();
            } else if (isWhite() && Direction.whitePawnDirection().contains(dir)){
                return !equalsColor(targetPiece.getColor());
            }
        }
        return false;
    }
}
