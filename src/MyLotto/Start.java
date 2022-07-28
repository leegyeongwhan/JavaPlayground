package MyLotto;

import java.util.Arrays;
import java.util.Random;

public class Start {
    Random random = new Random();
    int[] myNumber = new int[6];
    int[] realNumber = new int[6];

    private void randomSetNumber(int[] realNumber) {
        for (int i = 0; i < realNumber.length; i++) {
            realNumber[i] = random.nextInt(46);
            for (int j = 0; j < i; j++) {
                if (realNumber[j] == realNumber[i]) {
                    i--;
                    break;
                }
            }
        }
    }

    //임의의 특정 담청 번호
    private void setRealNumber() {
        randomSetNumber(realNumber);
    }

    // 랜덤하게 번호를 저장 ,중복을 제거한다 사용자의 번호
    private void setMyNumber() {
        randomSetNumber(myNumber);
    }


    public static void main(String[] args) {
        Start start = new Start();
        start.setMyNumber();
        System.out.println("start = " + Arrays.toString(start.myNumber));
    }
}
