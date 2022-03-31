package main.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.MainFrame;
import main.utils.Typings.Panels;

public class FourthPanel extends BasePanel implements ActionListener {
    private JButton back;
    private JButton go;
    private JPanel p1;
    private JPanel p2;
    private JPanel p3;
    private JPanel p4;
    private JLabel L1;
    private JLabel L2;
    private JLabel L3;
    private JLabel L4;
    private JTextField F1;
    private JTextField F2;
    private MainFrame mainFrame;

    public FourthPanel(MainFrame mainFrame) {
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
        p2.setBackground(Color.BLUE);
        this.add(p2);

        p3 = new JPanel();
        p3.setBounds(30, 355, 450, 270);
        p3.setBackground(Color.YELLOW);
        p3.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        this.add(p3);

        p4 = new JPanel();
        p4.setBounds(520, 100, 450, 525);
        p4.setBackground(Color.pink);
        p4.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        this.add(p4);
        
        L1 = new JLabel("SEAT INFORMATION");
        L1.setFont(new java.awt.Font("Serif", 1, 40));
        L1.setBounds(50, 100, 700, 50);
        this.add(L1);

        L2 = new JLabel("Class:");
        L2.setFont(new java.awt.Font("Dialog", 1, 30));
        L2.setBounds(50, 170, 700, 50);
        this.add(L2);

        L3 = new JLabel("Line  :");
        L3.setFont(new java.awt.Font("Dialog", 1, 30));
        L3.setBounds(50, 240, 700, 50);
        this.add(L3);

        L4 = new JLabel("Addition Seating");
        L4.setFont(new java.awt.Font("Dialog", 1, 35));
        L4.setBounds(50, 300, 700, 50);
        this.add(L4);

        F1 = new JTextField("");
        F1.setText("Jesus");
        F1.setFont(new java.awt.Font("Dialog", 1, 25));
        F1.setBounds(150, 175, 100, 35);
        this.add(F1);

        F2 = new JTextField("");
        F2.setText("God");
        F2.setFont(new java.awt.Font("Dialog", 1, 25));
        F2.setBounds(150, 250, 100, 35);
        this.add(F2);
    }

    public void onCalled(){
        System.out.println("来到选座页");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("go")) {
            mainFrame.goPanel(Panels.SEAT_PLAN, Panels.MEAL_PLAN);

        }
        if (e.getActionCommand().equals("back")) {
            //mainFrame.goPanel(Panels.SEAT_PLAN, Panels.CODE_INPUT);//test
            mainFrame.goPanel(Panels.SEAT_PLAN, Panels.FLIGHT_INFO);

            System.out.println("回");
        }
    }
}