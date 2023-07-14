package exceptions;

public class BlankMoveException extends RuntimeException{
    public BlankMoveException() {
        super("해당 위치엔 기물이 존재하지 않습니다.");
    }
}
