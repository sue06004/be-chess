package softeer2nd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import pieces.Piece;
import static utils.StringUtils.appendNewLine;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setup(){
        board = new Board();
    }

    @Test
    @DisplayName("전체 기물 체스판 생성")
    public void create() throws Exception {
        board.initialize();
        assertEquals(32,board.pieceCount());
        String blankRank = appendNewLine("........");
        assertEquals(
    appendNewLine("RNBQKBNR") +
            appendNewLine("PPPPPPPP") +
            blankRank + blankRank + blankRank + blankRank +
            appendNewLine("pppppppp") +
            appendNewLine("rnbqkbnr"),
            board.showBoard()
        );
    }
}