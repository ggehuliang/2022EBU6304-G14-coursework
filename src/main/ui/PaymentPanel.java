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
    private JPanel paymentPanel,feePanel,creditPanel;
    

    public PaymentPanel(MainFrame mainFrame) {
        super(mainFrame);
        this.mainFrame=mainFrame;
        this.setOpaque(false);

        paymentPanel = new JPanel();
        this.add(paymentPanel);
        GridLayout TotalLayout= new GridLayout(4,1);
        paymentPanel.setLayout(TotalLayout);

        back = new JButton("Meal options");
        paymentPanel.add(back);
        

        feePanel = new JPanel();
        feePanel.setLayout(new GridLayout(1,2));
        feePanel.setBorder(BorderFactory.createLoweredBevelBorder());
        label1 = new JLabel("Additional Fee",JLabel.CENTER);
        feePanel.add(label1);
        feeArea = new JTextArea();
        feeArea.setBorder(BorderFactory.createLoweredBevelBorder());
        feeArea.setEditable(false);
        feePanel.add(feeArea);
        paymentPanel.add(feePanel);

        
        creditPanel = new JPanel();
        creditPanel.setLayout(new GridLayout(3,1));
        label2 = new JLabel("Please input your CreditID and Password");
        creditPanel.add(label2);
        cardId = new JTextField();
        cardId.setBorder(BorderFactory.createTitledBorder("CardID"));
        creditPanel.add(cardId);
        cardPassword = new JTextField();
        cardPassword.setBorder(BorderFactory.createTitledBorder("cardPassword"));
        creditPanel.add(cardPassword);
        paymentPanel.add(creditPanel);
        
        go = new JButton("Confirming");
        paymentPanel.add(go);
        


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
