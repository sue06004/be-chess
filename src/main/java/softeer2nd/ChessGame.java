package softeer2nd;

import exceptions.TurnException;
import pieces.Piece;
import utils.Position;

public class ChessGame {

    private Board board;
    private Piece.Color turn = Piece.Color.WHITE;

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
        checkTurn(sourcePiece);
        sourcePiece.verifyMovePosition(board, targetPosition);
        board.moving(sourcePosition, targetPosition);

        nextTurn();
        return true;
    }

    private void checkTurn(Piece sourcePiece) {
        if (!sourcePiece.equalsColor(turn)) {
            throw new TurnException();
        }
    }

    public void nextTurn() {
        if (turn == Piece.Color.WHITE) {
            turn = Piece.Color.BLACK;
        } else {
            turn = Piece.Color.WHITE;
        }

    }

    //테스트 용도
    public boolean moveExceptTurn(String sourcePos, String targetPos) {
        Position sourcePosition = Position.createPosition(sourcePos);
        Position targetPosition = Position.createPosition(targetPos);

        Piece sourcePiece = board.findPiece(sourcePos);

        sourcePiece.verifyMovePosition(board, targetPosition);
        board.moving(sourcePosition, targetPosition);
        nextTurn();
        return true;
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
