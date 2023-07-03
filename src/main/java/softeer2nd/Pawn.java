package softeer2nd;

//import static org.assertj.core.api.Assertions.*;
public class Pawn {

    private String color;

    Pawn(String color){
        this.color=color;
    }
    public String getColor(){
        return color;
    }

    public boolean verifyPawn(final String color){
        return this.getColor()==color;
    }
}
