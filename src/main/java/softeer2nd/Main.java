package softeer2nd;

import pieces.Piece;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        ChessGame chessGame = null;
        Scanner in = new Scanner(System.in);

        String cmd;
        boolean started = false;

        while (true) {
            try {
                System.out.printf("명령: ");
                cmd = in.nextLine();
                if (cmd.equals("start") && !started) {
                    System.out.println("게임을 시작합니다.");
                    board.initialize();
                    ChessView.showBoard(board);
                    chessGame = ChessGame.createChessGame(board);
                    started = true;
                } else if (cmd.equals("start") && started) {
                    System.out.println("이미 게임이 시작되었습니다.");
                } else if (cmd.startsWith("move")) {
                    String[] pos = cmd.split(" ");
                    if (pos.length != 3) {
                        System.out.println("'move a1 c3' 와 같이 입력해주세요");
                        continue;
                    }
                    if (!chessGame.move(pos[1], pos[2])) {
                        System.out.println("이동할 수 없는 지역입니다.");
                    }
                    ChessView.showBoard(board);
                } else if (cmd.equals("end")) {
                    System.out.println("게임을 종료합니다.");
                    break;
                } else {
                    System.out.println("잘못된 명령을 입력하였습니다.");
                }
            } catch(RuntimeException e){
                e.printStackTrace();
            }
        }
    }

}
