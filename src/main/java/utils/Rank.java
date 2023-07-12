package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pieces.Piece;

public class Rank {

    List<Piece> rank;

    public Rank() {
        this.rank = new ArrayList<>();
    }

    public void add(Piece piece) {
        rank.add(piece);
    }

    public void set(int idx, Piece piece) {
        rank.set(idx, piece);
    }

    public Piece get(int idx) {
        return rank.get(idx);
    }

    public List<Piece> getRank() {
        return rank;
    }

    public void sort() {
        Collections.sort(rank);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Piece p : this.rank) {
            pieceAppendStringBuilder(sb, p);
        }
        return sb.toString();
    }

    private void pieceAppendStringBuilder(StringBuilder sb, Piece piece) {
        if (piece.isBlack()) {
            sb.append(piece.getType().getBlackRepresentation());
        } else {
            sb.append(piece.getType().getWhiteRepresentation());
        }
    }

    public int count(Piece.Color color, Piece.Type type) {
        return (int) rank.stream()
                .filter(piece -> piece.equalsColor(color) && piece.equalsType(type))
                .count();
    }

    public void addEqualColor(Rank pieces, Piece.Color color) {
        pieces.getRank().stream().filter(piece -> piece.equalsColor(color))
                .forEach(rank::add);
    }

}
