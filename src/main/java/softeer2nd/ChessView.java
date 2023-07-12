package softeer2nd;

import utils.Rank;

import static utils.StringUtils.appendNewLine;

public class ChessView {

    private ChessView() {}

    public static void showBoard(Board board){
        System.out.println(board.toString());
    }

}
