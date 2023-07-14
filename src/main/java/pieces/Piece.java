package pieces;

import exceptions.OccupiedSameColorPiece;
import exceptions.WrongDirectionException;
import softeer2nd.Board;
import utils.Direction;
import utils.Position;

import java.util.List;
import java.util.Objects;

import static java.lang.Math.abs;

public abstract class Piece implements Comparable<Piece> {

    public enum Color {
        WHITE, BLACK, NOCOLOR;
    }

    public enum Type {
        PAWN('p', 1.0),
        ROOK('r', 5.0),
        KNIGHT('n', 2.5),
        BISHOP('b', 3.0),
        QUEEN('q', 9.0),
        KING('k', 0.0),
        NO_PIECE('.', 0.0);

        private char representation;
        private double defaultPoint;

        Type(char representation, double defaultPoint) {
            this.representation = representation;
            this.defaultPoint = defaultPoint;
        }

        public char getWhiteRepresentation() {
            return this.representation;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(this.representation);
        }

        public char getBlankRepresentation() {
            return this.representation;
        }

        public double getDefaultPoint() {
            return defaultPoint;
        }

    }

    private Color color;
    private Type type;
    private Position position;

    protected Piece(Color color, Type type, Position pos) {
        this.color = color;
        this.type = type;
        this.position = pos;
    }

    public Type getType() {
        return type;
    }

    public char getWhiteRepresentation() {
        return type.getWhiteRepresentation();
    }

    public char getBlankRepresentation() {
        return type.getBlankRepresentation();
    }

    public char getBlackRepresentation() {
        return type.getBlackRepresentation();
    }

    public double getDefaultPoint() {
        return type.getDefaultPoint();
    }

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position pos) {
        position = pos;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    public boolean isBlank() {
        return color == Color.NOCOLOR;
    }

    public void verifyMovePosition(Board board, Position targetPosition) {
        Position sourcePosition = getPosition();
        Position.checkBoundary(targetPosition);
        int xDir = getXDirection(sourcePosition, targetPosition);
        int yDir = getYDirection(sourcePosition, targetPosition);
        checkDirection(xDir, yDir);

        Piece targetPiece = board.findPiece(targetPosition);
        checkTargetColor(targetPiece);

        board.checkOtherPiece(sourcePosition, targetPosition, xDir, yDir);
    }

    private void checkDirection(int xDir, int yDir) {
        Direction dir = Direction.valueOf(xDir, yDir);
        List<Direction> dirList = getDirectionList();
        if (!dirList.contains(dir)) {
            throw new WrongDirectionException();
        }
    }

    private void checkTargetColor(Piece targetPiece) {
        if (equalsColor(targetPiece.getColor())) {
            throw new OccupiedSameColorPiece();
        }
    }

    public abstract List<Direction> getDirectionList();


    private int getXDirection(Position sourcePosition, Position targetPosition) {
        if (type == Type.KNIGHT || type == Type.KING) {
            return targetPosition.getX() - sourcePosition.getX();
        } else if (type == Type.QUEEN || type == Type.ROOK || type == Type.BISHOP) {
            return calculateXDirection(sourcePosition, targetPosition);
        }
        return 0;
    }

    private int calculateXDirection(Position sourcePosition, Position targetPosition) {
        int distanceX = targetPosition.getX() - sourcePosition.getX();
        int distanceY = targetPosition.getY() - sourcePosition.getY();
        if (distanceX == 0) {
            return distanceX;
        } else if (abs(distanceX) == abs(distanceY) || distanceY == 0) {
            return distanceX / abs(distanceX);
        } else {
            return distanceX;
        }
    }

    private int getYDirection(Position sourcePosition, Position targetPosition) {
        if (type == Type.KNIGHT || type == Type.KING) {
            return targetPosition.getY() - sourcePosition.getY();
        } else if (type == Type.QUEEN || type == Type.ROOK || type == Type.BISHOP) {
            return calculateYDirection(sourcePosition, targetPosition);
        }
        return 0;
    }

    private int calculateYDirection(Position sourcePosition, Position targetPosition) {
        int distanceX = targetPosition.getX() - sourcePosition.getX();
        int distanceY = targetPosition.getY() - sourcePosition.getY();
        if (distanceY == 0) {
            return distanceY;
        } else if (abs(distanceX) == abs(distanceY) || distanceX == 0) {
            return distanceY / abs(distanceY);
        } else {
            return distanceY;
        }
    }

    public boolean equalsColor(Color color) {
        return this.color == color;
    }

    public boolean equalsType(Type type) {
        return this.type == type;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (o instanceof Piece) {
            Piece piece = (Piece) o;
            return color == piece.getColor() && type == piece.getType() && position == piece.getPosition();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, position);
    }

    @Override
    public int compareTo(Piece p) {
        return Double.compare(p.getDefaultPoint(), type.getDefaultPoint());
    }

}
