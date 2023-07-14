package softeer2nd;

import java.util.Scanner;

public class Main {

    private static final String START = "start";
    private static final String MOVE = "move";
    private static final String END = "end";

    public static void main(String[] args) {
        Board board = new Board();
        ChessGame chessGame = null;
        ChessView chessView = null;

        Scanner in = new Scanner(System.in);
        String cmd;
        boolean started = false;

        while (true) {
            try {
                System.out.printf("명령: ");
                cmd = in.nextLine();
                if (cmd.equals(START) && !started) {
                    System.out.println("게임을 시작합니다.");
                    board.initialize();
                    chessGame = ChessGame.createChessGame(board);
                    chessView = ChessView.createChessView(board);
                    chessView.showBoard();
                    started = true;
                } else if (cmd.equals(START) && started) {
                    System.out.println("이미 게임이 시작되었습니다.");
                } else if (cmd.startsWith(MOVE)) {
                    if (!started){
                        System.out.println("게임을 먼저 시작해 주세요");
                        continue;
                    }
                    String[] pos = cmd.split(" ");
                    if (pos.length != 3) {
                        System.out.println("'move a1 c3' 와 같이 입력해주세요");
                        continue;
                    }
                    chessGame.move(pos[1], pos[2]);
                    chessView.showBoard();
                } else if (cmd.equals(END)) {
                    System.out.println("게임을 종료합니다.");
                    break;
                } else {
                    System.out.println("잘못된 명령을 입력하였습니다.");
                }
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
