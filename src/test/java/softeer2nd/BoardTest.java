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
    public void setup() {
        board = new Board();
    }

    @Test
    @DisplayName("체스판 초기화")
    public void initialize() {
        board.initialize();
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                board.toString()
        );
    }

    @Test
    @DisplayName("빈 체스판 만들기")
    public void initializeEmpty() {
        board.initializeEmpty();
        Piece piece = board.findPiece("a2");
        System.out.println(piece.getPosition().getX());
        System.out.println(piece.getPosition().getY());
        String blankRank = appendNewLine("........");
        assertEquals(
                blankRank + blankRank +
                        blankRank + blankRank +
                        blankRank + blankRank +
                        blankRank + blankRank,
                board.toString()
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
        ChessView.showBoard(board);
    }

    @Test
    @DisplayName("기물과 색에 해당하는 기물의 개수를 반환")
    public void pieceCount() {
        board.initialize();

        assertEquals(1, board.countPiece(Color.WHITE, Piece.Type.KING));
        assertEquals(8, board.countPiece(Color.WHITE, Piece.Type.PAWN));
    }

    @Test
    @DisplayName("정렬 테스트 BLACk")
    public void sortBlack() throws Exception {
        board.initialize();
        Rank pieces = board.sort(Color.BLACK);
        assertEquals("QRRBBNNPPPPPPPPK", pieces.toString());
    }

    @Test
    @DisplayName("정렬 테스트 WHITE")
    public void sortWhite() throws Exception {
        board.initialize();
        Rank pieces = board.sort(Color.WHITE);
        assertEquals("qrrbbnnppppppppk", pieces.toString());
    }
}
