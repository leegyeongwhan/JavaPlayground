package OddEvenGame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean controll = true;

        while (controll) {
            System.out.println("메뉴 선택 1.홀수  2.짝수 0. 게임종료");
            int num = Integer.parseInt(br.readLine());
            GameRule gr = new GameRule();
            Betting bt = new Betting();
            switch (num) {
                case 0:
                    gr.exit(); //false 반환
                    break;
                case 1:
                    bt.oddBet();
                    break;
                case 2:
                    bt.evenBet();
                    break;
            }
            gr.gameStart(bt); // 사용가 고른 것과 컴퓨터의 것을 비교
            gr.calculation();
        }
    }

}
