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

    public void put(String pos, Piece piece) {
        List<Rank> boardList = board.getBoard();
        Position position = Position.createPosition(pos);

        Rank rank = boardList.get(8 - position.getY());
        rank.set(position.getX(), piece);
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

    public Rank sort(Piece.Color color) {
        List<Rank> boardList = board.getBoard();
        Rank pieces = new Rank();
        for (Rank rank : boardList) {
            sortRank(pieces, rank, color);
        }
        pieces.sort();
        return pieces;
    }

    private void sortRank(Rank pieces, Rank rank, Piece.Color color) {
        for (Piece piece : rank.getRank()) {
            ifEqualColor(pieces, piece, color);
        }
    }

    private void ifEqualColor(Rank pieces, Piece piece, Piece.Color color) {
        if (piece.getColor() == color) {
            pieces.add(piece);
        }
    }

}
