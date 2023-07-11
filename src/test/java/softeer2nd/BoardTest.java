package softeer2nd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.King;
import pieces.Piece;
import utils.Position;
import utils.Rank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pieces.Piece.Color;
import static utils.StringUtils.appendNewLine;

public class BoardTest {
    private Board board;

    @BeforeEach
    public void setup(){
        board = new Board();
    }

    @Test
    @DisplayName("체스판 초기화")
    public void initalize(){
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

    @Test
    @DisplayName("빈 체스판 만들기")
    public void initalizeEmpty(){
        board.initializeEmpty();

        String blankRank = appendNewLine("........");
        assertEquals(
                blankRank + blankRank +
                        blankRank + blankRank +
                        blankRank + blankRank +
                        blankRank + blankRank,
                ChessView.showBoard(board)
        );
    }
    @Test
    @DisplayName("기물을 체스판 위에 추가")
    public void put() throws Exception {
        board.initializeEmpty();

        String pos = "b5";
        Position position = Position.createPosition(pos);
        Piece piece = King.createBlack(position);

        board.put(pos, piece);

        assertEquals(piece, board.findPiece(position));
        System.out.println(ChessView.showBoard(board));
    }

    @Test
    @DisplayName("기물과 색에 해당하는 기물의 개수를 반환")
    public void pieceCount() {
        board.initialize();

        assertEquals(1, board.pieceCount(Color.WHITE, Piece.Type.KING));
        assertEquals(8, board.pieceCount(Color.WHITE, Piece.Type.PAWN));
    }
    @Test
    @DisplayName("정렬 테스트")
    public void 기물정렬() throws Exception{
        board.initialize();
        Rank pieces = board.sort(Color.BLACK);
        assertEquals("QRRBBNNPPPPPPPPK",pieces.toString());
    }
}