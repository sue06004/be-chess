package softeer2nd;

public class ChessView {

    private ChessView() {
    }

    public static void showBoard(Board board) {
        System.out.println(board.toString());
    }

}
