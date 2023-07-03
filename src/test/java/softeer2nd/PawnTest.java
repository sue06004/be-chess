package softeer2nd;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흑백 폰이 생성되어야 한다")
    public void create() {
        String white="white";
        String black="black";
        Pawn pawn1 = new Pawn(white);
        //assertThat(pawn1.getColor()).isEqualTo(white);
        pawn1.verifyPawn(white);

        Pawn pawn2 = new Pawn(black);
        //assertThat(pawn2.getColor()).isEqualTo(black);
        pawn2.verifyPawn(black);
    }

}