package exceptions;

public class TurnException extends RuntimeException{
    public TurnException() {
        super("상대방 기물을 움직일 수 없습니다.");
    }
}
