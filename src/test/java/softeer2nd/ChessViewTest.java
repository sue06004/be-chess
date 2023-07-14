package softeer2nd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChessViewTest {

    Board board;
    ChessView chessView;
    @BeforeEach
    public void setup(){
        board = new Board();
        chessView = ChessView.createChessView(board);
    }

    @Test
    @DisplayName("ChessView 테스트")
    void showBoard() {
        board.initialize();
        chessView.showBoard();
    }
}
