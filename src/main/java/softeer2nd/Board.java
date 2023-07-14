package softeer2nd;

import exceptions.OccupiedPathException;
import pieces.Blank;
import pieces.Piece;
import utils.Position;
import utils.Rank;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {

    public final static int BOARD_LENGTH = 8;
    private final static int BLACK_PAWN_INIT_IDX = 1;
    private final static int BLACK_PIECE_INIT_IDX = 0;
    private final static int WHITE_PAWN_INIT_IDX = 6;
    private final static int WHITE_PIECE_INIT_IDX = 7;
    private List<Rank> rankList = new ArrayList<>();

    public void initializeEmpty() {
        for (int rankIdx = 0; rankIdx < BOARD_LENGTH; rankIdx++) {
            rankList.add(Rank.createBlankRank(rankIdx));
        }
    }

    public void initialize() {
        initializeEmpty();
        rankList.set(BLACK_PAWN_INIT_IDX, Rank.createBlackPawnRank());
        rankList.set(BLACK_PIECE_INIT_IDX, Rank.createBlackInitRank());
        rankList.set(WHITE_PAWN_INIT_IDX, Rank.createWhitePawnRank());
        rankList.set(WHITE_PIECE_INIT_IDX, Rank.createWhiteInitRank());

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


    public void checkOtherPiece(Position sourcePosition, Position targetPosition, int xDir, int yDir) {
        String strPosition = StringUtils.createStringPosition(sourcePosition.getX() + xDir, sourcePosition.getY() + yDir);
        Position position = Position.createPosition(strPosition);

        if (position.equals(targetPosition)) {
            return;
        }
        Piece piece = findPiece(position);
        if (!piece.isBlank()) {
            throw new OccupiedPathException();
        }
        checkOtherPiece(position, targetPosition, xDir, yDir);
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
