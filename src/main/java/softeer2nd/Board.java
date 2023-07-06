package softeer2nd;

import java.util.ArrayList;

import pieces.Piece;
import utils.Position;
import utils.Rank;
import static utils.StringUtils.*;

public class Board {

    private ArrayList<Rank> boardList = new ArrayList<>();

    public void initializeEmpty(){
        for (int i=0;i<8;i++){
            Rank rank = new Rank();
            blankRank(rank);
            boardList.add(rank);
        }
    }

    public void initialize(){
        for (int i=0;i<8;i++){
            initRank(i);
        }
    }
    private void initRank(int i){
        Rank rank = new Rank();

        if (i==0){
            initBlackNotPawn(rank);
        }
        else if (i==1){
            initBlackPawn(rank);
        }
        else if(i==6){
            initWhitePawn(rank);
        }
        else if(i==7){
            initWhiteNotPawn(rank);
        }
        else{
            blankRank(rank);
        }

        boardList.add(rank);
    }
    private void initBlackNotPawn(Rank rank){
        Piece rook0 = Piece.createBlackRook();
        Piece rook1 = Piece.createBlackRook();
        Piece knight0 = Piece.createBlackKnight();
        Piece knight1 = Piece.createBlackKnight();
        Piece bishop0 = Piece.createBlackBishop();
        Piece bishop1 = Piece.createBlackBishop();
        Piece queen = Piece.createBlackQueen();
        Piece king = Piece.createBlackKing();

        rank.add(rook0);
        rank.add(knight0);
        rank.add(bishop0);
        rank.add(queen);
        rank.add(king);
        rank.add(bishop1);
        rank.add(knight1);
        rank.add(rook1);
    }
    private void initWhiteNotPawn(Rank rank){
        Piece rook0 = Piece.createWhiteRook();
        Piece rook1 = Piece.createWhiteRook();
        Piece knight0 = Piece.createWhiteKnight();
        Piece knight1 = Piece.createWhiteKnight();
        Piece bishop0 = Piece.createWhiteBishop();
        Piece bishop1 = Piece.createWhiteBishop();
        Piece queen = Piece.createWhiteQueen();
        Piece king = Piece.createWhiteKing();

        rank.add(rook0);
        rank.add(knight0);
        rank.add(bishop0);
        rank.add(queen);
        rank.add(king);
        rank.add(bishop1);
        rank.add(knight1);
        rank.add(rook1);
    }
    private void initBlackPawn(Rank rank){
        for (int j=0;j<8;j++) {
            Piece pawn = Piece.createBlackPawn();
            rank.add(pawn);
        }
    }
    private void initWhitePawn(Rank rank){
        for (int j=0;j<8;j++) {
            Piece pawn = Piece.createWhitePawn();
            rank.add(pawn);
        }
    }
    private void blankRank(Rank rank){
        for (int j=0;j<8;j++) {
            Piece blank = Piece.createBlank();
            rank.add(blank);
        }
    }


    public String showBoard(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Rank rank : boardList){
            stringBuilder.append(appendNewLine(rank.toString()));
        }
        return stringBuilder.toString();
    }

    public int pieceCount(Piece.Color color, Piece.Type type ){
        int cnt=0;
        for(Rank rank : boardList){
            cnt+=rank.cntPiece(color,type);
        }
        return cnt;
    }

    public Piece findPiece(String pos){
        Position position = new Position(pos);

        Rank rank = boardList.get(8-position.getY());
        Piece piece = rank.getRank().get(position.getX());
        return piece;
    }

    public void move(String pos, Piece piece){
        Position position = new Position(pos);

        Rank rank = boardList.get(8-position.getY());
        rank.set(position.getX(),piece);
    }

    public double caculcatePoint(Piece.Color color){
        double point = 0;
        for(int rank=0; rank<8; rank++){
            point += calcPointRow(rank, color);
        }
        return point;
    }
    private double calcPointRow(int rank,Piece.Color color){
        double[] tmp;
        double cntPawn=0;
        double point = 0;

        for(int row=0;row<8;row++){
            Rank pieces = boardList.get(row);
            Piece piece = pieces.get(rank);
            tmp = getPiecePoint(piece, color);

            point += tmp[0];
            cntPawn += tmp[1];
        }
        if (cntPawn>1){
            point-=cntPawn*0.5;
        }
        return point;
    }
    private double[] getPiecePoint(Piece piece, Piece.Color color){
        double cntPawn = 0.0;
        double point = 0.0;
        if(piece.getColor()==color){
            cntPawn += ifPawn(piece);
            point += piece.getType().getDefaultPoint();
        }
        return new double[] {point, cntPawn};
    }
    private double ifPawn(Piece piece){
        if(piece.getType()==Piece.Type.PAWN){
            return 1.0;
        }
        return 0.0;
    }

    public Rank sort(Piece.Color color){
        Rank pieces = new Rank();
        for(Rank rank : boardList){
            sortRank(pieces, rank, color);
        }
        pieces.sort();
        return pieces;
    }
    private void sortRank(Rank pieces, Rank rank, Piece.Color color){
        for(Piece piece : rank.getRank()){
            ifEqualColor(pieces, piece, color);
        }
    }
    private void ifEqualColor(Rank pieces,Piece piece, Piece.Color color){
        if(piece.getColor()==color){
            pieces.add(piece);
        }
    }
}
