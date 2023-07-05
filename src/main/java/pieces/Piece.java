package pieces;

public class Piece {

    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final String BLACK_PAWN_REPRESENTATION = "P";
    public static final String WHITE_PAWN_REPRESENTATION = "p";
    public static final String BLACK_KNIGHT_REPRESENTATION = "N";
    public static final String WHITE_KNIGHT_REPRESENTATION = "n";
    public static final String BLACK_ROOK_REPRESENTATION = "R";
    public static final String WHITE_ROOK_REPRESENTATION = "r";
    public static final String BLACK_BISHOP_REPRESENTATION = "B";
    public static final String WHITE_BISHOP_REPRESENTATION = "b";
    public static final String BLACK_QUEEN_REPRESENTATION = "Q";
    public static final String WHITE_QUEEN_REPRESENTATION = "q";
    public static final String BLACK_KING_REPRESENTATION = "K";
    public static final String WHITE_KING_REPRESENTATION = "k";

    private String color;
    private String representation;

    private Piece(String color, String representation){
        this.color = color;
        this.representation = representation;
    }

    public static Piece createBlackPawn(){
        Piece piece = new Piece(BLACK_COLOR,BLACK_PAWN_REPRESENTATION);
        return piece;
    }
    public static Piece createWhitePawn(){
        Piece piece = new Piece(WHITE_COLOR, WHITE_PAWN_REPRESENTATION);
        return piece;
    }
    public static Piece createBlackKnight(){
        Piece piece = new Piece(BLACK_COLOR,BLACK_KNIGHT_REPRESENTATION);
        return piece;
    }
    public static Piece createWhiteKnight(){
        Piece piece = new Piece(WHITE_COLOR,WHITE_KNIGHT_REPRESENTATION);
        return piece;
    }
    public static Piece createBlackRook(){
        Piece piece = new Piece(BLACK_COLOR,BLACK_ROOK_REPRESENTATION);
        return piece;
    }
    public static Piece createWhiteRook(){
        Piece piece = new Piece(WHITE_COLOR,WHITE_ROOK_REPRESENTATION);
        return piece;
    }
    public static Piece createBlackBishop(){
        Piece piece = new Piece(BLACK_COLOR,BLACK_BISHOP_REPRESENTATION);
        return piece;
    }
    public static Piece createWhiteBishop(){
        Piece piece = new Piece(WHITE_COLOR,WHITE_BISHOP_REPRESENTATION);
        return piece;
    }
    public static Piece createBlackQueen(){
        Piece piece = new Piece(BLACK_COLOR,BLACK_QUEEN_REPRESENTATION);
        return piece;
    }
    public static Piece createWhiteQueen(){
        Piece piece = new Piece(WHITE_COLOR,WHITE_QUEEN_REPRESENTATION);
        return piece;
    }
    public static Piece createBlackKing(){
        Piece piece = new Piece(BLACK_COLOR,BLACK_KING_REPRESENTATION);
        return piece;
    }
    public static Piece createWhiteKing(){
        Piece piece = new Piece(WHITE_COLOR,WHITE_KING_REPRESENTATION);
        return piece;
    }

    public String getColor(){
        return color;
    }
    public String getRepresentation(){
        return this.representation;
    }

    public boolean isBlack(){
        return color.equals(BLACK_COLOR);
    }
    public boolean isWhite(){
        return color.equals(WHITE_COLOR);
    }
}
