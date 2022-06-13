package MyNotePad;

import javax.swing.*;
import java.awt.*;
import java.io.*;


import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class Notepad extends JFrame {

    public JTextArea ta = new JTextArea();
    JFileChooser chooser = new JFileChooser();
    JMenuBar mb = new JMenuBar();
    String fileName = "";

    Notepad() {

        this.setTitle("Notepad");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // 2. 메뉴생성
        String[] menu = {"파일"};
        JMenu[] mfile = new JMenu[5];
        for (int i = 0; i < menu.length; i++) {
            mfile[i] = new JMenu(menu[i]);
            mb.add(mfile[i]);
        }

        String[] ScrItem = {"새파일", "열기", "저장", "다른이름으로저장", "종료"};
        JMenuItem[] menuItems = new JMenuItem[5];
        for (int i = 0; i < ScrItem.length; i++) {
            menuItems[i] = new JMenuItem(ScrItem[i]);
            // 1. 이벤트 소스: JMenuItem
            // 4. 메뉴바 설정

            NotePadActionListner npl = new NotePadActionListner(this);
            menuItems[i].addActionListener(npl);
            this.setJMenuBar(mb);
            mfile[0].add(menuItems[i]);
        }

        // 컴포넌트 추가
        this.add(ta);
        this.setVisible(true);
    }


    public void createFile() {
        ta.setText("");
    }

    public void readFile() {
        int ret = chooser.showOpenDialog(null);
        if (ret != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, "파일을 선택하지않았습니다");
            return;
        } else {
            File file = chooser.getSelectedFile();
            BufferedReader br;
            try {
                br = new BufferedReader(new FileReader(file));
                String str;
                ta.setText("");
                while ((str = br.readLine()) != null) {
                    ta.append(str + "\r\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fileName = chooser.getSelectedFile().toString();
        setTitle(chooser.getSelectedFile().getName());
    }

    //파일저장
    public void saveFile(String str) {
        BufferedWriter out = null;
        File file = new File(fileName);
        try {
            out = new BufferedWriter(new FileWriter(fileName));
            out.write(str);
            this.setTitle(file.getName());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Notepad();
    }


}