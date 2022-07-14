package OddEvenGame;

import java.util.Random;

public class Betting {
    Random random = new Random();
    Status computerStatus;
    Status playerStatus;

    public void evenBet() {
        System.out.println("!");
        playerStatus = Status.EVEN;
    }

    public void oddBet() {
        playerStatus = Status.ODD;
    }

    public void computerBet() {
        int num = random.nextInt(5);
        if (num % 2 == 0) {
            computerStatus = Status.EVEN;
        } else if (num % 2 == 1) {
            computerStatus = Status.ODD;
        }
    }


}
