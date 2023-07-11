package softeer2nd;

import pieces.Piece;
import utils.Position;
import utils.Rank;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class ChessGame {

    private Board board;

    private ChessGame(Board board) {
        this.board = board;
    }

    public static ChessGame createChessGame(Board board){
        return new ChessGame(board);
    }

    public boolean move(String sourcePos, String targetPos) {
        Position sourcePosition = Position.createPosition(sourcePos);
        Position targetPosition = Position.createPosition(targetPos);

        Piece sourcePiece = board.findPiece(sourcePos);
        if (sourcePiece.verifyMovePosition(board, targetPosition)){
            board.moving(sourcePosition, targetPosition);
            return true;
        }
        return false;
    }

    public double caculcatePoint(Piece.Color color) {
        double point = 0;
        for (int rank = 0; rank < 8; rank++) {
            point += calcPointFile(rank, color);
        }
        return point;
    }

    private double calcPointFile(int rank, Piece.Color color) {
        List<Rank> boardList = board.getBoard();
        double[] tmp;
        double cntPawn = 0;
        double point = 0;

        for (int file = 0; file < 8; file++) {
            Rank pieces = boardList.get(file);
            Piece piece = pieces.get(rank);
            tmp = getPiecePoint(piece, color);

            point += tmp[0];
            cntPawn += tmp[1];
        }
        if (cntPawn > 1) {
            point -= cntPawn * 0.5;
        }
        return point;
    }

    private double[] getPiecePoint(Piece piece, Piece.Color color) {
        double cntPawn = 0.0;
        double point = 0.0;
        if (piece.getColor() == color) {
            cntPawn += ifPawn(piece);
            point += piece.getType().getDefaultPoint();
        }
        return new double[]{point, cntPawn};
    }

    private double ifPawn(Piece piece) {
        if (piece.getType() == Piece.Type.PAWN) {
            return 1.0;
        }
        return 0.0;
    }

}
