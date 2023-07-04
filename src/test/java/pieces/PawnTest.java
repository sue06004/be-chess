package pieces;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {
    @Test
    @DisplayName("흑백 폰이 생성되어야 한다")
    public void create() {
        String white="white";
        String black="black";
        Pawn pawn1 = new Pawn(white);
        assertThat(pawn1.getColor()).isEqualTo(white);

        Pawn pawn2 = new Pawn(black);
        assertThat(pawn2.getColor()).isEqualTo(black);

        verifyPawn(white);
        verifyPawn(black);

    }

    @Test
    @DisplayName("기본 생성자로 생성하면 white가 생성되어야 한다.")
    public void create_basic() throws Exception{
        Pawn pawn = new Pawn();
        assertEquals("white",pawn.getColor());
    }

    public void verifyPawn(final String color){
        Pawn pawn = new Pawn(color);
        assertThat(pawn.getColor()).isEqualTo(color);
    }

}