package main.ui;

import java.awt.*;
import javax.swing.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import main.MainFrame;
import main.entity.CheckinInfoStruct;
import main.entity.Flight;
import main.entity.Person;
import main.utils.Typings.Panels;

/**
 * Title: FlightInfoPanel.java
 * 
 * This class is used to design the interface for user to choose their flights
 * after they enter the correct booking number or ID number and surname.
 * 
 * @author Langhan Zou
 * @version 2.0
 */
public class FlightInfoPanel extends BasePanel implements ActionListener {
    // Define some variables here
    private Person person;
    private CheckinInfoStruct check;
    private Flight flight;
    private List<CheckinInfoStruct> Array;
    private String SurName;
    private String BookingNum;
    private String IDNum;
    private int i = 0;
    private String FlightNum;
    private String DepartureTime;
    private String ArrivalTime;

    // Define some components used in the frame here
    private JButton back;
    private JButton next;
    private MainFrame mainFrame;
    private JLabel title, jl1, jl2, jl3, jl4, jl5, jl6;
    private JPanel jp1, jp2, jp3, P1, P2, L;
    private JPanel P5, P6, P7, P8, P9, P10,PB;
    private JLabel PL1, PL2, PL3, PL4, PLL;

    public FlightInfoPanel(MainFrame mainFrame) {
        super(mainFrame);// Invoke the parent class constructor
        this.mainFrame = mainFrame;

        jp1 = new JPanel();
        GridLayout layoutLabal = new GridLayout(6, 1);
        jp2 = new JPanel(layoutLabal);
        jp3 = new JPanel();

        // Define the back and finish button
        next = new JButton("next");
        back = new JButton("back");
        next.addActionListener(this);
        next.setActionCommand("Next");
        back.addActionListener(this);
        back.setActionCommand("Back");
        back.setBounds(10, 15, 100, 40);
        next.setBounds(900, 675, 100, 40);
        next.setBackground(new Color(0, 0, 0, 150));
        back.setBackground(new Color(0, 0, 0, 150));
        this.add(back);
        this.add(next);

        // Design the panel to contain the flight and passenger information
        title = new JLabel("Flight Information", JLabel.LEFT);
        title.setFont(new Font("", Font.BOLD, 50));
        jp1.add(title, BorderLayout.CENTER);
        jl1 = new JLabel();
        jl2 = new JLabel();
        jl3 = new JLabel();
        jl4 = new JLabel();
        jl5 = new JLabel();
        jl6 = new JLabel();
        jl1.setFont(new Font("", Font.BOLD, 25));
        jl2.setFont(new Font("", Font.BOLD, 25));
        jl3.setFont(new Font("", Font.BOLD, 25));
        jl4.setFont(new Font("", Font.BOLD, 25));
        jl5.setFont(new Font("", Font.BOLD, 25));
        jl6.setFont(new Font("", Font.BOLD, 25));

        jp2.add(jl1);
        jp2.add(jl2);
        jp2.add(jl3);
        jp2.add(jl4);
        jp2.add(jl5);
        jp2.add(jl6);

        jp1.setBounds(0, 80, 1024, 200);
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
        P1.setBackground(new Color(100, 100, 200));
        this.add(P1);

        P2 = new JPanel();
        P2.setBounds(0, 655, 10000, 5);
        P2.setBackground(new Color(100, 100, 200));
        this.add(P2);

        // ----------------------------------------------------------------------------------------------
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
        PL1.setForeground(Color.pink);
        this.add(PL1);
        PLL = new JLabel("Log in");
        PLL.setBounds(230, 693, 450, 25);
        PLL.setFont(new java.awt.Font("Dialog", 0, 13));
        PLL.setForeground(Color.pink);
        this.add(PLL);
        this.add(P5);

        P6 = new JPanel();
        P6.setBounds(340, 670, 150, 50);
        P6.setBorder(BorderFactory.createLoweredBevelBorder());
        PL2 = new JLabel("Step 02");
        PL2.setFont(new java.awt.Font("Dialog", 0, 18));
        PL2.setForeground(Color.gray);
        ;
        P6.add(PL2);
        this.add(P6);

        P7 = new JPanel();
        P7.setBounds(480, 670, 150, 50);
        P7.setBorder(BorderFactory.createLoweredBevelBorder());
        PL3 = new JLabel("Step 03");
        PL3.setFont(new java.awt.Font("Dialog", 0, 18));
        PL3.setForeground(Color.gray);
        ;
        P7.add(PL3);
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

        L = new JPanel();
        L.setBounds(195, 160, 80, 5);
        L.setBackground(Color.WHITE);
        this.add(L);

        PB = new JPanel();
        PB.setBounds(10, 120, 225, 625);
        PB.setBackground(Color.pink);
        PB.setOpaque(false);
        this.add(PB);

        // ----------------------------------------------------------------------------------------------
    }

    /**
     * @Title: onCalled
     * @Description: This method is used to design the changable information decided
     *               by users
     * @Param: JSONObject param
     * @Return: Nothing
     */
    public void onCalled(JSONObject param) {
        PB.removeAll();
        System.out.println("来到航班信息页");
        BookingNum = param.getString("booking_num");
        SurName = param.getString("surname");
        IDNum = param.getString("id");

        if (BookingNum.equals("None") == false) {
            System.out.println("---------------Here is the bookingnum case--------------");
            check = mainFrame.getDataService().getBookingByBookingNo(BookingNum);
            person = mainFrame.getDataService().getPersonByBookingNo(BookingNum);
            IDNum = person.getBaseInfo().getId();
            Array = person.getCheckinInfo();
            FlightNum = check.getFlightNo();
            System.out.println(FlightNum);
            flight = mainFrame.getDataService().getFlightById(FlightNum);
            DepartureTime = flight.getDepartureTime();
            ArrivalTime = flight.getArrivalTime();
            SurName = person.getBaseInfo().getSurName();

            JButton[] jb = new JButton[Array.size()];
            JPanel[] jp = new JPanel[Array.size()];
            
            

            for (i = 0; i < Array.size(); i++) {
                String BNS = Array.get(i).getBookingNo();
                String FNS = Array.get(i).getFlightNo();
                jb[i] = new JButton(String.valueOf(i));
                jb[i].setBackground(new Color(0, 0, 0, 150));
                jb[i].addActionListener(this);
                jb[i].setActionCommand("l" + i);
                jp[i] = new JPanel();
                jp[i].setBounds(30, 100 + 130 * i, 200, 100);
                jp[i].setOpaque(false);
                jp[i].add(jb[i]);

                PB.add(jp[i]);
                jb[i].setText(
                        "<html>" + "BookingNum: " + "<br>" + BNS + "<br>" + "FlightNo: " + "<br>" + FNS
                                + "</html>");
                jb[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (e.getActionCommand().substring(0, 1).equals("l")) {

                            String a = e.getActionCommand().substring(1, 2);
                            int b = Integer.parseInt(a);
                            System.out.println(b);
                            L.setBounds(195, 160 + b*90, 80, 5);

                        }
                        JSONObject mealSelected = JSON.parseObject("{\"booking_num\":\"" + BNS + "\",\"surname\":\""
                                + SurName + "\",\"id\":\"" + IDNum + "\"}");
                        onCalled(mealSelected);
                    }
                });
            }
            jl1.setText("Surname: " + SurName);
            jl2.setText("ID Num: " + IDNum);
            jl3.setText("Flight Num: " + FlightNum);
            jl4.setText("Departure Time: " + DepartureTime);
            jl5.setText("Arrival Time: " + ArrivalTime);
            jl6.setText("Boarding Gate: " + ArrivalTime);

        } else {
            System.out.println("---------------Here is the id case--------------");
            person = mainFrame.getDataService().getPersonById(IDNum);
            Array = person.getCheckinInfo();
            JButton[] jb = new JButton[Array.size()];
            JPanel[] jp = new JPanel[Array.size()];
            for (i = 0; i < Array.size(); i++) {
                String BNS = Array.get(i).getBookingNo();
                String FNS = Array.get(i).getFlightNo();
                jb[i] = new JButton(String.valueOf(i));
                jb[i].setBackground(new Color(0, 0, 0, 150));
                jp[i] = new JPanel();
                jp[i].setBounds(40, 100 + 160 * i, 200, 100);
                jp[i].setOpaque(false);
                

                jp[i].add(jb[i]);
                PB.add(jp[i]);
                jb[i].setText(
                        "<html>" + "BookingNum: " + "<br>" + BNS + "<br>" + "FlightNo: " + "<br>" + FNS + "</html>");
                jb[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (e.getActionCommand().substring(0, 1).equals("l")) {

                            String a = e.getActionCommand().substring(1, 2);
                            int b = Integer.parseInt(a);
                            System.out.println(b);
                            L.setBounds(195, 140 * b, 80, 5);

                        }
                        JSONObject mealSelected = JSON.parseObject("{\"booking_num\":\"" + BNS + "\",\"surname\":\""
                                + SurName + "\",\"id\":\"" + IDNum + "\"}");
                        onCalled(mealSelected);
                    }
                });
            }

            SurName = person.getBaseInfo().getSurName();
            BookingNum = Array.get(0).getBookingNo();
            check = mainFrame.getDataService().getBookingByBookingNo(BookingNum);
            FlightNum = Array.get(0).getFlightNo();
            flight = mainFrame.getDataService().getFlightById(FlightNum);
            DepartureTime = flight.getDepartureTime();
            ArrivalTime = flight.getArrivalTime();
            jl1.setText("Surname: " + SurName);
            jl2.setText("ID Num: " + IDNum);
            jl3.setText("Flight Num: " + FlightNum);
            jl4.setText("Departure Time: " + DepartureTime);
            jl5.setText("Arrival Time: " + ArrivalTime);
            jl6.setText("Boarding Gate: " + ArrivalTime);
        }
    }

    /**
     * @Title: actionPerformed
     * @Description: This method is used to go to previous or next panel
     * @Param: ActionEvent e
     * @Return: Nothing
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Next")) {
            if(mainFrame.getDataService().getBookingByBookingNo(BookingNum).isCheckinFinished()){
                JOptionPane.showMessageDialog(null, "This booking number has already been checked in.\n if you have any questions, please contact the staff",
							"Already finished check in", JOptionPane.ERROR_MESSAGE);
					return;
            }
            System.out.println("--------------------------------");
            System.out.println(BookingNum);
            System.out.println("--------------------------------");
            mainFrame.setOperatingBookingNo(BookingNum);
            mainFrame.goPanel(Panels.FLIGHT_INFO, Panels.SEAT_PLAN);

        }
        if (e.getActionCommand().equals("Back")) {
            mainFrame.goPanel(Panels.FLIGHT_INFO, Panels.CODE_INPUT);
        }

    }

}
