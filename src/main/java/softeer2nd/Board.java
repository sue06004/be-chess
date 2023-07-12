package softeer2nd;

import pieces.*;
import utils.Position;
import utils.Rank;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {

    public final static int BOARD_LENGTH = 8;
    private List<Rank> rankList = new ArrayList<>();

    public void initializeEmpty() {
        for (int rankIdx = 0; rankIdx < BOARD_LENGTH; rankIdx++) {
            Rank rank = new Rank();
            blankRank(rankIdx, rank);
            rankList.add(rank);
        }
    }

    public void initialize() {
        for (int rankIdx = 0; rankIdx < BOARD_LENGTH; rankIdx++) {
            initRank(rankIdx);
        }
    }

    private void initRank(int rankIdx) {
        Rank rank = new Rank();

        if (rankIdx == 0) {
            initBlackNotPawn(rank);
        } else if (rankIdx == 1) {
            initBlackPawn(rank);
        } else if (rankIdx == 6) {
            initWhitePawn(rank);
        } else if (rankIdx == 7) {
            initWhiteNotPawn(rank);
        } else {
            blankRank(rankIdx, rank);
        }

        rankList.add(rank);
    }

    private void initBlackNotPawn(Rank rank) {
        rank.add(Rook.createBlack(Position.createPosition("a8")));
        rank.add(Knight.createBlack(Position.createPosition("b8")));
        rank.add(Bishop.createBlack(Position.createPosition("c8")));
        rank.add(Queen.createBlack(Position.createPosition("d8")));
        rank.add(King.createBlack(Position.createPosition("e8")));
        rank.add(Bishop.createBlack(Position.createPosition("f8")));
        rank.add(Knight.createBlack(Position.createPosition("g8")));
        rank.add(Rook.createBlack(Position.createPosition("h8")));
    }

    private void initWhiteNotPawn(Rank rank) {
        rank.add(Rook.createWhite(Position.createPosition("a1")));
        rank.add(Knight.createWhite(Position.createPosition("b1")));
        rank.add(Bishop.createWhite(Position.createPosition("c1")));
        rank.add(Queen.createWhite(Position.createPosition("d1")));
        rank.add(King.createWhite(Position.createPosition("e1")));
        rank.add(Bishop.createWhite(Position.createPosition("f1")));
        rank.add(Knight.createWhite(Position.createPosition("g1")));
        rank.add(Rook.createWhite(Position.createPosition("h1")));
    }

    private void initBlackPawn(Rank rank) {
        for (int file = 0; file < BOARD_LENGTH; file++) {
            String pos = 'a' + file + "7";
            rank.add(Pawn.createBlack(Position.createPosition(pos)));
        }
    }

    private void initWhitePawn(Rank rank) {
        for (int file = 0; file < BOARD_LENGTH; file++) {
            String pos = 'a' + file + "7";
            rank.add(Pawn.createWhite(Position.createPosition(pos)));
        }
    }

    private void blankRank(int y, Rank rank) {
        for (int file = 0; file < BOARD_LENGTH; file++) {
            String pos = 'a' + file + String.valueOf(BOARD_LENGTH - y);
            rank.add(Blank.createBlank(Position.createPosition(pos)));
        }
    }

    public Rank sort(Piece.Color color) {
        Rank pieces = new Rank();

        for (Rank rank : rankList) {
            List<Piece> sameColorPieces = rank.collectPieces(color);
            pieces.addAll(sameColorPieces);
        }
        pieces.sort();
        return pieces;
    }

    public Piece findPiece(String pos) {
        Position position = Position.createPosition(pos);

        Rank rank = rankList.get(BOARD_LENGTH - position.getY());
        return rank.get(position.getX());
    }

    public Piece findPiece(Position position) {
        Rank rank = rankList.get(BOARD_LENGTH - position.getY());
        return rank.get(position.getX());
    }

    public void put(String pos, Piece piece) {
        Position position = Position.createPosition(pos);

        Rank rank = rankList.get(BOARD_LENGTH - position.getY());
        rank.set(position.getX(), piece);
    }

    public void moving(Position sourcePosition, Position targetPosition) {
        Piece blankPiece = Blank.createBlank(sourcePosition);
        Piece sourcePiece = findPiece(sourcePosition);

        Rank sourceRank = rankList.get(BOARD_LENGTH - sourcePosition.getY());
        Rank targetRank = rankList.get(BOARD_LENGTH - targetPosition.getY());

        sourcePiece.setPosition(targetPosition);
        sourceRank.set(sourcePosition.getX(), blankPiece);
        targetRank.set(targetPosition.getX(), sourcePiece);
    }

    public static boolean checkBoundary(Position pos) {
        return pos.getY() > 0 && pos.getY() <= BOARD_LENGTH && pos.getX() >= 0 && pos.getX() < BOARD_LENGTH;
    }

    public boolean checkOtherPiece(Position pos, Position targetPos, int xDir, int yDir) {
        if (pos.equals(targetPos)) {
            return true;
        }

        Piece piece = findPiece(pos);

        if (piece.isBlank()) {
            Position newPos = Position.createPosition((char) ('a' + pos.getX() + xDir) + String.valueOf(pos.getY() + yDir));
            return checkOtherPiece(newPos, targetPos, xDir, yDir);
        }
        return false;

    }

    public int countPiece(Piece.Color color, Piece.Type type) {
        int cnt = 0;
        for (Rank rank : rankList) {
            cnt += rank.count(color, type);
        }
        return cnt;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Rank rank : rankList) {
            stringBuilder.append(appendNewLine(rank.toString()));
        }
        return stringBuilder.toString();
    }
}
