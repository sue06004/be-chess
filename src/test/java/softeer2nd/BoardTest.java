package softeer2nd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.Piece;
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
    @DisplayName("전체 기물 체스판 생성")
    public void create() throws Exception {
        board.initialize();
        //assertEquals(32,board.pieceCount());
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

    @Test
    @DisplayName("기물과 색에 해당하는 기물의 개수를 반환")
    public void countPiece() throws Exception{
        board.initialize();
        assertEquals(1, board.pieceCount(Piece.Color.WHITE, Piece.Type.KING));
        assertEquals(8, board.pieceCount(Piece.Color.WHITE, Piece.Type.PAWN));
    }

    @Test
    @DisplayName("주어진 위치의 기물을 조회")
    public void findPiece() throws Exception {
        board.initialize();

        assertEquals(Piece.createBlackRook(), board.findPiece("a8"));
        assertEquals(Piece.createBlackRook(), board.findPiece("h8"));
        assertEquals(Piece.createWhiteRook(), board.findPiece("a1"));
        assertEquals(Piece.createWhiteRook(), board.findPiece("h1"));
    }

    @Test
    @DisplayName("기물을 체스판 위에 추가")
    public void move() throws Exception {
        board.initializeEmpty();

        String position = "b5";
        Piece piece = Piece.createBlackRook();
        board.move(position, piece);

        assertEquals(piece, board.findPiece(position));
        System.out.println(board.showBoard());
    }

    @Test
    @DisplayName("점수 계산하기")
    public void caculcatePoint() throws Exception {
        board.initializeEmpty();

        addPiece("b6", Piece.createBlackPawn());
        addPiece("e6", Piece.createBlackQueen());
        addPiece("b8", Piece.createBlackKing());
        addPiece("c8", Piece.createBlackRook());

        addPiece("f2", Piece.createWhitePawn());
        addPiece("f3", Piece.createWhitePawn());
        addPiece("e1", Piece.createWhiteRook());
        addPiece("f1", Piece.createWhiteKing());

        assertEquals(15.0, board.caculcatePoint(Color.BLACK), 0.01);
        assertEquals(6.0, board.caculcatePoint(Color.WHITE), 0.01);

        System.out.println(board.showBoard());
    }

    private void addPiece(String position, Piece piece) {
        board.move(position, piece);
    }

    @Test
    @DisplayName("정렬 테스트")
    public void 기물정렬() throws Exception{
        board.initialize();
        Rank pieces = board.sort(Color.BLACK);
        assertEquals("QRRBBNNPPPPPPPPK",pieces.toString());
    }
}