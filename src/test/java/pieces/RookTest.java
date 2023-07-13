package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RookTest {
    @Test
    @DisplayName("룩 피스 테스트")
    void createKing() {
        verifyPiece(Rook.createWhite(Position.createPosition("a1")), Rook.createBlack(Position.createPosition("a1")), Piece.Type.ROOK, "a1");
    }

    private void verifyPiece(final Piece whitePiece, final Piece blackPiece, final Piece.Type type, String pos) {
        assertTrue(whitePiece.isWhite());
        assertEquals(type, whitePiece.getType());

        assertTrue(blackPiece.isBlack());
        assertEquals(type, blackPiece.getType());

        assertEquals(Position.createPosition("a1"), whitePiece.getPosition());
        assertEquals(Position.createPosition("a1"), blackPiece.getPosition());
    }
}
