package pieces;

import softeer2nd.Board;
import utils.Direction;
import utils.Position;

import java.util.ArrayList;
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

    public abstract boolean verifyMovePosition(Board board, Position pos);

    protected boolean verifyMovePossible(Board board, Position targetPosition) {
        Position sourcePosition = getPosition();
        if (board.checkBoundary(targetPosition)) {
            Piece targetPiece = board.findPiece(targetPosition);
            int xDir = getXDirection(sourcePosition, targetPosition);
            int yDir = getYDirection(sourcePosition, targetPosition);

            Direction dir = Direction.valueOf(xDir, yDir);
            List<Direction> dirList = getDirectionList(type);
            if (dirList.contains(dir)) {
                Position newPos = Position.createPosition((char) ('a' + sourcePosition.getX() + xDir) + String.valueOf(sourcePosition.getY() + yDir));
                return !equalsColor(targetPiece.getColor()) && board.checkOtherPiece(newPos, targetPosition, xDir, yDir);
            }
        }
        return false;
    }

    private List<Direction> getDirectionList(Type type) {
        if (type == Type.KING || type == Type.QUEEN) {
            return Direction.everyDirection();
        } else if (type == Type.ROOK) {
            return Direction.linearDirection();
        } else if (type == Type.BISHOP) {
            return Direction.diagonalDirection();
        } else if (type == Type.KNIGHT) {
            return Direction.knightDirection();
        } else if (type == Type.PAWN && isBlack()) {
            return Direction.blackPawnDirection();
        } else if (type == Type.PAWN && isWhite()) {
            return Direction.whitePawnDirection();
        }
        return new ArrayList<>();
    }

    private int getXDirection(Position sourcePosition, Position targetPosition) {
        if (type == Type.KNIGHT || type == Type.KING) {
            return targetPosition.getX() - sourcePosition.getX();
        } else if (type == Type.QUEEN || type == Type.ROOK || type == Type.BISHOP) {
            return calculateXDirection(sourcePosition, targetPosition);
        }
        return 0;
    }

    private int calculateXDirection(Position sourcePosition, Position targetPosition) {
        if (targetPosition.getX() - sourcePosition.getX() == 0) {
            return 0;
        } else {
            return (targetPosition.getX() - sourcePosition.getX()) / abs(targetPosition.getX() - sourcePosition.getX());
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
        if (targetPosition.getY() - sourcePosition.getY() == 0) {
            return 0;
        } else {
            return (targetPosition.getY() - sourcePosition.getY()) / abs(targetPosition.getY() - sourcePosition.getY());
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
            return color == piece.getColor() && type == piece.getType() && position.equals(piece.getPosition());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, position);
    }

    @Override
    public int compareTo(Piece p) {
        return Double.compare(p.getType().getDefaultPoint(), type.getDefaultPoint());
    }


}
