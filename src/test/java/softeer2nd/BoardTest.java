package softeer2nd;


import org.junit.Before;
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
        Pawn pawn = new Pawn(color);
        board.add(pawn);
        assertEquals(size,board.size());
        assertEquals(pawn,board.findPawn(size-1));

    }
}