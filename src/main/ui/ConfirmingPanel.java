package main.ui;
import java.awt.*;
import javax.swing.*;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import main.MainFrame;
import main.utils.Typings.Panels;

public class ConfirmingPanel extends BasePanel implements ActionListener {
    private JButton go;
    private MainFrame mainFrame;
    private JLabel label1;
    private JTextArea inforArea;
    private JLabel label2;
    private JPanel panel1,panel2,picPanel;

    public ConfirmingPanel(MainFrame mainFrame) {
        super(mainFrame);
        this.mainFrame=mainFrame;
        this.setOpaque(false);
        this.setLayout(null);

        panel1 = new JPanel();
        panel1.setBounds(0, 70, 10000, 5);
        panel1.setBackground(Color.BLUE);
        this.add(panel1);

        panel2 = new JPanel();
        panel2.setBounds(0, 655, 10000, 5);
        panel2.setBackground(Color.BLUE);
        this.add(panel2);

        label1 = new JLabel("Your Check_In Information");
        label1.setFont(new java.awt.Font("Serif", 1, 35));
        label1.setBounds(80, 100, 700, 50);
        this.add(label1);

        inforArea = new JTextArea();
        inforArea.setEditable(false); 
        inforArea.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        inforArea.setBounds(60, 180, 470, 420);
        this.add(inforArea);

        label2 = new JLabel("Please Scan your ID to confirm!!!");
        label2.setFont(new java.awt.Font("Dialog", 1, 28));
        label2.setBounds(560, 350, 450,50);
        this.add(label2);

        picPanel = new JPanel();
        picPanel.setBounds(600, 400, 350, 200);
        picPanel.setBackground(Color.green);
        this.add(picPanel);

        go = new JButton("Finished!");
        go.setBounds(900, 675, 100, 40);
        this.add(go);
        go.addActionListener(this);
        go.setActionCommand("go");
    }

        public void onCalled(){
            System.out.println("来到了值机信息页面");
        }
    
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("go")) {
                mainFrame.goPanel(Panels.CONFIRMING,Panels.FINISHED);
            }
        }
    }
            
