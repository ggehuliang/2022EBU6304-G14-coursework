package main.ui;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import main.MainFrame;
import main.entity.CheckinInfoStruct;
import main.entity.Flight;
import main.entity.MealPlanStruct;
import main.entity.SeatPlanStruct;
import main.utils.Resources;
import main.utils.Typings.Panels;

/**
 * This is ConfirmingPanel class filling confirming checkin information
 *
 * @author Yikai Wang
 * @version 1.0
 */
public class ConfirmingPanel extends BasePanel implements ActionListener {
    /**
     * Add some basic components used in this panel
     */
    private JButton go;
    private MainFrame mainFrame;
    private JLabel label1, label2;
    private JTextArea inforArea;
    private JPanel panel1, panel2, picPanel, scanPanel;
    private JPanel P5, P6, P7, P8, P9, P10;
    private JLabel PL1, PL2, PL3, PL4, PLL;

    /**
     * Add constructor for ConfirmingPanel.It will create panel and add some basic
     * components of it.
     * 
     * @param mainFrame
     */
    public ConfirmingPanel(MainFrame mainFrame) {
        // Invoke the parent class constructor
        super(mainFrame);
        this.mainFrame = mainFrame;
        this.setOpaque(false);
        this.setLayout(null);

        // Create panel with background
        panel1 = new JPanel();
        panel1.setBounds(0, 70, 10000, 5);
        panel1.setBackground(new Color(100, 100, 200));
        this.add(panel1);
        panel2 = new JPanel();
        panel2.setBounds(0, 655, 10000, 5);
        panel2.setBackground(new Color(100, 100, 200));
        this.add(panel2);
        // Create label with text
        label1 = new JLabel("Your Check_In Information");
        label1.setFont(new java.awt.Font("Serif", 1, 35));
        label1.setBounds(80, 100, 700, 50);
        this.add(label1);
        label2 = new JLabel("Please Scan your ID to confirm!!!");
        label2.setFont(new java.awt.Font("Dialog", 1, 28));
        label2.setBounds(560, 350, 450, 50);
        this.add(label2);

        // Create panel with background
        picPanel = new JPanel();
        picPanel.setBounds(600, 150, 350, 200);
        this.add(picPanel);
        ImageIcon img = new ImageIcon(Resources.getImgByName("ID.png"));
        JLabel jl3 = new JLabel(img);
        picPanel.add(jl3);
        scanPanel = new JPanel();
        scanPanel.setBounds(600, 400, 350, 200);
        this.add(scanPanel);
        ImageIcon img1 = new ImageIcon(Resources.getImgByName("ID2.png"));
        JLabel jl4 = new JLabel(img1);
        scanPanel.add(jl4);

        // Create new button
        go = new JButton("Finished!");
        go.setBounds(900, 675, 100, 40);
        this.add(go);
        go.addActionListener(this);
        go.setActionCommand("go");
        go.setBackground(new Color(0, 0, 0, 150));
        
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

    }

    /**
     * When this panel is invoked, Calling this method to display checkin
     * information
     */
    public void onCalled() {

        System.out.println("来到了值机信息页面");
        CheckinInfoStruct checkinInfo = mainFrame.getDataService()
                .getBookingByBookingNo(mainFrame.getOperatingBookingNo());
        String bookingNo = checkinInfo.getBookingNo();
        String flightNo = checkinInfo.getFlightNo();
        // Date date = checkinInfo.getDate();

        Flight filghObject = mainFrame.getDataService().getFlightById(flightNo);
        String from = filghObject.getFrom();
        String to = filghObject.getTo();
        String departureTime = filghObject.getDepartureTime();
        String arrivalTime = filghObject.getArrivalTime();

        SeatPlanStruct seatPlan = checkinInfo.getSeatPlan();
        String class1 = seatPlan.getClassify();
        String seatNo = seatPlan.getSeatNo();
        String[] extraService1 = seatPlan.getExtraService().toArray(String[]::new);

        MealPlanStruct mealPlan = checkinInfo.getMealPlan();
        String classify = mealPlan.getClassify();
        String[] extraService2 = mealPlan.getExtraService().toArray(String[]::new);

        inforArea = new JTextArea();
        inforArea.setEditable(false);
        inforArea.setBounds(60, 180, 470, 420);
        this.add(inforArea);

        inforArea.setText("BookingNo:" + "    " + bookingNo);
        inforArea.append("\n" + "FlightNo:" + "    " + flightNo);
        // inforArea.append("\n"+"Date:"+" "+date);
        inforArea.append("\n" + "From   " + from + "   to   " + to);
        inforArea.append("\n" + "DepartureTime:    " + departureTime);
        inforArea.append("\n" + "ArrivalTime:    " + arrivalTime);

        // inforArea.append("\n"+"SeatPlan");
        inforArea.append("\n" + "Class:" + "    " + class1);
        inforArea.append("\n" + "SeatNo:" + "    " + seatNo);
        inforArea.append("\n" + "Seat-extraService:");
        for (int i = 0; i < extraService1.length; i++) {
            inforArea.append("  " + extraService1[i] + " ");
        }
        // inforArea.append("\n\n\n"+"MealPlan");
        inforArea.append("\n" + "Meal-classify:" + "    " + classify);
        System.out.println(classify);
        inforArea.append("\n" + "Meal-extraService:");
        for (int i = 0; i < extraService2.length; i++) {
            inforArea.append("  " + extraService2[i]);
        }
        inforArea.setFont(new java.awt.Font("alias", 1, 20));
        inforArea.setForeground(Color.white);
    }

    /**
     * Listener for button
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("go")) {
            mainFrame.goPanel(Panels.CONFIRMING, Panels.FINISHED);
        }
    }
}
