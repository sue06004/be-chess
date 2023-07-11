package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pieces.Piece;
public class Rank {

    List<Piece> rank;

    public Rank(){
        this.rank = new ArrayList<Piece>();
    }

    public void add(Piece piece){
        this.rank.add(piece);
    }
    public void set(int idx, Piece piece) {
        this.rank.set(idx,piece);
    }
    public Piece get(int idx){
        return rank.get(idx);
    }
    public List<Piece> getRank(){
        return rank;
    }

    public void sort(){
        Collections.sort(rank);
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Piece p : this.rank){
            pieceAppendSb(sb,p);
        }
        return sb.toString();
    }
    private void pieceAppendSb(StringBuilder sb, Piece piece){
        if(piece.isBlack()){
            sb.append(String.valueOf(piece.getType().getBlackRepresentation()));
        }
        else{
            sb.append(String.valueOf(piece.getType().getWhiteRepresentation()));
        }
    }

    public int cntPiece(Piece.Color color, Piece.Type type){
        int cnt=0;
        for (Piece piece : rank){
            cnt += (piece.getColor()==color && piece.getType()==type) ? 1:0;
        }
        return cnt;
    }


}
