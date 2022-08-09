package MyLotto;

import java.util.Random;

public class Start {
    Random random = new Random();
    static int[] myNumber = new int[6];
    static int[] realNumber = new int[6];
    static int[] resultArray = new int[5];

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

    public void initGame(int num) {
        setRealNumber();
        for (int i = 0; i < num; i++) {
            setMyNumber();
            checkNumber();
        }
        //    System.out.println("start = " + Arrays.toString(start.myNumber));
        //    System.out.println("realNumber = " + Arrays.toString(start.realNumber));
        for (int i : resultArray) {
            System.out.println(i);
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

    //6 개 1등 5개 2등

    //담청 확인 임의 담청배열과 내 배열과 비교 즉 두배열을 비교
    private static int checkNumber() {
        int checkCnt = 0;
        //1등 배열
        for (int i = 0; i < realNumber.length; i++) {
            for (int j = 0; j < myNumber.length; j++) {
                if (realNumber[i] == myNumber[j]) {
                    checkCnt++;
                }
            }
        }
        return getString(checkCnt);
    }

    private static int getString(int checkCnt) {
        switch (checkCnt) {
            case 6:
                return resultArray[4] += 1;
            case 5:
                return resultArray[3] += 1;
            case 4:
                return resultArray[2] += 1;
            case 3:
                return resultArray[1] += 1;
            default:
                return resultArray[0] += 1;
        }
    }


    //당첨 회차 생성

}
