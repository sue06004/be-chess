package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {

    @Test
    @DisplayName("기물 생성 및 색 확인")
    public void create_piece() {
        verifyPawn(Piece.createWhitePawn(),Piece.WHITE_COLOR, Piece.WHITE_PAWN_REPRESENTATION);
        verifyPawn(Piece.createBlackPawn(),Piece.BLACK_COLOR, Piece.BLACK_PAWN_REPRESENTATION);
        verifyPawn(Piece.createWhiteKnight(),Piece.WHITE_COLOR, Piece.WHITE_KNIGHT_REPRESENTATION);
        verifyPawn(Piece.createBlackKnight(),Piece.BLACK_COLOR, Piece.BLACK_KNIGHT_REPRESENTATION);
        verifyPawn(Piece.createWhiteRook(),Piece.WHITE_COLOR, Piece.WHITE_ROOK_REPRESENTATION);
        verifyPawn(Piece.createBlackRook(),Piece.BLACK_COLOR, Piece.BLACK_ROOK_REPRESENTATION);
        verifyPawn(Piece.createWhiteBishop(),Piece.WHITE_COLOR, Piece.WHITE_BISHOP_REPRESENTATION);
        verifyPawn(Piece.createBlackBishop(),Piece.BLACK_COLOR, Piece.BLACK_BISHOP_REPRESENTATION);
        verifyPawn(Piece.createWhiteQueen(),Piece.WHITE_COLOR, Piece.WHITE_QUEEN_REPRESENTATION);
        verifyPawn(Piece.createBlackQueen(),Piece.BLACK_COLOR, Piece.BLACK_QUEEN_REPRESENTATION);
        verifyPawn(Piece.createWhiteKing(),Piece.WHITE_COLOR, Piece.WHITE_KING_REPRESENTATION);
        verifyPawn(Piece.createBlackKing(),Piece.BLACK_COLOR, Piece.BLACK_KING_REPRESENTATION);
    }

    void verifyPawn(final Piece piece, final String color, final String representation){
        assertEquals(color, piece.getColor());
        assertEquals(representation, piece.getRepresentation());
        if (color.equals(Piece.WHITE_COLOR)){
            assertTrue(piece.isWhite());
            assertFalse(piece.isBlack());
        }
        else{
            assertTrue(piece.isBlack());
            assertFalse(piece.isWhite());
        }
    }
}
