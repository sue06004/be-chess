package softeer2nd;

import pieces.Piece;
import utils.Position;

public class ChessGame {

    private Board board;

    private ChessGame(Board board) {
        this.board = board;
    }

    public static ChessGame createChessGame(Board board) {
        return new ChessGame(board);
    }

    public boolean move(String sourcePos, String targetPos) {
        Position sourcePosition = Position.createPosition(sourcePos);
        Position targetPosition = Position.createPosition(targetPos);

        Piece sourcePiece = board.findPiece(sourcePos);
        if (sourcePiece.verifyMovePosition(board, targetPosition)) {
            board.moving(sourcePosition, targetPosition);
            return true;
        }
        return false;
    }

    public double calculatePoint(Piece.Color color) {
        double point = 0;
        for (int file = 0; file < Board.BOARD_LENGTH; file++) {
            point += calculatePointFile(file, color);
        }
        return point;
    }

    private double calculatePointFile(int file, Piece.Color color) {

        double cntPawn = 0;
        double point = 0;

        for (int rank = 1; rank <= Board.BOARD_LENGTH; rank++) {
            Position position = Position.createPosition((char) ('a' + file) + String.valueOf(rank));
            Piece piece = board.findPiece(position);

            point += getPiecePoint(piece, color);
            cntPawn += isPawn(piece);
        }
        if (cntPawn > 1) {
            point -= cntPawn * 0.5;
        }
        return point;
    }

    private double getPiecePoint(Piece piece, Piece.Color color) {
        if (piece.equalsColor(color)) {
            return piece.getDefaultPoint();
        }
        return 0.0;
    }

    private double isPawn(Piece piece) {
        if (piece.equalsType(Piece.Type.PAWN) && (piece.equalsColor(Piece.Color.WHITE))) {
            return 1.0;
        }
        return 0.0;
    }

}
