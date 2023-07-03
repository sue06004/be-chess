package softeer2nd;

public class Pawn {
    private String color;

    Pawn(){

    }

    Pawn(String color){
        this.color = color;
    }


    public Pawn create(){
        return new Pawn();
    }

    public String getColor(){
        return this.color;
    }
}
