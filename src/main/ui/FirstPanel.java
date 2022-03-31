package main.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import main.MainFrame;
import main.utils.Typings.Panels;

public class FirstPanel extends BasePanel implements ActionListener{
    private JButton back;
    private JButton go;
    private MainFrame mainFrame;

    public FirstPanel(MainFrame mainFrame) {
        super(mainFrame);
        this.mainFrame=mainFrame;
        back = new JButton("返 回");
        go = new JButton("前进");
        this.setLayout(null);
        this.add(back);
        this.setOpaque(false); 
        back.addActionListener(this);
        back.setActionCommand("back");
        go.addActionListener(this);
        go.setActionCommand("go");
        back.setBounds(30, 40,80, 40);
        this.add(go);
        go.setBounds(230, 40, 80, 40);
    }

    public void onCalled(){
        System.out.println("来到了初始界面");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("go")) {
            mainFrame.goPanel(Panels.WELCOME, Panels.CODE_INPUT);
        }else if (e.getActionCommand().equals("back")) {

        }

    }
}
