package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Position;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class KnightTest {
    @Test
    @DisplayName("나이트 피스 테스트")
    void createKing() {
        verifyPiece(Knight.createWhite(Position.createPosition("a1")), Knight.createBlack(Position.createPosition("a1")), Piece.Type.KNIGHT, "a1");
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
