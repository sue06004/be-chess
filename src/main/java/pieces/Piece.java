package pieces;

import java.util.Objects;

public class Piece implements Comparable<Piece>{

    public enum Color{
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type{
        PAWN('p',1.0), ROOK('r',5.0), KNIGHT('n',2.5), BISHOP('b',3.0), QUEEN('q',9.0), KING('k',0.0), NO_PIECE('.',0.0);

        private char representation;
        private double defaultPoint;

        Type(char representation, double defaultPoint){
            this.representation = representation;
            this.defaultPoint = defaultPoint;
        }

        public char getWhiteRepresentation(){
            return this.representation;
        }
        public char getBlackRepresentation(){
            return Character.toUpperCase(this.representation);
        }
        public char getBlankRepresentation(){
            return this.representation;
        }
        public double getDefaultPoint(){
            return defaultPoint;
        }

    }

    private Color color;
    private Type type;

    private Piece(Color color, Type type){
        this.color = color;
        this.type = type;
    }

    private static Piece createWhite(Type type){
        Piece piece = new Piece(Color.WHITE, type);
        return piece;
    }
    private static Piece createBlack(Type type){
        Piece piece = new Piece(Color.BLACK, type);
        return piece;
    }

    public static Piece createBlackPawn(){
        Piece piece = createBlack(Type.PAWN);
        return piece;
    }
    public static Piece createWhitePawn(){
        Piece piece = createWhite(Type.PAWN);
        return piece;
    }
    public static Piece createBlackKnight(){
        Piece piece = createBlack(Type.KNIGHT);
        return piece;
    }
    public static Piece createWhiteKnight(){
        Piece piece = createWhite(Type.KNIGHT);
        return piece;
    }
    public static Piece createBlackRook(){
        Piece piece = createBlack(Type.ROOK);
        return piece;
    }
    public static Piece createWhiteRook(){
        Piece piece = createWhite(Type.ROOK);
        return piece;
    }
    public static Piece createBlackBishop(){
        Piece piece = createBlack(Type.BISHOP);
        return piece;
    }
    public static Piece createWhiteBishop(){
        Piece piece = createWhite(Type.BISHOP);
        return piece;
    }
    public static Piece createBlackQueen(){
        Piece piece = createBlack(Type.QUEEN);
        return piece;
    }
    public static Piece createWhiteQueen(){
        Piece piece = createWhite(Type.QUEEN);
        return piece;
    }
    public static Piece createBlackKing(){
        Piece piece = createBlack(Type.KING);
        return piece;
    }
    public static Piece createWhiteKing(){
        Piece piece = createWhite(Type.KING);
        return piece;
    }
    public static Piece createBlank(){
        Piece piece = new Piece(Color.NOCOLOR,Type.NO_PIECE);
        return piece;
    }

    public Type getType(){
        return type;
    }
    public Color getColor(){
        return this.color;
    }
    public boolean equals(Object o){
        Piece piece =(Piece) o;
        return color==piece.color && type==piece.type;
    }

    public boolean isBlack(){
        return color.equals(Color.BLACK);
    }
    public boolean isWhite(){
        return color.equals(Color.WHITE);
    }

    @Override
    public int compareTo(Piece p){
        if(this.type.getDefaultPoint() > p.getType().getDefaultPoint())
            return -1;
        else if(this.type.getDefaultPoint()< p.getType().getDefaultPoint())
            return 1;
        else
            return 0;
    }
}
