package main.ui;

import java.awt.*;
import javax.swing.*;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.IDN;
import java.util.List;

import main.MainFrame;
import main.entity.BaseInfoStruct;
import main.entity.CheckinInfoStruct;
import main.entity.Flight;
import main.entity.Person;
import main.utils.Typings.Panels;

public class FlightInfoPanel extends BasePanel implements ActionListener {
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
    private String BoardingGate;

    private JButton back;
    private JButton next;
    private JButton[] jb;
    private JButton jb1, jb2, jb3, jb4;
    private MainFrame mainFrame;
    private JLabel title, jl1, jl2, jl3, jl4, jl5, jl6;
    private JPanel jp1, jp2, jp3, P1, P2;

    private JPanel jp4, jp5, jp6, jp7;
    private JPanel[] jp;

    private JPanel P5, P6, P7, P8, P9, P10;
    private JLabel PL1, PL2, PL3, PL4, PLL;
    private JSONObject param;

    public FlightInfoPanel(MainFrame mainFrame) {
        super(mainFrame);
        this.mainFrame = mainFrame;
        jp1 = new JPanel();
        GridLayout layoutLabal = new GridLayout(6, 1);
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

        // jp4 = new JPanel();
        // jb1 = new JButton();
        // jp4.setBounds(40, 100, 200, 100);
        // jp4.setBackground(Color.gray);
        // jp4.add(jb1);
        // this.add(jp4);

        // jp5 = new JPanel();
        // jb2 = new JButton();
        // jp5.setBounds(40, 220, 200, 100);
        // jp5.setBackground(Color.gray);
        // jp5.add(jb2);
        // this.add(jp5);

        // jp6 = new JPanel();
        // jb3 = new JButton();
        // jp6.setBounds(40, 340, 200, 100);
        // jp6.setBackground(Color.gray);
        // jp6.add(jb3);
        // this.add(jp6);

        // jp7 = new JPanel();
        // jb4 = new JButton();
        // jp7.setBounds(40, 460, 200, 100);
        // jp7.setBackground(Color.gray);
        // jp7.add(jb4);
        // this.add(jp7);

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
        // ----------------------------------------------------------------------------------------------
    }

    public void onCalled(JSONObject param) {
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

            // System.out.println("--------------------------------");
            // System.out.println(Array.getJSONObject(1).getString("bookingNo"));
            // System.out.println("--------------------------------");
            JButton[] jb = new JButton[Array.size()];
            JPanel[] jp = new JPanel[Array.size()];
            // jp = new JPanel[Array.size()];
            // jb = new JButton[Array.size()];
            // jb[Array.size()] = new JButton();
            for (i = 0; i < Array.size(); i++) {
                // String BNS = Array.getJSONObject(i).getString("bookingNo");
                // String FNS = Array.getJSONObject(i).getString("flightNo");
                String BNS = Array.get(i).getBookingNo();
                String FNS = Array.get(i).getFlightNo();
                jb[i] = new JButton(String.valueOf(i));
                jp[i] = new JPanel();
                jp[i].setBounds(40, 100 + 120 * i, 200, 100);
                // jp[i].setBackground(Color.gray);
                jp[i].add(jb[i]);
                this.add(jp[i]);
                jb[i].setText(
                        "<html>" + "BookingNum: " + "<br>" + BNS + "<br>" + "FlightNo: " + "<br>" + FNS
                                + "</html>");
                jb[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JSONObject mealSelected = JSON.parseObject("{\"booking_num\":\"" + BNS + "\",\"surname\":\""
                                + SurName + "\",\"id\":\"" + IDNum + "\"}");
                        onCalled(mealSelected);

                    }
                });

            }

            // jb1.setText("<html>" + "BookingNum: " + "<br>" + BookingNum + "</html>");
            // jb2.setText("<html>" + "BookingNum: " + "<br>" +
            // Array.getJSONObject(1).getString("bookingNo")+ "</html>");
            // jb3.setText("<html>" + "BookingNum: " + "<br>" +
            // Array.getJSONObject(2).getString("bookingNo")+ "</html>");
            // jb4.setText("<html>" + "BookingNum: " + "<br>" +
            // Array.getJSONObject(2).getString("bookingNo")+ "</html>");

            jl1.setText("Surname: " + SurName);
            jl2.setText("ID Num: " + IDNum);
            jl3.setText("Flight Num: " + FlightNum);
            jl4.setText("Departure Time: " + DepartureTime);
            jl5.setText("Arrival Time: " + ArrivalTime);
            jl6.setText("Boarding Gate: " + ArrivalTime);

            // jb1.addActionListener(new ActionListener() {
            // @Override
            // public void actionPerformed(ActionEvent e) {
            // BookingNum = Array.getJSONObject(0).getString("bookingNo");
            // System.out.println(BookingNum);
            // check = mainFrame.getDataService().getBookingByBookingNo(BookingNum);
            // person = mainFrame.getDataService().getPersonByBookingNo(BookingNum);
            // IDNum = person.getJSONObject("baseInfo").getString("id");
            // FlightNum = check.getString("flightNo");
            // System.out.println(FlightNum);
            // flight = mainFrame.getDataService().getFlightById(FlightNum);
            // DepartureTime = flight.getString("departureTime");
            // ArrivalTime = flight.getString("arrivalTime");
            // SurName = person.getJSONObject("baseInfo").getString("surName");
            // jl1.setText("Surname: " + SurName);
            // jl2.setText("ID Num: " + IDNum);
            // jl3.setText("Flight Num: " + FlightNum);
            // jl4.setText("Departure Time: " + DepartureTime);
            // jl5.setText("Arrival Time: " + ArrivalTime);
            // jl6.setText("Boarding Gate: " + ArrivalTime);
            // }
            // });
            // jb2.addActionListener(new ActionListener() {
            // @Override
            // public void actionPerformed(ActionEvent e) {
            // BookingNum = Array.getJSONObject(1).getString("bookingNo");
            // System.out.println(BookingNum);
            // check = mainFrame.getDataService().getBookingByBookingNo(BookingNum);
            // person = mainFrame.getDataService().getPersonByBookingNo(BookingNum);
            // IDNum = person.getJSONObject("baseInfo").getString("id");
            // FlightNum = check.getString("flightNo");
            // System.out.println(FlightNum);
            // flight = mainFrame.getDataService().getFlightById(FlightNum);
            // DepartureTime = flight.getString("departureTime");
            // ArrivalTime = flight.getString("arrivalTime");
            // SurName = person.getJSONObject("baseInfo").getString("surName");
            // jl1.setText("Surname: " + SurName);
            // jl2.setText("ID Num: " + IDNum);
            // jl3.setText("Flight Num: " + FlightNum);
            // jl4.setText("Departure Time: " + DepartureTime);
            // jl5.setText("Arrival Time: " + ArrivalTime);
            // jl6.setText("Boarding Gate: " + ArrivalTime);
            // }
            // });
            // jb3.addActionListener(new ActionListener() {
            // @Override
            // public void actionPerformed(ActionEvent e) {
            // BookingNum = Array.getJSONObject(2).getString("bookingNo");
            // System.out.println(BookingNum);
            // check = mainFrame.getDataService().getBookingByBookingNo(BookingNum);
            // person = mainFrame.getDataService().getPersonByBookingNo(BookingNum);
            // IDNum = person.getJSONObject("baseInfo").getString("id");
            // FlightNum = check.getString("flightNo");
            // System.out.println(FlightNum);
            // flight = mainFrame.getDataService().getFlightById(FlightNum);
            // DepartureTime = flight.getString("departureTime");
            // ArrivalTime = flight.getString("arrivalTime");
            // SurName = person.getJSONObject("baseInfo").getString("surName");
            // jl1.setText("Surname: " + SurName);
            // jl2.setText("ID Num: " + IDNum);
            // jl3.setText("Flight Num: " + FlightNum);
            // jl4.setText("Departure Time: " + DepartureTime);
            // jl5.setText("Arrival Time: " + ArrivalTime);
            // jl6.setText("Boarding Gate: " + ArrivalTime);
            // }
            // });
            // jb4.addActionListener(new ActionListener() {
            // @Override
            // public void actionPerformed(ActionEvent e) {
            // jl1.setText("Surname: " + SurName);
            // jl2.setText("ID Num: " + IDNum);
            // jl3.setText("Flight Num: " + FlightNum);
            // jl4.setText("Departure Time: " + DepartureTime);
            // jl5.setText("Arrival Time: " + ArrivalTime);
            // jl6.setText("Boarding Gate: " + ArrivalTime);
            // }
            // });

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
                jp[i] = new JPanel();
                jp[i].setBounds(40, 100 + 120 * i, 200, 100);
                // jp[i].setBackground(Color.gray);
                jp[i].add(jb[i]);
                this.add(jp[i]);
                jb[i].setText(
                        "<html>" + "BookingNum: " + "<br>" + BNS + "<br>" + "FlightNo: " + "<br>" + FNS + "</html>");
                jb[i].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
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
            // System.out.println(FlightNum);
            flight = mainFrame.getDataService().getFlightById(FlightNum);
            DepartureTime = flight.getDepartureTime();
            ArrivalTime = flight.getArrivalTime();

            jl1.setText("Surname: " + SurName);
            jl2.setText("ID Num: " + IDNum);
            jl3.setText("Flight Num: " + FlightNum);
            jl4.setText("Departure Time: " + DepartureTime);
            jl5.setText("Arrival Time: " + ArrivalTime);
            jl6.setText("Boarding Gate: " + ArrivalTime);

            // for (int i = 0; i < Array.size(); i++) {
            // System.out.println(Array.getJSONObject(i).getString("bookingNo"));
            // System.out.println("haha");
            // }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Next")) {
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
