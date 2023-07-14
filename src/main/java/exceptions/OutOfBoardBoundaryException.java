package exceptions;

public class OutOfBoardBoundaryException extends RuntimeException{
    public OutOfBoardBoundaryException() {
        super("해당 위치는 체스판의 범위를 벋어났습니다.");
    }
}
