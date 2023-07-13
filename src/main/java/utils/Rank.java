package utils;

import pieces.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static softeer2nd.Board.BOARD_LENGTH;

public class Rank {

    List<Piece> rank;

    public Rank() {
        this.rank = new ArrayList<>();
    }

    public static Rank createBlankRank(int rankIdx) {
        Rank rank = new Rank();
        for (int file = 0; file < BOARD_LENGTH; file++) {
            String pos = (char) ('a' + file) + String.valueOf(BOARD_LENGTH - rankIdx);
            rank.add(Blank.createBlank(Position.createPosition(pos)));
        }
        return rank;
    }

    public static Rank createBlackPawnRank() {
        Rank rank = new Rank();
        for (int file = 0; file < BOARD_LENGTH; file++) {
            String pos = (char) ('a' + file) + "7";
            rank.add(Pawn.createBlack(Position.createPosition(pos)));
        }
        return rank;
    }

    public static Rank createWhitePawnRank() {
        Rank rank = new Rank();
        for (int file = 0; file < BOARD_LENGTH; file++) {
            String pos = (char) ('a' + file) + "2";
            rank.add(Pawn.createWhite(Position.createPosition(pos)));
        }
        return rank;
    }

    public static Rank createBlackInitRank() {
        Rank rank = new Rank();
        rank.add(Rook.createBlack(Position.createPosition("a8")));
        rank.add(Knight.createBlack(Position.createPosition("b8")));
        rank.add(Bishop.createBlack(Position.createPosition("c8")));
        rank.add(Queen.createBlack(Position.createPosition("d8")));
        rank.add(King.createBlack(Position.createPosition("e8")));
        rank.add(Bishop.createBlack(Position.createPosition("f8")));
        rank.add(Knight.createBlack(Position.createPosition("g8")));
        rank.add(Rook.createBlack(Position.createPosition("h8")));
        return rank;
    }

    public static Rank createWhiteInitRank() {
        Rank rank = new Rank();
        rank.add(Rook.createWhite(Position.createPosition("a1")));
        rank.add(Knight.createWhite(Position.createPosition("b1")));
        rank.add(Bishop.createWhite(Position.createPosition("c1")));
        rank.add(Queen.createWhite(Position.createPosition("d1")));
        rank.add(King.createWhite(Position.createPosition("e1")));
        rank.add(Bishop.createWhite(Position.createPosition("f1")));
        rank.add(Knight.createWhite(Position.createPosition("g1")));
        rank.add(Rook.createWhite(Position.createPosition("h1")));
        return rank;
    }


    public void add(Piece piece) {
        rank.add(piece);
    }

    public void addAll(List<Piece> pieces) {
        rank.addAll(pieces);
    }

    public void set(int idx, Piece piece) {
        rank.set(idx, piece);
    }

    public Piece get(int idx) {
        return rank.get(idx);
    }

    public void sort() {
        Collections.sort(rank);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Piece p : this.rank) {
            pieceAppendStringBuilder(sb, p);
        }
        return sb.toString();
    }

    private void pieceAppendStringBuilder(StringBuilder sb, Piece piece) {
        if (piece.isBlack()) {
            sb.append(piece.getBlackRepresentation());
        } else {
            sb.append(piece.getWhiteRepresentation());
        }
    }

    public int count(Piece.Color color, Piece.Type type) {
        return (int) rank.stream()
                .filter(piece -> piece.equalsColor(color) && piece.equalsType(type))
                .count();
    }

    public List<Piece> collectPieces(Piece.Color color) {
        return rank.stream().filter(piece -> piece.equalsColor(color))
                .collect(Collectors.toList());
    }
}
