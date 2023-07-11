package utils;

public class Position {

    private int x;
    private int y;

    private Position(String pos){
        char x = pos.charAt(0);
        char y = pos.charAt(1);

        this.x = x - 'a';
        this.y = Character.getNumericValue(y);
    }

    public static Position createPosition(String pos){
        return new Position(pos);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public boolean equals(Object o) {
        if (o == null){
            return false;
        }
        if(this == o){
            return true;
        }
        if (o instanceof Position){
            Position pos = (Position) o;
            return x == pos.getX() && y == pos.getY();
        }
        return false;
    }
}
