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

import com.alibaba.fastjson.JSONObject;

import main.MainFrame;
import main.utils.Resources;
import main.utils.Typings.Panels;

public class ConfirmingPanel extends BasePanel implements ActionListener {
    private JButton go;
    private MainFrame mainFrame;
    private JLabel label1;
    private JTextArea inforArea;
    private JLabel label2;
    private JPanel panel1,panel2,picPanel;


    private JPanel P5,P6,P7,P8,P9,P10;
    private JLabel PL1,PL2,PL3,PL4,PLL;


    public ConfirmingPanel(MainFrame mainFrame) {
        super(mainFrame);
        this.mainFrame=mainFrame;
        this.setOpaque(false);
        this.setLayout(null);

        panel1 = new JPanel();
        panel1.setBounds(0, 70, 10000, 5);
        panel1.setBackground(new Color(100,100,200));
        this.add(panel1);

        panel2 = new JPanel();
        panel2.setBounds(0, 655, 10000, 5);
        panel2.setBackground(new Color(100,100,200));
        this.add(panel2);

        label1 = new JLabel("Your Check_In Information");
        label1.setFont(new java.awt.Font("Serif", 1, 35));
        label1.setBounds(80, 100, 700, 50);
        this.add(label1);



        /*inforArea = new JTextArea();
        inforArea.setEditable(false); 
        inforArea.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        inforArea.setBounds(60, 180, 470, 420);
        JScrollPane scroll=new JScrollPane(inforArea);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(scroll);*/



        label2 = new JLabel("Please Scan your ID to confirm!!!");
        label2.setFont(new java.awt.Font("Dialog", 1, 28));
        label2.setBounds(560, 350, 450,50);
        this.add(label2);

        picPanel = new JPanel();
        picPanel.setBounds(600, 400, 350, 200);
        picPanel.setBackground(Color.green);
        this.add(picPanel);
        JLabel jl3=new JLabel(new ImageIcon(Resources.getImgByName("ID.png")));
		picPanel.add(jl3);

        go = new JButton("Finished!");
        go.setBounds(900, 675, 100, 40);
        this.add(go);
        go.addActionListener(this);
        go.setActionCommand("go");
//----------------------------------------------------------------------------------------------
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
//----------------------------------------------------------------------------------------------
      
    }

        public void onCalled(){

            System.out.println("来到了值机信息页面");
            JSONObject checkinInfo =mainFrame.getDataService().getBookingByBookingNo(mainFrame.getOperatingBookingNo());
            String bookingNo = checkinInfo.getString("bookingNo");
            String flightNo = checkinInfo.getString("flightNo");
            String date = checkinInfo.getString("date");

            JSONObject filghObject = mainFrame.getDataService().getFlightById(flightNo);
            String from = filghObject.getString("from");
            String to = filghObject.getString("to");
            String departureTime = filghObject.getString("departureTime");
            String arrivalTime =filghObject.getString("arrivalTime");
    
            JSONObject seatPlan = checkinInfo.getJSONObject("seatPlan");
            String class1 = seatPlan.getString("class");
            String seatNo = seatPlan.getString("seatNo");
            String[] extraService1=seatPlan.getJSONArray("extraService").toArray(String[]::new);

    
            JSONObject mealPlan = checkinInfo.getJSONObject("mealPlan");
            String classify = mealPlan.getString("classify");
            String[] extraService2 =mealPlan.getJSONArray("extraService").toArray(String[]::new);

            inforArea = new JTextArea();
            inforArea.setEditable(false); 
            inforArea.setBorder(BorderFactory.createLineBorder(Color.black, 3));
            inforArea.setBounds(60, 180, 470, 420);
            inforArea = new JTextArea();
            inforArea.setEditable(false); 
            inforArea.setBorder(BorderFactory.createLineBorder(Color.black, 3));
            inforArea.setBounds(60, 180, 470, 420);
            this.add(inforArea);
            
            inforArea.setText("BookingNo:"+" "+bookingNo);
            inforArea.append("\n"+"FlightNo:"+" "+flightNo);
            inforArea.append("\n"+"Date:"+" "+date);
            inforArea.append("\n"+"From "+from+" to "+to);
            inforArea.append("\n"+"DepartureTime: "+departureTime);
            inforArea.append("\n"+"ArrivalTime: "+arrivalTime);

            inforArea.append("\n\n\n"+"SeatPlan");
            inforArea.append("\n"+"class:"+" "+class1);
            inforArea.append("\n"+"seatNo:"+" "+seatNo);
            inforArea.append("\n"+"extraService:");
            for(int i=0;i<extraService1.length;i++){
                inforArea.append("\n"+extraService1[i]);
            }
            inforArea.append("\n\n\n"+"MealPlan");
            inforArea.append("\n"+"classify:"+" "+classify);
            inforArea.append("\n"+"extraService:");
            for(int i=0;i<extraService2.length;i++){
                inforArea.append("\n"+extraService2[i]);
            }
            inforArea.setFont(new java.awt.Font("Dialog", 1, 15));
            inforArea.setForeground(Color.black);
        }
    
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("go")) {
                mainFrame.goPanel(Panels.CONFIRMING,Panels.FINISHED);
            }
        }
    }
            
