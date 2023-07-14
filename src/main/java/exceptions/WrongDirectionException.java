package exceptions;

public class WrongDirectionException extends RuntimeException{
    public WrongDirectionException() {
        super("기물이 움직일 수 없는 위치입니다.");
    }
}
