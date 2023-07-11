package softeer2nd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pieces.*;
import utils.Position;

import static org.junit.jupiter.api.Assertions.*;
import static pieces.Piece.*;

class ChessGameTest {

    Board board;
    ChessGame chessGame;

    @BeforeEach
    public void setup() {
        board = new Board();
        board.initialize();
        chessGame = ChessGame.createChessGame(board);
    }


    @Test
    @DisplayName("체스판 위의 말의 점수 계산")
    void caculcatePoint() {

        assertEquals(38.0, chessGame.caculcatePoint(Color.BLACK), 0.01);
        assertEquals(38.0, chessGame.caculcatePoint(Color.WHITE), 0.01);

    }

    @Test
    @DisplayName("킹 이동 테스트")
    public void moveKing() throws Exception {
        board = new Board();
        board.initializeEmpty();
        chessGame = ChessGame.createChessGame(board);

        board.put("b6", Pawn.createBlack(Position.createPosition("b6")));
        board.put("e6", Queen.createBlack(Position.createPosition("e6")));
        board.put("b8", King.createBlack(Position.createPosition("b8")));
        board.put("c8", Rook.createBlack(Position.createPosition("c8")));
        board.put("e3", Rook.createBlack(Position.createPosition("e3")));

        board.put("f3", Pawn.createWhite(Position.createPosition("f3")));
        board.put("e1", Rook.createWhite(Position.createPosition("e1")));
        board.put("f1", King.createWhite(Position.createPosition("f1")));
        board.put("g2", Pawn.createWhite(Position.createPosition("g2")));

        String sourcePosition = "f1";
        String targetPosition1 = "f2";
        String targetPosition2 = "g1";
        String targetPosition3 = "f3";
        String targetPosition4 = "g0";
        String targetPosition5 = "g2";
        String targetPosition6 = "f2";
        String targetPosition7 = "e3";

        assertEquals(true, chessGame.move(sourcePosition, targetPosition1)); //위로
        assertEquals(true, chessGame.move(targetPosition1, targetPosition2)); // 오른쪽 아래로
        assertEquals(false, chessGame.move(targetPosition2, targetPosition3)); // 왼위위, 킹이 갈수 없는 경로
        assertEquals(false, chessGame.move(targetPosition2, targetPosition4)); // out of boundary
        assertEquals(false, chessGame.move(targetPosition2, targetPosition5)); // 도착지에 같은색
        assertEquals(true, chessGame.move(targetPosition2, targetPosition6)); // 왼위
        assertEquals(true, chessGame.move(targetPosition6, targetPosition7)); // 도착지에 다른색
        assertEquals(false, chessGame.move(targetPosition7, targetPosition7)); //같은 위치
    }

    @Test
    @DisplayName("퀸 이동 테스트")
    public void queenMove() {
        board = new Board();
        board.initializeEmpty();
        chessGame = ChessGame.createChessGame(board);

        board.put("b6", Pawn.createBlack(Position.createPosition("b6")));
        board.put("e6", Queen.createBlack(Position.createPosition("e6")));
        board.put("b8", King.createBlack(Position.createPosition("b8")));
        board.put("c8", Rook.createBlack(Position.createPosition("c8")));
        board.put("e3", Rook.createBlack(Position.createPosition("e3")));

        board.put("f2", Pawn.createWhite(Position.createPosition("f2")));
        board.put("f3", Pawn.createWhite(Position.createPosition("f3")));
        board.put("e1", Rook.createWhite(Position.createPosition("e1")));
        board.put("f1", King.createWhite(Position.createPosition("f1")));
        board.put("g2", Pawn.createWhite(Position.createPosition("g2")));

        String sourcePosition = "e6";
        String targetPosition1 = "e8";
        String targetPosition2 = "a8";
        String targetPosition3 = "c6";
        String targetPosition4 = "c8";
        String targetPosition5 = "f3";
        String targetPosition6 = "e3";
        String targetPosition7 = "g2";
        String targetPosition8 = "g0";
        String targetPosition9 = "e1";

        assertEquals(true, chessGame.move(sourcePosition, targetPosition1)); // 위위
        assertEquals(false, chessGame.move(targetPosition1, targetPosition2)); // 뛰어넘기
        assertEquals(true, chessGame.move(targetPosition1, targetPosition3)); // 왼아래 대각선
        assertEquals(false, chessGame.move(targetPosition3, targetPosition4)); // 도차지에 같은색
        assertEquals(true, chessGame.move(targetPosition3, targetPosition5)); // 오른쪽 아래
        assertEquals(false, chessGame.move(targetPosition5, targetPosition6)); // 도착지에 같은색
        assertEquals(true, chessGame.move(targetPosition5, targetPosition7)); // 오른쪽 대각선 아래에 다른색
        assertEquals(false, chessGame.move(targetPosition7, targetPosition8)); // out of boundary
        assertEquals(false, chessGame.move(targetPosition7, targetPosition9)); // 못가는 방향
        assertEquals(false, chessGame.move(targetPosition7, targetPosition7)); //같은 위치
    }

    @Test
    @DisplayName("Rook 테스트")
    void rook() {
        board = new Board();
        board.initializeEmpty();
        chessGame = ChessGame.createChessGame(board);

        board.put("b6", Pawn.createBlack(Position.createPosition("b6")));
        board.put("e6", Queen.createBlack(Position.createPosition("e6")));
        board.put("b8", King.createBlack(Position.createPosition("b8")));
        board.put("c8", Rook.createBlack(Position.createPosition("c8")));
        board.put("e3", Rook.createBlack(Position.createPosition("e3")));

        board.put("f2", Pawn.createWhite(Position.createPosition("f2")));
        board.put("f3", Pawn.createWhite(Position.createPosition("f3")));
        board.put("e1", Rook.createWhite(Position.createPosition("e1")));
        board.put("f1", King.createWhite(Position.createPosition("f1")));
        board.put("g2", Pawn.createWhite(Position.createPosition("g2")));

        String sourcePosition = "c8";
        String targetPosition1 = "e8";
        String targetPosition2 = "c7"; // 퀸이 못가는 방향
        String targetPosition3 = "e6"; // 도착지에 같은 색 피스
        String targetPosition4 = "e5"; // 건너뛰기
        String targetPosition5 = "e9"; // out Boundary
        String targetPosition6 = "f8"; //
        String targetPosition7 = "f3"; // 도착지에 다른 색 피스

        assertEquals(true, chessGame.move(sourcePosition, targetPosition1));
        assertEquals(false, chessGame.move(targetPosition1, targetPosition2));
        assertEquals(false, chessGame.move(targetPosition1, targetPosition3));
        assertEquals(false, chessGame.move(targetPosition1, targetPosition4));
        assertEquals(false, chessGame.move(targetPosition1, targetPosition5));
        assertEquals(true, chessGame.move(targetPosition1, targetPosition6));
        assertEquals(true, chessGame.move(targetPosition6, targetPosition7));
        assertEquals(false, chessGame.move(targetPosition7, targetPosition7)); //같은 위치
    }

    @Test
    @DisplayName("Bishop 테스트")
    void bishop() {
        board = new Board();
        board.initializeEmpty();
        chessGame = ChessGame.createChessGame(board);

        board.put("b6", Pawn.createBlack(Position.createPosition("b6")));
        board.put("e6", Queen.createBlack(Position.createPosition("e6")));
        board.put("b8", King.createBlack(Position.createPosition("b8")));
        board.put("c8", Rook.createBlack(Position.createPosition("c8")));
        board.put("e3", Rook.createBlack(Position.createPosition("e3")));

        board.put("f2", Pawn.createWhite(Position.createPosition("f2")));
        board.put("f3", Pawn.createWhite(Position.createPosition("f3")));
        board.put("e1", Bishop.createWhite(Position.createPosition("e1")));
        board.put("f1", King.createWhite(Position.createPosition("f1")));
        board.put("g2", Pawn.createWhite(Position.createPosition("g2")));

        String sourcePosition = "e1";
        String targetPosition1 = "f2"; // 도착지에 같은 색
        String targetPosition2 = "c3";
        String targetPosition3 = "c5"; // 못가는 방향
        String targetPosition4 = "f0"; // out Boundary
        String targetPosition5 = "e5";
        String targetPosition6 = "b8"; // 도착지에 다른 색
        String targetPosition7 = "a7";
        String targetPosition8 = "c5"; // 건너 뛰기

        assertEquals(false, chessGame.move(sourcePosition, targetPosition1));
        assertEquals(true, chessGame.move(sourcePosition, targetPosition2));
        assertEquals(false, chessGame.move(targetPosition2, targetPosition3));
        assertEquals(false, chessGame.move(targetPosition2, targetPosition4));
        assertEquals(true, chessGame.move(targetPosition2, targetPosition5));
        assertEquals(true, chessGame.move(targetPosition5, targetPosition6));
        assertEquals(true, chessGame.move(targetPosition6, targetPosition7));
        assertEquals(false, chessGame.move(targetPosition7, targetPosition8));
        assertEquals(false, chessGame.move(targetPosition7, targetPosition7)); //같은 위치
    }

    @Test
    @DisplayName("Knight 테스트")
    void knight() {
        board = new Board();
        board.initializeEmpty();
        chessGame = ChessGame.createChessGame(board);

        board.put("b6", Pawn.createBlack(Position.createPosition("b6")));
        board.put("e6", Queen.createBlack(Position.createPosition("e6")));
        board.put("b8", King.createBlack(Position.createPosition("b8")));
        board.put("c8", Rook.createBlack(Position.createPosition("c8")));
        board.put("e3", Rook.createBlack(Position.createPosition("e3")));
        board.put("d5", Knight.createBlack(Position.createPosition("d5")));

        board.put("f2", Pawn.createWhite(Position.createPosition("f2")));
        board.put("f3", Pawn.createWhite(Position.createPosition("f3")));
        board.put("e1", Bishop.createWhite(Position.createPosition("e1")));
        board.put("f1", King.createWhite(Position.createPosition("f1")));
        board.put("g2", Pawn.createWhite(Position.createPosition("g2")));

        String sourcePosition = "d5";
        String targetPosition1 = "b6"; // 도착지에 같은 색
        String targetPosition2 = "f4";
        String targetPosition3 = "g2"; // 도착지에 다른 색
        String targetPosition4 = "i3"; // out Boundary
        String targetPosition5 = "a2"; // 못가는 방향

        assertEquals(false, chessGame.move(sourcePosition, targetPosition1));
        assertEquals(true, chessGame.move(sourcePosition, targetPosition2));
        assertEquals(true, chessGame.move(targetPosition2, targetPosition3));
        assertEquals(false, chessGame.move(targetPosition3, targetPosition4));
        assertEquals(false, chessGame.move(targetPosition3, targetPosition5));
        assertEquals(false, chessGame.move(targetPosition3, targetPosition3)); //같은 위치
    }

    @Test
    @DisplayName("Pawn 테스트")
    void Pawn() {
        board = new Board();
        board.initializeEmpty();
        chessGame = ChessGame.createChessGame(board);

        board.put("b6", Pawn.createBlack(Position.createPosition("b6")));
        board.put("e6", Queen.createBlack(Position.createPosition("e6")));
        board.put("b8", King.createBlack(Position.createPosition("b8")));
        board.put("c8", Rook.createBlack(Position.createPosition("c8")));
        board.put("e4", Rook.createBlack(Position.createPosition("e4")));
        board.put("d5", Knight.createBlack(Position.createPosition("d5")));

        board.put("f2", Pawn.createWhite(Position.createPosition("f2")));
        board.put("a8", Pawn.createWhite(Position.createPosition("a8")));
        board.put("g3", Pawn.createWhite(Position.createPosition("g3")));
        board.put("e1", Bishop.createWhite(Position.createPosition("e1")));
        board.put("f1", King.createWhite(Position.createPosition("f1")));
        board.put("g2", Pawn.createWhite(Position.createPosition("g2")));

        String sourcePosition1 = "f2";
        String sourcePosition2 = "g2";
        String sourcePosition3 = "a8";

        String targetPosition1 = "g3"; // 바로 앞에 피스 존재
        String targetPosition2 = "f3";
        String targetPosition3 = "e4"; // 대각선에 다른 색
        String targetPosition4 = "e2"; // 못가는 방향
        String targetPosition5 = "a9"; //outbound
        String targetPosition6 = "c5"; // 대각선에 아무것도 없음


        assertEquals(false, chessGame.move(sourcePosition2, targetPosition1));
        assertEquals(true, chessGame.move(sourcePosition1, targetPosition2));
        assertEquals(true, chessGame.move(targetPosition2, targetPosition3));
        assertEquals(false, chessGame.move(targetPosition3, targetPosition4));
        assertEquals(false, chessGame.move(sourcePosition3, targetPosition5));
        assertEquals(false, chessGame.move(targetPosition3, targetPosition3)); //같은 위치
        assertEquals(false, chessGame.move(targetPosition3, targetPosition6));

    }
}