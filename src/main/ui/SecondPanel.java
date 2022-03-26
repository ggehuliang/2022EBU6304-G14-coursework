package main.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import main.MainFrame;
import main.utils.Typings.Panels;

public class SecondPanel extends BasePanel implements ActionListener {
    private JButton back;
    private JButton go;
    private MainFrame mainFrame;

    public SecondPanel(MainFrame mainFrame) {
        super(mainFrame);
        this.mainFrame = mainFrame;
        back = new JButton("second返回");
        go = new JButton("second前进");
        this.setLayout(null);
        this.add(back);

        back.addActionListener(this);
        back.setActionCommand("back");
        go.addActionListener(this);
        go.setActionCommand("go");
        back.setBounds(30, 40, 100, 40);
        this.add(go);
        go.setBounds(230, 40, 100, 40);
    }

    public void onCalled(){
        System.out.println("来到信息填写页");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("go")) {
            JOptionPane.showConfirmDialog(this, "测试点击");

        }
        if (e.getActionCommand().equals("back")) {
            mainFrame.goPanel(Panels.CODE_INPUT, Panels.WELCOME);

            System.out.println("回");
        }
    }
}
