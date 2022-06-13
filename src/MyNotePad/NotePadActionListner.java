package MyNotePad;

import javax.swing.*;
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
            case "저장":
                if (np.fileName.equals("")) {
                    int result = np.chooser.showSaveDialog(null);

                    if (result != np.chooser.APPROVE_OPTION) {
                        JOptionPane.showMessageDialog(null, "파일을 선택하지않앗습니다");
                        return;
                    }
                    np.fileName = np.chooser.getSelectedFile().getPath();
                }
                np.saveFile(np.ta.getText());
                break;
            case "다른이름으로저장":
                int ret = np.chooser.showSaveDialog(null);
                if (ret == JFileChooser.APPROVE_OPTION) {
                    np.fileName = np.chooser.getSelectedFile().getPath();
                    np.saveFile(np.ta.getText());
                    break;

                }
            case "종료":
                break;
        }
    }
}
