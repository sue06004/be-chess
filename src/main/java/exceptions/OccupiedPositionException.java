package exceptions;

public class OccupiedPositionException extends RuntimeException{
    public OccupiedPositionException() {
        super("이미 다른 기물이 위치하고 있습니다");
    }
}
