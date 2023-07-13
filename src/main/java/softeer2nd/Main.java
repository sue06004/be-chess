package softeer2nd;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        Scanner in = new Scanner(System.in);
        String cmd;
        while (true) {
            System.out.printf("명령: ");
            cmd = in.nextLine();
            if (cmd.equals("end")) {
                System.out.println("게임을 종료합니다.");
                break;
            } else if (cmd.equals("start")) {
                System.out.println("게임을 시작합니다.");
                board = new Board();
                board.initialize();
                ChessView.showBoard(board);
            } else if (cmd.startsWith("move")) {
                ChessGame chessGame = ChessGame.createChessGame(board);
                String[] pos = cmd.split(" ");
                if (pos.length != 3) {
                    System.out.println("'move a1 c3' 와 같이 입력해주세요");
                    continue;
                }
                if(!chessGame.move(pos[1], pos[2])){
                    System.out.println("이동할 수 없는 지역입니다.");
                }
                ChessView.showBoard(board);
            } else {
                System.out.println("잘못된 명령을 입력하였습니다.");
            }
        }
    }

}
