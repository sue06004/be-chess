package exceptions;

public class OccupiedSameColorPiece extends RuntimeException{
    public OccupiedSameColorPiece() {
        super("목적지에 같은 색 기물이 위치하고 있습니다.");
    }
}
