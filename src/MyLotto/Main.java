package MyLotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        System.out.println("최대 500만 게임 까지 가능");
        int num = Integer.parseInt(br.readLine());

        while ((input = br.readLine()) != null) {
            //숫자 6개를 입력
            if (input == null) {
                break;
            }
            Start start = new Start();
            start.initGame(num);
        }
    }
}
