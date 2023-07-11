package softeer2nd;

import utils.Rank;

import static utils.StringUtils.appendNewLine;

public class ChessView {

    private Board board;

    private ChessView(Board board){
        this.board = board;
    }

    public static String showBoard(Board board){
        ChessView cv = new ChessView(board);

        StringBuilder stringBuilder = new StringBuilder();
        for(Rank rank : board.getBoard()){
            stringBuilder.append(appendNewLine(rank.toString()));
        }
        return stringBuilder.toString();
    }
}
