package softeer2nd;

public class ChessView {
    Board board;

    private ChessView(Board board) {
        this.board = board;
    }

    public static ChessView createChessView(Board board) {
        return new ChessView(board);
    }

    public void showBoard() {
        System.out.println(board.toString());
    }

}
