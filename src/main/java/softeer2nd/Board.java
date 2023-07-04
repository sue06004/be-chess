package softeer2nd;

import java.util.ArrayList;
import pieces.Pawn;
public class Board {

    private ArrayList<Pawn> board_list = new ArrayList<>();

    public void add(Pawn pawn){
        this.board_list.add(pawn);
    }

    public Pawn findPawn(int idx){
        return this.board_list.get(idx);
    }

    public int size(){
        return this.board_list.size();
    }
}
