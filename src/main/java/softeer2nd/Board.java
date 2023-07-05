package softeer2nd;

import java.util.ArrayList;
import pieces.Piece;
import static utils.StringUtils.*;
public class Board {

    private ArrayList<String> boardList = new ArrayList<>();
    private ArrayList<Piece> board_list = new ArrayList<>(); //미션2

    public int pieceCount(){
        int cnt=0;
        for(String str : boardList){
            for (int i=0;i<8;i++){
                if(str.charAt(i) !='.'){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public void initialize(){
        for (int i=0;i<8;i++){
            boardList.add(makeRow(i));
        }
    }

    private String makeRow(int i){
        ArrayList<String> pieceList = new ArrayList<>();

        if (i==0){
            Piece rook = Piece.createBlackRook();
            Piece knight = Piece.createBlackKnight();
            Piece bishop = Piece.createBlackBishop();
            Piece queen = Piece.createBlackQueen();
            Piece king = Piece.createBlackKing();

            pieceList.add(rook.getRepresentation());
            pieceList.add(knight.getRepresentation());
            pieceList.add(bishop.getRepresentation());
            pieceList.add(queen.getRepresentation());
            pieceList.add(king.getRepresentation());
            pieceList.add(bishop.getRepresentation());
            pieceList.add(knight.getRepresentation());
            pieceList.add(rook.getRepresentation());

        }
        else if (i==1){
            Piece pawn = Piece.createBlackPawn();
            pawnAddToList(pieceList, pawn);
        }
        else if(i==6){
            Piece pawn = Piece.createWhitePawn();
            pawnAddToList(pieceList, pawn);
        }
        else if(i==7){
            Piece rook = Piece.createWhiteRook();
            Piece knight = Piece.createWhiteKnight();
            Piece bishop = Piece.createWhiteBishop();
            Piece queen = Piece.createWhiteQueen();
            Piece king = Piece.createWhiteKing();

            pieceList.add(rook.getRepresentation());
            pieceList.add(knight.getRepresentation());
            pieceList.add(bishop.getRepresentation());
            pieceList.add(queen.getRepresentation());
            pieceList.add(king.getRepresentation());
            pieceList.add(bishop.getRepresentation());
            pieceList.add(knight.getRepresentation());
            pieceList.add(rook.getRepresentation());

        }
        else{
            pieceList.add("........");
        }

        return convertListToString(pieceList,false);

    }
    private void pawnAddToList(ArrayList pawnList, Piece pawn){
        for (int j=0;j<8;j++) {
            pawnList.add(pawn.getRepresentation());
        }
    }
    private String convertListToString(ArrayList<String> arraylist, boolean sep){
        StringBuilder stringBuilder = new StringBuilder();
        for(String str : arraylist){
            if(sep==false)
                stringBuilder.append(str);
            else
                stringBuilder.append(appendNewLine(str));
        }
        return stringBuilder.toString();
    }

    public String showBoard(){
        String boardString = convertListToString(boardList,true);
        return boardString;
    }

    //미션2
    public String getWhitePawnsResult(){
        return boardList.get(6);
    }
    public String getBlackPawnsResult(){
        return boardList.get(1);
    }
    public void add(Piece piece){
        this.board_list.add(piece);
    }
    public Piece findPawn(int idx){
        return this.board_list.get(idx);
    }
}
