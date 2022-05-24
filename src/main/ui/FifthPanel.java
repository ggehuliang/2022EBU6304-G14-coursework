package main.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import main.MainFrame;
import main.entity.CheckinInfoStruct;
import main.entity.ExtraService;
import main.entity.MealPlanStruct;
import main.utils.Resources;
import main.utils.Typings.Panels;

public class FifthPanel extends BasePanel implements ActionListener {
    private JButton back, go, start, box2, Refresh;
    private JPanel P1, P2, P3, P4;
    private JPanel P5, P6, P7, P8, P9, P10;
    private JLabel PL1, PL2, PL3, PL4, PLL;
    private JLabel L1, L2, L3, box1, box3;
    private JRadioButton C1, C2, C3;
    private JCheckBox box;
    // private JSONObject JJ, mealname0, mealname1, mealname2;

    private int y1 = 370;
    private String classify = "233";

    private ArrayList<String> Mealcheckbox = new ArrayList<String>();
    // private ArrayList<String> Mealbutton = new ArrayList<String>();
    private ArrayList<String> Mealprice = new ArrayList<String>();
    private ArrayList<String> Mealimag = new ArrayList<String>();

    private ArrayList<JCheckBox> Mealcheckbox1 = new ArrayList<JCheckBox>();
    // private ArrayList<String> Mealbutton = new ArrayList<String>();
    private ArrayList<JLabel> Mealprice1 = new ArrayList<JLabel>();
    private ArrayList<JButton> Mealbutton1 = new ArrayList<JButton>();

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

        go.setBackground(new Color(0, 0, 0, 150));
        back.setBackground(new Color(0, 0, 0, 150));

        P1 = new JPanel();
        P1.setBounds(0, 70, 10000, 5);
        P1.setBackground(new Color(100, 100, 200));
        this.add(P1);

        P2 = new JPanel();
        P2.setBounds(0, 655, 10000, 5);
        P2.setBackground(new Color(100, 100, 200));
        this.add(P2);

        P3 = new JPanel();
        P3.setBounds(30, 355, 450, 270);
        P3.setBackground(new Color(16, 28, 44));
        P3.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        P3.setOpaque(false);
        this.add(P3);

        P4 = new JPanel();
        P4.setBounds(520, 100, 450, 525);
        P4.setOpaque(false);
        P4.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        // LP = new JLabel(new ImageIcon(Resources.getImgByName("meal.png")));
        this.add(P4);
        // P4.add(LP);

        // ----------------------------------------------------------------------------------------------
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
        PL4.setForeground(Color.gray);
        ;
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

        C1 = new JRadioButton("Standard", true);
        C1.setFont(new java.awt.Font("Serif", 1, 25));
        C1.setBounds(50, 230, 150, 30);
        this.add(C1);

        C2 = new JRadioButton("Vegetarian");
        C2.setFont(new java.awt.Font("Serif", 1, 25));
        C2.setBounds(200, 230, 150, 30);
        this.add(C2);

        C3 = new JRadioButton("Halal");
        C3.setFont(new java.awt.Font("Serif", 1, 25));
        C3.setBounds(350, 230, 150, 30);
        this.add(C3);

        ButtonGroup group = new ButtonGroup();
        group.add(C1);
        group.add(C2);
        group.add(C3);

        start = new JButton("start select");
        this.add(start);
        start.setBounds(300, 310, 100, 30);
        start.addActionListener(this);
        start.setActionCommand("start");
        start.setBackground(new Color(0, 0, 0, 150));
        this.repaint();

        Refresh = new JButton("Refresh");
        // this.add(Refresh);
        Refresh.setBounds(400, 310, 100, 30);
        Refresh.addActionListener(this);
        Refresh.setActionCommand("Refresh");

        this.repaint();

    }

    public void onCalled() {
        System.out.println("来到选餐页");
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainFrame.repaint();
        this.repaint();
        if (e.getActionCommand().equals("go")) {

            this.repaint();
            // mainFrame.goPanel(Panels.MEAL_PLAN, Panels.WELCOME);//test

            List<String> extraService = new ArrayList<String>();

            for (Component box : this.getComponents()) {
                if (box instanceof JCheckBox) {
                    if (((JCheckBox) box).isSelected()) {
                        extraService.add(((JCheckBox) box).getText());
                    }
                }
            }

            // System.out.println(classify);

            // if (info == "") {
            // info = ("\"No need\"");
            // }

            CheckinInfoStruct booking = mainFrame.getDataService()
                    .getBookingByBookingNo(mainFrame.getOperatingBookingNo());
            MealPlanStruct mealSelected = new MealPlanStruct();
            mealSelected.setClassify(classify);
            mealSelected.setExtraService(extraService);
            // JSONObject
            // mealSelected=JSON.parseObject("{\"classify\":\""+classify+"\",\"extraService\":["+info+"]}");
            booking.setMealPlan(mealSelected);

            if (booking.getSeatPlan().getExtraService().size() +
                    booking.getMealPlan().getExtraService().size() == 0) {
                mainFrame.goPanel(Panels.MEAL_PLAN, Panels.CONFIRMING);
            } else {
                mainFrame.goPanel(Panels.MEAL_PLAN, Panels.FEE_PAYMENT);
            }
        }
        if (e.getActionCommand().equals("back")) {
            repaint();

            mainFrame.goPanel(Panels.MEAL_PLAN, Panels.SEAT_PLAN);

            System.out.println("回");
        }

        if (e.getActionCommand().equals("start")) {

            this.repaint();
            Mealcheckbox.clear();
            Mealprice.clear();

            this.repaint();

            for (int i = Mealcheckbox1.size() - 1; i >= 0; i--) {
                this.remove(Mealcheckbox1.get(i));
                ;

            }
            for (int i = Mealprice1.size() - 1; i >= 0; i--) {
                this.remove(Mealprice1.get(i));
                ;

            }
            for (int i = Mealbutton1.size() - 1; i >= 0; i--) {
                this.remove(Mealbutton1.get(i));
                ;

            }

            String info = "";

            for (Component C : this.getComponents()) {
                if (C instanceof JRadioButton) {
                    if (((JRadioButton) C).isSelected()) {
                        info += ((JRadioButton) C).getText();
                    }
                }
            }
            System.out.println(info);

            List<ExtraService> meallist = mainFrame.getDataService().getMealServicesByFlightId("AB1234");

            for (ExtraService JJ : meallist) {
                int i = 0;
                System.out.println(JJ.getClassify());
                if (info.equals("Standard")) {

                } else {

                    if (JJ.getClassify().equals(info) == false) {

                        meallist.remove(i);
                    }
                }

                i++;

            }

            for (int i = 0; i < meallist.size(); i++) {

                ExtraService JJ = meallist.get(i);

                Mealcheckbox.add(JJ.getLabel());
                Mealprice.add("price: " + JJ.getPrice());
                Mealimag.add(JJ.getImgName());
            }

            classify = info;

            for (int i = 0; i < Mealcheckbox.size(); i++) {

                String element = Mealcheckbox.get(i);
                box = new JCheckBox(element);
                box.setFont(new java.awt.Font("Serif", 1, 25));
                box.setBounds(50, y1 + 40 * i, 300, 30);
                this.add(box);
                box.addActionListener(this);
                box.setActionCommand("box" + i);
                Mealcheckbox1.add(box);
            }

            for (int i = 0; i < Mealprice.size(); i++) {
                String element1 = Mealprice.get(i);
                box1 = new JLabel(element1);
                box1.setFont(new java.awt.Font("Serif", 1, 25));
                box1.setBounds(170, y1 + 40 * i, 300, 30);
                this.add(box1);
                Mealprice1.add(box1);
            }

            for (int i = 0; i < Mealcheckbox.size(); i++) {
                String element2 = Mealimag.get(i);
                box2 = new JButton("picture");
                box2.setBounds(300, y1 + 40 * i, 100, 30);
                box2.addActionListener(this);
                box2.setActionCommand("p" + element2);
                box2.setBackground(new Color(0, 0, 0, 150));

                this.add(box2);
                Mealbutton1.add(box2);
            }

        }

        if (e.getActionCommand().substring(0, 1).equals("p")) {

            P4.repaint();
            this.repaint();
            P4.removeAll();

            System.out.println(e.getActionCommand().substring(1));
            box3 = new JLabel(new ImageIcon(Resources.getImgByName(e.getActionCommand().substring(1))));
            P4.add(box3);
            mainFrame.goPanel(Panels.MEAL_PLAN, Panels.MEAL_PLAN);
        }
        // this.repaint();
        // mainFrame.repaint();

        if (e.getActionCommand().equals("Refresh")) {

            this.repaint();

            for (int i = Mealcheckbox1.size() - 1; i >= 0; i--) {
                this.remove(Mealcheckbox1.get(i));
                ;

            }
            for (int i = Mealprice1.size() - 1; i >= 0; i--) {
                this.remove(Mealprice1.get(i));
                ;

            }
            for (int i = Mealbutton1.size() - 1; i >= 0; i--) {
                this.remove(Mealbutton1.get(i));
                ;

            }

            mainFrame.goPanel(Panels.MEAL_PLAN, Panels.MEAL_PLAN);
        }

    }

}
