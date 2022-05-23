package main.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.MainFrame;
import main.utils.Typings.Panels;

public class FirstPanel extends BasePanel implements ActionListener {
    private MainFrame mainFrame;
    private JPanel jp1, jp2, P1, P2;
    private JButton jb1, jb2;
    private JLabel title;
    // test
    // test

    public FirstPanel(MainFrame mainFrame) {
        super(mainFrame);
        this.mainFrame = mainFrame;

        title = new JLabel("Welcome to flight check-in kiosk!", JLabel.CENTER);
        title.setFont(new Font("", Font.BOLD, 50));
        // Border etchedBorder;
        // etchedBorder = BorderFactory.createEtchedBorder();
        jp1 = new JPanel();
        jp2 = new JPanel();
        jb1 = new JButton("Check In!");
        jb1.setFont(new Font("", Font.BOLD, 25));
        jb1.addActionListener(this);
        jb1.setActionCommand("Check In!");
        jb2 = new JButton("Admin login");

        jb2.addActionListener(this);
        jb2.setActionCommand("Admin login");

        jp1.add(title, BorderLayout.CENTER);
        jp2.add(jb1);
        jp1.setBounds(0, 80, 1024, 200);
        jb1.setBounds(390, 400, 240, 50);
        jb2.setBounds(900, 20, 100, 20);
        // jp1.setBorder(BorderFactory.createTitledBorder(etchedBorder));
        // jb1.setBorder(BorderFactory.createTitledBorder(etchedBorder));
        // this.setSize(1024,768);
        this.setLayout(null);
        this.add(jp1);
        this.add(jb1);
        this.add(jb2);
        P1 = new JPanel();
        P1.setBounds(0, 70, 10000, 5);
        P1.setBackground(new Color(100, 100, 200));
        this.add(P1);

        P2 = new JPanel();
        P2.setBounds(0, 655, 10000, 5);
        P2.setBackground(new Color(100, 100, 200));
        this.add(P2);

    }

    public void onCalled() {
        System.out.println("来到了初始界面");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Check In!")) {
            // System.out.print("lallala");
            mainFrame.goPanel(Panels.WELCOME, Panels.CODE_INPUT);
        } else if (e.getActionCommand().equals("Admin login")) {
            mainFrame.goPanel(Panels.WELCOME, Panels.ADMIN);
        }

    }
}
