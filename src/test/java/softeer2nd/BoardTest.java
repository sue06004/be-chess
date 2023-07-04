package softeer2nd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import pieces.Pawn;

public class BoardTest {
    Board board;

    @BeforeEach
    public void init(){
        board = new Board();
    }


    @Test
    @DisplayName("체스 판 생성")
    public void create() throws Exception {
        verifyBoard(Pawn.WHITE_COLOR, 1);
        verifyBoard(Pawn.BLACK_COLOR, 2);

    }
    public void verifyBoard(final String color, int size){
        Pawn pawn = new Pawn(color,"p");
        board.add(pawn);
        assertEquals(size,board.size());
        assertEquals(pawn,board.findPawn(size-1));
    }

    @Test
    @DisplayName("체스판 초기화")
    public void initialize() throws Exception{
        Board board = new Board();
        board.initialize();
        assertEquals("pppppppp", board.getWhitePawnsResult());
        assertEquals("PPPPPPPP", board.getBlackPawnsResult());

        System.out.println(board.print());
    }
}