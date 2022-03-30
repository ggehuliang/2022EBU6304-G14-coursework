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

import main.MainFrame;
import main.utils.Typings.Panels;

public class PaymentPanel extends BasePanel implements ActionListener {
    private JButton back;
    private JButton go;
    private MainFrame mainFrame;
    private JLabel label1;
    private JTextArea feeArea;
    private JLabel label2;
    private JTextField cardId;
    private JTextField cardPassword;
    private JPanel creditPanel,panel1,panel2,picPanel;
    

    public PaymentPanel(MainFrame mainFrame) {
        super(mainFrame);
        this.mainFrame=mainFrame;
        this.setOpaque(false);
        this.setLayout(null);

        back = new JButton("Meal options");
        back.setBounds(10, 15, 120, 40);
        this.add(back);

        panel1 = new JPanel();
        panel1.setBounds(0, 70, 10000, 5);
        panel1.setBackground(Color.BLUE);
        this.add(panel1);

        panel2 = new JPanel();
        panel2.setBounds(0, 655, 10000, 5);
        panel2.setBackground(Color.blue);
        this.add(panel2);
        
        label1 = new JLabel("YOUR ADDITIONAL FEE:");
        label1.setFont(new java.awt.Font("Serif", 1, 35));
        label1.setBounds(80, 100, 700, 50);
        this.add(label1);

        feeArea = new JTextArea();
        feeArea.setBounds(60, 180, 470, 420);
        feeArea.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        feeArea.setEditable(false);
        this.add(feeArea);
        
        label2 = new JLabel("Please input your CreditID and Password");
        label2.setFont(new java.awt.Font("Dialog", 1, 20));
        label2.setBounds(580, 400, 400,50);
        this.add(label2);
        cardId = new JTextField();
        cardId.setBorder(BorderFactory.createTitledBorder("CardID"));
        cardId.setBounds(630, 460, 300, 35);
        cardId.setActionCommand("ID");
        cardId.addActionListener(this);

        this.add(cardId);
        cardPassword = new JTextField();
        cardPassword.setBorder(BorderFactory.createTitledBorder("CardPassword"));
        cardPassword.setBounds(630, 520, 300, 35);
        this.add(cardPassword);
        

        picPanel = new JPanel();
        picPanel.setBounds(630, 180, 300, 200);
        picPanel.setBackground(Color.green);
        this.add(picPanel);
        
        go = new JButton("Confirming");
        go.setBounds(900, 675, 100, 40);
        this.add(go);
        
        back.addActionListener(this);
        back.setActionCommand("back");
        go.addActionListener(this);
        go.setActionCommand("go");

        

        
    }
    public void onCalled(){
        System.out.println("来到了付款信息页面");
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("go")) {
            //如果确认付款，扫描信用卡
            mainFrame.goPanel(Panels.FEE_PAYMENT, Panels.CONFIRMING);
        }else if (e.getActionCommand().equals("back")) {
            //
            mainFrame.goPanel(Panels.FEE_PAYMENT, Panels.MEAL_PLAN);
        }

        }
    

    
}
