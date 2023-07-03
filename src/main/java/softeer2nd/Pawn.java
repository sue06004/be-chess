package softeer2nd;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class Pawn {
    private String color;

    Pawn(){
    }

    Pawn(final String color){
        this.color = color;
    }


    public Pawn create(){
        return new Pawn();
    }

    public String getColor(){
        return this.color;
    }

    public Boolean verifyPawn(final String color){
        if(this.color.equals(color))
            return TRUE;
        return FALSE;
    }
}
