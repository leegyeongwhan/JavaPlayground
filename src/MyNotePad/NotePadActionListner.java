package MyNotePad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotePadActionListner implements ActionListener {
    String cmd;
    Notepad np;

    /// notepad에있는 메뉴 바에있는 멤버들을 받는다
    public NotePadActionListner(Notepad np) {
        this.np = np;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        cmd = e.getActionCommand();
        switch (cmd) {
            case "새파일":
                np.createFile();
                break;
            case "열기":
                np.readFile();
                break;
        }
    }
}
