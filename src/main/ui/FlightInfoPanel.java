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
    private JPanel jp1,jp2,jp3;
    



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
