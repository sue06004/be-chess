package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import pieces.Piece.Type;
import utils.Rank;

import java.util.ArrayList;

public class PieceTest {

    @Test
    public void getRepresentationPerPiece() throws Exception {
        assertEquals('p', Piece.Type.PAWN.getWhiteRepresentation());
        assertEquals('P', Piece.Type.PAWN.getBlackRepresentation());
    }

//    @Test
//    public void create_piece() {
//        verifyPiece(Piece.createWhitePawn(), Piece.createBlackPawn(), Type.PAWN);
//        verifyPiece(Piece.createWhiteKnight(), Piece.createBlackKnight(), Type.KNIGHT);
//        verifyPiece(Piece.createWhiteRook(), Piece.createBlackRook(), Type.ROOK);
//        verifyPiece(Piece.createWhiteBishop(), Piece.createBlackBishop(), Type.BISHOP);
//        verifyPiece(Piece.createWhiteQueen(), Piece.createBlackQueen(), Type.QUEEN);
//        verifyPiece(Piece.createWhiteKing(), Piece.createBlackKing(), Type.KING);
//
//        Piece blank = Piece.createBlank();
//        assertFalse(blank.isWhite());
//        assertFalse(blank.isBlack());
//        assertEquals(Type.NO_PIECE, blank.getType());
//    }
//
//    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Type type) {
//        assertTrue(whitePiece.isWhite());
//        assertEquals(type, whitePiece.getType());
//
//        assertTrue(blackPiece.isBlack());
//        assertEquals(type, blackPiece.getType());
//    }

}
