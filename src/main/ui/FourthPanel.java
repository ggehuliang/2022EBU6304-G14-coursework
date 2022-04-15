package main.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import main.MainFrame;
import main.utils.Resources;
import main.utils.Typings.Panels;

public class FourthPanel extends BasePanel implements ActionListener {
    private JButton back;
    private JButton go;
    private JPanel P1,P2,P3,P4;
    private JPanel P5,P6,P7,P8,P9,P10;
    private JLabel PL1,PL2,PL3,PL4,PLL;
    private JLabel L1,L2,L3,L4,LP,box1;
    private JTextField F1,F2;
    private JCheckBox box;
    private int y1 = 370;


    private ArrayList<String> seatcheckbox = new ArrayList<String>();
    private ArrayList<String> seatprice = new ArrayList<String>();
    private ArrayList<String> seatlineA = new ArrayList<String>();
    private ArrayList<String> seatlineB = new ArrayList<String>();
    private ArrayList<String> seatlineC = new ArrayList<String>();


    private MainFrame mainFrame;

    public FourthPanel(MainFrame mainFrame) {
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
        P3.setOpaque(false);
        P3.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        this.add(P3);

        P4 = new JPanel();
        P4.setBounds(520, 100, 450, 525);
        P4.setBackground(Color.pink);
        P4.setOpaque(false);
        P4.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        LP =new JLabel(new ImageIcon(Resources.getImgByName("flight.png")));
        this.add(P4);
        // P4.add(LP);
//----------------------------------------------------------------------------------------------
        P9 = new JPanel();
        P9.setBounds(203, 716, 200, 4);
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
        P6.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        PL2 = new JLabel("Step 02");
        PL2.setBounds(370, 672, 450, 25);
        PL2.setFont(new java.awt.Font("Dialog", 1, 16));
        PL2.setForeground(Color.black);
        this.add(PL2);
        PLL = new JLabel("Make a seating plan");
        PLL.setBounds(370, 693, 450, 25);
        PLL.setFont(new java.awt.Font("Dialog", 0, 13));
        PLL.setForeground(Color.black);
        this.add(PLL);
        this.add(P6);

        P7 = new JPanel();
        P7.setBounds(480, 670, 150, 50);
        P7.setBorder(BorderFactory.createLoweredBevelBorder());
        PL3 = new JLabel("Step 03");
        PL3.setFont(new java.awt.Font("Dialog", 0, 18));
        PL3.setForeground(Color.gray);;
        P7.add(PL3);
        this.add(P7);

        P8 = new JPanel();
        P8.setBounds(620, 670, 150, 50);
        P8.setBorder(BorderFactory.createLoweredBevelBorder());
        PL4 = new JLabel("Step 04");
        PL4.setFont(new java.awt.Font("Dialog", 0, 18));
        PL4.setForeground(Color.gray);;
        P8.add(PL4);
        this.add(P8);

//----------------------------------------------------------------------------------------------
        
        
        
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

        //----------------------------------------------

        JSONArray seatlist = mainFrame.getDataService().getSeatServicesByFlightId("AB1234");
        for (int i = 0; i < seatlist.size(); i++) { 

            JSONObject tool = seatlist.getJSONObject(i);
            seatcheckbox.add(tool.getString("label") + " "); 
            seatprice.add("price: "+ tool.getString("price"));
           }

           for(int i = 0; i < seatcheckbox.size();i ++ ) 
           {   String element = seatcheckbox.get(i);
               
               box = new JCheckBox(element); 
               box.setFont(new java.awt.Font("Serif", 1, 25));
               box.setBounds(50, y1 + 40*i, 300, 30);
               this.add(box); 
               box.addActionListener(this);
               box.setActionCommand("box"+i);
           }   
   
           for(int i = 0; i < seatprice.size();i ++ ) 
           {   String element1 = seatprice.get(i);            
               box1 = new JLabel(element1); 
               box1.setFont(new java.awt.Font("Serif", 1, 25));
               box1.setBounds(200, y1 + 40*i, 300, 30);
               this.add(box1); 
           }



    }

    public void onCalled(){
        System.out.println("来到选座页");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("go")) {

            String info ="";
            System.out.println(info);
            for(Component box:this.getComponents()){
                if(box instanceof JCheckBox){
                    if(((JCheckBox) box).isSelected()){
                        info += ((JCheckBox)box).getText();
                    }
                }
            }  
            System.out.println(info);

            // JSONObject booking=mainFrame.getDataService().getBookingByBookingNo(mainFrame.getOperatingBookingNo());
                //JSONObject seatSelected=JSON.parseObject("{\"mealPlan\":{\"seatNo\":\""+info+"\",\"extraService\":[\""+info+"\"]}}");
                // booking.put("seatPlan",seatSelected);

            mainFrame.goPanel(Panels.SEAT_PLAN, Panels.MEAL_PLAN);

        }
        if (e.getActionCommand().equals("back")) {
            //mainFrame.goPanel(Panels.SEAT_PLAN, Panels.CODE_INPUT);//test
            mainFrame.goPanel(Panels.SEAT_PLAN, Panels.FLIGHT_INFO);

            System.out.println("回");
        }
    }
}