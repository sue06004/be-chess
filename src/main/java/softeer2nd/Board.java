package softeer2nd;

import java.util.ArrayList;
import pieces.Pawn;
public class Board {

    private ArrayList<String> boardList = new ArrayList<>();
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

    public void initialize(){
        for (int i=0;i<8;i++){
            boardList.add(makeLine(i));
        }
    }

    private String makeLine(int i){
        ArrayList<String> pawnList = new ArrayList<>();

        Pawn pawn;
        if (i==1){
            pawn = new Pawn(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
        }
        else if(i==6){
            pawn = new Pawn();
        }
        else{
            pawn = new Pawn(Pawn.OTHER_COLOR, Pawn.OTHER_REPRESENTATION);
        }

        for (int j=0;j<8;j++) {
            pawnList.add(pawn.getRepresentation());
        }

        return convertString(pawnList);

    }
    private String convertString(ArrayList<String> arraylist){
        StringBuilder stringBuilder = new StringBuilder();
        for(String str : arraylist){
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }
    public String getWhitePawnsResult(){
        return boardList.get(6);
    }
    public String getBlackPawnsResult(){
        return boardList.get(1);
    }
    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for(String str: boardList){
            stringBuilder.append(str);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
