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
    private JPanel P1,P2,P3,P4;
    private JPanel P5,P6,P7,P8,P9,P10;
    private JLabel PL1,PL2,PL3,PL4,PLL;
    private JLabel L1,L2,L3;
    private JCheckBox C1,C2,C3,C4,C5,C6;

    private MainFrame mainFrame;

    public FifthPanel(MainFrame mainFrame) {
        super(mainFrame);
        this.mainFrame = mainFrame;
        back = new JButton("back");
        go = new JButton("next");
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

        P1 = new JPanel();
        P1.setBounds(0, 70, 10000, 5);
        P1.setBackground(new Color(100,100,200));
        this.add(P1);

        P2 = new JPanel();
        P2.setBounds(0, 655, 10000, 5);
        P2.setBackground(new Color(100,100,200));
        this.add(P2);

        P3 = new JPanel();
        P3.setBounds(30, 355, 450, 270);
        P3.setBackground(new Color(16,28,44));
        P3.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        P3.setOpaque(false);
        this.add(P3);

        P4 = new JPanel();
        P4.setBounds(520, 100, 450, 525);
        P4.setBackground(new Color(16,28,44));
        P4.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        this.add(P4);

//----------------------------------------------------------------------------------------------
        P9 = new JPanel();
        P9.setBounds(203, 716, 350, 4);
        P9.setBackground(Color.pink);
        
        this.add(P9);

        P10 = new JPanel();
        P10.setBounds(203, 716, 567, 4);
        P10.setBackground(Color.gray);
        
        this.add(P10);

        P5 = new JPanel();
        P5.setBounds(200, 670, 150, 50);
        P5.setBackground(Color.pink);
        P5.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        PL1 = new JLabel("√ Step 01");
        PL1.setFont(new java.awt.Font("Dialog", 1, 20));
        PL1.setForeground(Color.white);
        P5.add(PL1);
        this.add(P5);

        P6 = new JPanel();
        P6.setBounds(340, 670, 150, 50);
        P6.setBackground(Color.pink);
        P6.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        PL2 = new JLabel("√ Step 02");
        PL2.setFont(new java.awt.Font("Dialog", 1, 20));
        PL2.setForeground(Color.white);
        P6.add(PL2);
        this.add(P6);

        P7 = new JPanel();
        P7.setBounds(480, 670, 150, 50);
        P7.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        PL3 = new JLabel("Step 03");
        PL3.setBounds(510, 672, 450, 25);
        PL3.setFont(new java.awt.Font("Dialog", 1, 16));
        PL3.setForeground(Color.black);
        this.add(PL3);

        PLL = new JLabel("Make a meal plan");
        PLL.setBounds(510, 693, 450, 25);
        PLL.setFont(new java.awt.Font("Dialog", 0, 13));
        PLL.setForeground(Color.black);
        this.add(PLL);
        this.add(P7);

        P8 = new JPanel();
        P8.setBounds(620, 670, 150, 50);
        P8.setBorder(BorderFactory.createLoweredBevelBorder());
        PL4 = new JLabel("Step 04");
        PL4.setFont(new java.awt.Font("Dialog", 0, 18));
        PL4.setForeground(Color.gray);;
        P8.add(PL4);
        this.add(P8);

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

        C3 = new JCheckBox("fish");
        C3.setFont(new java.awt.Font("Serif", 1, 25));
        C3.setBounds(350, 230, 150, 30);
        this.add(C3);

        C4 = new JCheckBox("Yami fish set meal");
        C4.setFont(new java.awt.Font("Serif", 1, 25));
        C4.setBounds(50, 370, 300, 30);
        this.add(C4);

        C5 = new JCheckBox("Holy fish set meal");
        C5.setFont(new java.awt.Font("Serif", 1, 25));
        C5.setBounds(50, 410, 300, 30);
        this.add(C5);

        C6 = new JCheckBox("Ass hole set meal");
        C6.setFont(new java.awt.Font("Serif", 1, 25));
        C6.setBounds(50, 450, 300, 30);
        this.add(C6);
//----------------------------------------------------------------------------------------------

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