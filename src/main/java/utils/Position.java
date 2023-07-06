package utils;

public class Position {

    private int x;
    private int y;

    public Position(String pos){
        char x = pos.charAt(0);
        char y = pos.charAt(1);

        this.x = x - 'a';
        this.y = Character.getNumericValue(y);
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
