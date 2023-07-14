package exceptions;

public class OccupiedPathException extends RuntimeException{
    public OccupiedPathException() {
        super("기물 이동 경로에 다른 기물이 위치하여 움직일 수 없습니다.");
    }
}
