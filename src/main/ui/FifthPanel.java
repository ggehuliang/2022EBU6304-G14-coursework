package main.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;


import main.MainFrame;
import main.utils.Typings.Panels;

public class FifthPanel extends BasePanel implements ActionListener {
    private JButton back;
    private JButton go;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    private JLabel L1;
    private JLabel L2;
    private JLabel L3;
    private JCheckBox C1;
    private JCheckBox C2;
    private JCheckBox C3;
    private JCheckBox C4;
    private JCheckBox C5;
    private JCheckBox C6;

    private MainFrame mainFrame;

    public FifthPanel(MainFrame mainFrame) {
        super(mainFrame);
        this.mainFrame = mainFrame;
        back = new JButton("滚回去");
        go = new JButton("向前爬");
        this.setLayout(null);
        this.add(back);
        this.setOpaque(false); 
        back.addActionListener(this);
        back.setActionCommand("back");
        go.addActionListener(this);
        go.setActionCommand("go");
        back.setBounds(10, 15, 100, 40);
        this.add(go);
        go.setBounds(900, 675, 100, 40);

        p1 = new JPanel();
        p1.setBounds(0, 70, 10000, 5);
        p1.setBackground(Color.BLUE);
        this.add(p1);

        p2 = new JPanel();
        p2.setBounds(0, 655, 10000, 5);
        p2.setBackground(Color.blue);
        this.add(p2);

        p3 = new JPanel();
        p3.setBounds(30, 355, 450, 270);
        p3.setBackground(Color.blue);
        p3.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        p3.setOpaque(false);
        this.add(p3);

        p4 = new JPanel();
        p4.setBounds(520, 100, 450, 525);
        p4.setBackground(Color.green);
        p4.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        this.add(p4);


        L1 = new JLabel("YOUR MEAL PLAN:");
        L1.setFont(new java.awt.Font("Serif", 1, 40));
        L1.setBounds(50, 100, 700, 50);
        this.add(L1);

        L2 = new JLabel("Select your prefer:");
        L2.setFont(new java.awt.Font("Dialog", 1, 35));
        L2.setBounds(50, 180, 700, 50);
        this.add(L2);

        L3 = new JLabel("Addition Plan");
        L3.setFont(new java.awt.Font("Dialog", 1, 35));
        L3.setBounds(50, 300, 700, 50);
        this.add(L3);

        C1 = new JCheckBox("Standard");
        C1.setFont(new java.awt.Font("Serif", 1, 25));
        C1.setBounds(50, 230, 150, 30);
        this.add(C1);

        C2 = new JCheckBox("Vegetarian");
        C2.setFont(new java.awt.Font("Serif", 1, 25));
        C2.setBounds(200, 230, 150, 30);
        this.add(C2);

        C3 = new JCheckBox("Shit");
        C3.setFont(new java.awt.Font("Serif", 1, 25));
        C3.setBounds(350, 230, 150, 30);
        this.add(C3);

        C4 = new JCheckBox("Yami Shit set meal");
        C4.setFont(new java.awt.Font("Serif", 1, 25));
        C4.setBounds(50, 370, 300, 30);
        this.add(C4);

        C5 = new JCheckBox("Holy Shit set meal");
        C5.setFont(new java.awt.Font("Serif", 1, 25));
        C5.setBounds(50, 410, 300, 30);
        this.add(C5);

        C6 = new JCheckBox("Ass hole set meal");
        C6.setFont(new java.awt.Font("Serif", 1, 25));
        C6.setBounds(50, 450, 300, 30);
        this.add(C6);


    }

    public void onCalled(){
        System.out.println("来到选餐页");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("go")) {
            //mainFrame.goPanel(Panels.MEAL_PLAN, Panels.WELCOME);//test
            mainFrame.goPanel(Panels.MEAL_PLAN, Panels.FEE_PAYMENT);

        }
        if (e.getActionCommand().equals("back")) {
            mainFrame.goPanel(Panels.MEAL_PLAN, Panels.SEAT_PLAN);

            System.out.println("回");
        }
    }
}