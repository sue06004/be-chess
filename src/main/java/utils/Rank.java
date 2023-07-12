package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import pieces.Piece;

public class Rank {

    List<Piece> rank;

    public Rank() {
        this.rank = new ArrayList<>();
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
