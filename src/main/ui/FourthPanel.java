package main.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private JPanel P1,P2,P3,P4,P41,P42;
    private JPanel P5,P6,P7,P8,P9,P10;
    private JLabel PL1,PL2,PL3,PL4,PLL;
    private JLabel L1,L2,L3,L4,LP,box1,box2;
    private JTextField F1,F2;
    private JCheckBox box;
    private int y1 = 370,chooseno = 5;
    private String str,seatTName;


    private ArrayList<String> seatcheckbox = new ArrayList<String>();
    private ArrayList<String> seatprice = new ArrayList<String>();
    
    private JButton[] seatbutton1 = new JButton[24];
    private String[] seatName1 = {"1A","1B","1C","2A","2B","2C","3A","3B","3C","4A","4B","4C","5A","5B","5C","6A","6B","6C","7A","7B","7C","8A","8B","8C"};
    private JButton[] seatbutton2 = new JButton[24];
    private String[] seatName2 = {"1E","1F","1G","2E","2F","2G","3E","3F","3G","4E","4F","4G","5E","5F","5G","6E","6F","6G","7E","7F","7G","8E","8F","8G"};


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

        P41 = new JPanel();
        P41.setBounds(520, 100, 225, 525);
        P41.setBackground(Color.pink);
        P41.setOpaque(false);
        this.add(P41);


        // P4.add(LP);
        P42 = new JPanel();
        P42.setBounds(745, 100, 225, 525);
        P42.setBackground(Color.pink);
        P42.setOpaque(false);
        this.add(P42);
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
            seatcheckbox.add(tool.getString("label")); 
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

//------------------------------------------------------------------------------------
            for (int i = 0;i < seatbutton1.length;i ++)
            {
                if(i<3){
                    seatbutton1[i] = new JButton(seatName1[i],new ImageIcon(Resources.getImgByName("red.png")));
                }else{
                    seatbutton1[i] = new JButton(seatName1[i],new ImageIcon(Resources.getImgByName("blue.png")));
                }
                seatbutton1[i].setPreferredSize(new Dimension(55,55));
                seatbutton1[i].setHorizontalTextPosition(JButton.CENTER);
                seatbutton1[i].setFont(new Font("Times New Roman",Font.BOLD,10));

                seatbutton1[i].addActionListener(this);
                seatbutton1[i].setActionCommand("#1"+ i);

                P41.add(seatbutton1[i]);
            }


            for (int i = 0;i < seatbutton1.length;i ++)
            {
                if(i<3){
                    seatbutton2[i] = new JButton(seatName2[i],new ImageIcon(Resources.getImgByName("red.png")));
                }else{
                    seatbutton2[i] = new JButton(seatName2[i],new ImageIcon(Resources.getImgByName("blue.png")));
                }
                seatbutton2[i].setPreferredSize(new Dimension(55,55));
                seatbutton2[i].setHorizontalTextPosition(JButton.CENTER);
                seatbutton2[i].setFont(new Font("Times New Roman",Font.BOLD,10));

                seatbutton2[i].addActionListener(this);
                seatbutton2[i].setActionCommand("#2"+ i);

                P42.add(seatbutton2[i]);
            }



    }

    public void onCalled(){
        System.out.println("来到选座页");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getActionCommand().equals("go")) {
            if(seatTName == null){
            JOptionPane.showMessageDialog(null,
            "You haven't chosen your seat yet.","Please select your seat",
            JOptionPane.ERROR_MESSAGE);
            }else{
            String info ="";
            System.out.println(info);
            for(Component box:this.getComponents()){
                if(box instanceof JCheckBox){
                    if(((JCheckBox) box).isSelected()){
                        info += ("\""+((JCheckBox)box).getText()+"\"");
                    }
                }
            }  
            System.out.println(info);
            if(info == ""){
                info = ("\"No need\"");
            }
             JSONObject booking=mainFrame.getDataService().getBookingByBookingNo(mainFrame.getOperatingBookingNo());
             JSONObject seatSelected=JSON.parseObject("{\"class\": \"头等舱\",\"seatNo\":\""+seatTName+"\",\"extraService\":["+info+"]}");
             
            booking.put("seatPlan",seatSelected);
            System.out.println(booking);

            mainFrame.goPanel(Panels.SEAT_PLAN, Panels.MEAL_PLAN);

        }
    }
        if (e.getActionCommand().equals("back")) {
            //mainFrame.goPanel(Panels.SEAT_PLAN, Panels.CODE_INPUT);//test
            mainFrame.goPanel(Panels.SEAT_PLAN, Panels.FLIGHT_INFO);

            System.out.println("回");
        }

        if (e.getActionCommand().substring(0,1).equals("#")) {
            seatbutton1[chooseno].setIcon(new ImageIcon(Resources.getImgByName("blue.png")));
            seatbutton2[chooseno].setIcon(new ImageIcon(Resources.getImgByName("blue.png")));

            if(e.getActionCommand().substring(1,2).equals("1")){          
            if(e.getActionCommand().substring(2,3).equals("1")||e.getActionCommand().substring(2,3).equals("2")){
            str = e.getActionCommand().substring(2,4);
            }else{
            str = e.getActionCommand().substring(2,3);
            }
            chooseno = Integer.parseInt(str);
            int i = chooseno;
            // System.out.println(seatName1[i]);           
            seatbutton1[i].setIcon(new ImageIcon(Resources.getImgByName("green.png")));
            seatTName = seatName1[i];

        }else {
            if(e.getActionCommand().substring(2,3).equals("1")||e.getActionCommand().substring(2,3).equals("2")){
            str = e.getActionCommand().substring(2,4);
            }else{
            str = e.getActionCommand().substring(2,3);
            }
            chooseno = Integer.parseInt(str);
            int i = chooseno;
            // System.out.println(seatName1[i]);           
            seatbutton2[i].setIcon(new ImageIcon(Resources.getImgByName("green.png")));
            seatTName = seatName2[i];
        }
         
        }
        
    }
}