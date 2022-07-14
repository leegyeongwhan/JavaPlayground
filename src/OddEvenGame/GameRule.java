package OddEvenGame;

public class GameRule {

    Player player = new Player(1000);
    int gameMoney = player.getStartMoney();

    public void gameStart(Betting bt) {
        bt.computerBet();
        System.out.println(bt.computerStatus);
        System.out.println(bt.playerStatus);
        System.out.println(gameMoney);
        if (bt.computerStatus.equals(bt.playerStatus)) {
            System.out.println("이겼습니다!");
            win();
        } else {
            System.out.println("졌습니다");
            lose();
        }
    }

    public void calculation() {
        if (gameMoney >= 5000) {
            System.out.println("승리 하셨습니다!");
        }
//        else if (gameMoney <= 0) {
//            System.out.println("패배하셨습니다.");
//        }
    }

    public void exit() {
        System.exit(0);
    }

    private void lose() {
        gameMoney -= gameMoney;
    }

    private void win() {
        gameMoney -= gameMoney;
    }
}
