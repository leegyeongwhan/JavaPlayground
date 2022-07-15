package OddEvenGame;

public class GameRule {

    Player player = new Player(1000);
    private int gameMoney = player.getStartMoney();

    public void gameStart(Betting bt) {
        bt.computerBet();
        if (bt.computerStatus.equals(bt.playerStatus)) {
            System.out.println("이겼습니다!");
            gameMoney = win();
        } else {
            System.out.println("졌습니다");
            gameMoney = lose();
        }
    }

    public int calculation() {
        System.out.println("소지금 = " + gameMoney);
        if (gameMoney >= 5000) {
            System.out.println("승리 하셨습니다!");
            System.exit(0);
        } else if (gameMoney <= 0) {
            System.out.println("패배하셨습니다.");
            System.exit(0);
        }
        return gameMoney;
    }

    public void exit() {
        System.exit(0);
    }

    private int lose() {
        gameMoney -= 1000;
        return gameMoney;
    }

    private int win() {
        gameMoney += gameMoney;
        return gameMoney;
    }
}
