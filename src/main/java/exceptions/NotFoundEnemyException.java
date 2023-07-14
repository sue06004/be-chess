package exceptions;

public class NotFoundEnemyException extends RuntimeException{
    public NotFoundEnemyException(){
        super("상대방 기물이 존재 하지 않습니다.");
    }
}
