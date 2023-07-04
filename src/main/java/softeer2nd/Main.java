package softeer2nd;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String cmd;
        while (true){
            System.out.printf("명령: ");
            cmd = in.next();
            if (cmd.equals("end")){
                System.out.println("게임을 종료합니다.");
                break;
            }
            else if (cmd.equals("start")){
                System.out.println("게임을 시작합니다.");
                Board board = new Board();
                board.initialize();
                System.out.println(board.print());
            }
            else{
                System.out.println("잘못된 명령을 입력하였습니다.");
            }
        }
    }

}
