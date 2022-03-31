package main.ui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import main.MainFrame;
import main.utils.Typings.Panels;

public class FlightInfoPanel extends BasePanel implements ActionListener{
    private String SurName = "HAHAHAHA";
/*  private String IDNum;
    private String FlightNum;
    private String DepartureTime;
    private String ArrivalTime;
    private String BoardingGate;
*/

    private JButton back;
    private JButton next;
    private MainFrame mainFrame;
    private JLabel title,jl1,jl2,jl3,jl4,jl5,jl6;
    private JPanel jp1,jp2,jp3,P1,P2;
    
    private JPanel P5,P6,P7,P8,P9,P10;
    private JLabel PL1,PL2,PL3,PL4,PLL;


    public FlightInfoPanel(MainFrame mainFrame) {
        super(mainFrame);
        this.mainFrame = mainFrame;
        jp1 = new JPanel();
        GridLayout layoutLabal = new GridLayout(6,1);
        jp2 = new JPanel(layoutLabal);
        jp3 = new JPanel();
        next = new JButton("next");
        back = new JButton("back");

        next.addActionListener(this);
        next.setActionCommand("Next");
        back.addActionListener(this);
        back.setActionCommand("Back");
        jp3.add(back);
        jp3.add(next);


        title = new JLabel("Flight Information",JLabel.LEFT);
        title.setFont(new Font("",Font.BOLD, 50));
        jp1.add(title,BorderLayout.CENTER);    
        jl1  = new JLabel("Surname: " + SurName,JLabel.LEFT);
        jl2  = new JLabel("ID Num: " ,JLabel.LEFT);
        jl3  = new JLabel("Flight Num: " ,JLabel.LEFT);
        jl4  = new JLabel("Departure Time: " ,JLabel.LEFT);
        jl5  = new JLabel("Arrival Time: " ,JLabel.LEFT);
		jl6  = new JLabel("Boarding Gate: " ,JLabel.LEFT);
        jl1.setFont(new Font("", Font.TYPE1_FONT, 25));
        jl2.setFont(new Font("", Font.TYPE1_FONT, 25));
        jl3.setFont(new Font("", Font.TYPE1_FONT, 25));
        jl4.setFont(new Font("", Font.TYPE1_FONT, 25));
        jl5.setFont(new Font("", Font.TYPE1_FONT, 25));
        jl6.setFont(new Font("", Font.TYPE1_FONT, 25));

        jp2.add(jl1);
        jp2.add(jl2);
        jp2.add(jl3);
        jp2.add(jl4);
        jp2.add(jl5);
        jp2.add(jl6);

        jp1.setBounds(0,80,1024,200);
        jp2.setBounds(300, 180, 400, 400);
        jp3.setBounds(400, 600, 200, 50);

        jp1.setOpaque(false);
        jp2.setOpaque(false);
        jp3.setOpaque(false);

        this.setLayout(null);
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        
        P1 = new JPanel();
        P1.setBounds(0, 70, 10000, 5);
        P1.setBackground(new Color(100,100,200));
        this.add(P1);

        P2 = new JPanel();
        P2.setBounds(0, 655, 10000, 5);
        P2.setBackground(new Color(100,100,200));
        this.add(P2);
//----------------------------------------------------------------------------------------------
        P9 = new JPanel();
        P9.setBounds(203, 716, 30, 4);
        P9.setBackground(Color.pink);
        this.add(P9);

        P10 = new JPanel();
        P10.setBounds(203, 716, 567, 4);
        P10.setBackground(Color.gray);
        this.add(P10);

        P5 = new JPanel();
        P5.setBounds(200, 670, 150, 50);
        P5.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        PL1 = new JLabel("Step 01");
        PL1.setBounds(230, 672, 450, 25);
        PL1.setFont(new java.awt.Font("Dialog", 1, 16));
        PL1.setForeground(Color.black);
        this.add(PL1);
        PLL = new JLabel("Log in");
        PLL.setBounds(230, 693, 450, 25);
        PLL.setFont(new java.awt.Font("Dialog", 0, 13));
        PLL.setForeground(Color.black);
        this.add(PLL);
        this.add(P5);

        P6 = new JPanel();
        P6.setBounds(340, 670, 150, 50);
        P6.setBorder(BorderFactory.createLoweredBevelBorder());
        PL2 = new JLabel("Step 02");
        PL2.setFont(new java.awt.Font("Dialog", 0, 18));
        PL2.setForeground(Color.gray);;
        P6.add(PL2);
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
    }

    public void onCalled(){
        System.out.println("来到航班信息页");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Next")) {
            mainFrame.goPanel(Panels.FLIGHT_INFO, Panels.SEAT_PLAN);
        }
        if(e.getActionCommand().equals("Back")) {
            mainFrame.goPanel(Panels.FLIGHT_INFO, Panels.CODE_INPUT);
        }

    }
    
    
}
