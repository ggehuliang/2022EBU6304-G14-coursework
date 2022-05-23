package main.ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import main.MainFrame;
import main.entity.CheckinInfoStruct;
import main.entity.ExtraService;
import main.entity.MealPlanStruct;
import main.entity.SeatPlanStruct;
import main.utils.Resources;
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
    private JPanel panel1, panel2, picPanel;
    private JPanel P5, P6, P7, P8, P9, P10;
    private JLabel PL1, PL2, PL3, PL4, PLL;
    private String card, password;
    private CheckinInfoStruct checkinInfo;

    public PaymentPanel(MainFrame mainFrame) {
        super(mainFrame);
        this.mainFrame = mainFrame;
        this.setOpaque(false);
        this.setLayout(null);

        back = new JButton("Meal options");
        back.setBounds(10, 15, 120, 40);
        this.add(back);

        panel1 = new JPanel();
        panel1.setBounds(0, 70, 10000, 5);
        panel1.setBackground(new Color(100, 100, 200));
        this.add(panel1);

        panel2 = new JPanel();
        panel2.setBounds(0, 655, 10000, 5);
        panel2.setBackground(new Color(100, 100, 200));
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
        label2.setBounds(580, 400, 400, 50);
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
        JLabel jl3 = new JLabel(new ImageIcon(Resources.getImgByName("pay.png")));
        picPanel.add(jl3);
        // jl3.setBorder(BorderFactory.createLineBorder(Color.WHITE, 1, true));
        jl3.setBounds(630, 180, 300, 220);
        // picPanel.setBackground(Color.green);
        this.add(picPanel);

        go = new JButton("Confirming");
        go.setBounds(900, 675, 100, 40);
        this.add(go);

        back.addActionListener(this);
        back.setActionCommand("back");
        go.addActionListener(this);
        go.setActionCommand("go");
        // ----------------------------------------------------------------------------------------------
        P9 = new JPanel();
        P9.setBounds(203, 716, 500, 4);
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
        P7.setBackground(Color.pink);
        P7.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        PL3 = new JLabel("√ Step 03");
        PL3.setFont(new java.awt.Font("Dialog", 1, 20));
        PL3.setForeground(Color.white);
        P7.add(PL3);
        this.add(P7);

        P8 = new JPanel();
        P8.setBounds(620, 670, 150, 50);
        P8.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        PL4 = new JLabel("Step 04");
        PL4.setBounds(650, 672, 450, 25);
        PL4.setFont(new java.awt.Font("Dialog", 1, 16));
        PL4.setForeground(Color.black);
        this.add(PL4);
        PLL = new JLabel("Confirming");
        PLL.setBounds(650, 693, 450, 25);
        PLL.setFont(new java.awt.Font("Dialog", 0, 13));
        PLL.setForeground(Color.black);
        this.add(PLL);
        this.add(P8);
        // ----------------------------------------------------------------------------------------------

        // JSONObject checkinInfo
        // =mainFrame.getDataService().getBookingByBookingNo(mainFrame.getOperatingBookingNo());

    }

    public void onCalled() {

        System.out.println("来到了付款信息页面");
        checkinInfo = mainFrame.getDataService().getBookingByBookingNo(mainFrame.getOperatingBookingNo());
        SeatPlanStruct seatPlan = checkinInfo.getSeatPlan();
        String[] extraService1 = seatPlan.getExtraService().toArray(String[]::new);
        feeArea.setText("\n" + "Seat-Plan extra service");

        for (int i = 0; i < extraService1.length; i++) {
            ExtraService extraObject = mainFrame.getDataService().getServiceByLabel(extraService1[i]);
            int price = extraObject.getPrice();
            feeArea.append("\n" + extraService1[i] + " " + ": " + price + " dollars");
        }

        MealPlanStruct mealPlan = checkinInfo.getMealPlan();
        String[] extraService2 = mealPlan.getExtraService().toArray(String[]::new);
        feeArea.append("\n\n\n" + "Meal-Plan extra service");

        for (int i = 0; i < extraService2.length; i++) {
            ExtraService extraObject = mainFrame.getDataService().getServiceByLabel(extraService2[i]);
            int price = extraObject.getPrice();
            feeArea.append("\n" + extraService2[i] + " " + ": " + price + " dollars");
        }

        feeArea.setFont(new java.awt.Font("Dialog", 1, 20));
        feeArea.setForeground(Color.black);

        /*
         * String extraService2 =
         * checkinInfo.getJSONObject("mealPlan").getString("extraService");
         * feeArea.setText("\n"+extraService1 +":50 dollars");
         * feeArea.append("\n\n\n"+extraService2 +":50 dollars");
         */
        /*
         * card = checkinInfo.getJSONObject("payment").getString("creditCardNo");
         * password = checkinInfo.getJSONObject("payment").getString("password");
         */

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("go")) {
            card = cardId.getText();
            password = cardPassword.getText();
            boolean flag = mainFrame.getDataService().checkCreditCardPassword(card, password);
            if (card.equals("") || password.equals("")) {
                JOptionPane.showMessageDialog(null,
                        "Please fill in the missing information.", "Missing information",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                if (flag == true) {
                    int i = JOptionPane.showConfirmDialog(null,
                            "Have you checked the additional fee payment information is correct? You can't change the information once confirming",
                            "Pay or not? ", JOptionPane.YES_NO_OPTION);
                    if (i == 0) {
                        mainFrame.goPanel(Panels.FEE_PAYMENT, Panels.CONFIRMING);
                    }
                } else
                    JOptionPane.showMessageDialog(null,
                            "Please re-enter your account or password", "Wrong information",
                            JOptionPane.ERROR_MESSAGE);
            }

        } else if (e.getActionCommand().equals("back")) {
            mainFrame.goPanel(Panels.FEE_PAYMENT, Panels.MEAL_PLAN);
        }

    }

}
