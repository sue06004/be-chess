package softeer2nd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static utils.StringUtils.appendNewLine;

class ChessViewTest {

    Board board;
    ChessView cv;
    @BeforeEach
    public void setup(){
        board = new Board();

    }

    @Test
    @DisplayName("ChessView 테스트")
    void showBoard() {
        board.initialize();
        String blankRank = appendNewLine("........");
        assertEquals(
        appendNewLine("RNBQKBNR") +
                appendNewLine("PPPPPPPP") +
                blankRank + blankRank + blankRank + blankRank +
                appendNewLine("pppppppp") +
                appendNewLine("rnbqkbnr"),
                ChessView.showBoard(board)
        );

    }
}