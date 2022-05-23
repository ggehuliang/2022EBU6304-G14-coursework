package main.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import main.MainFrame;
import main.entity.CheckinInfoStruct;
import main.entity.Flight;
import main.entity.Person;
import main.utils.Typings.Panels;
import java.util.List;

/**
 * This is AdminPanel class filling flight and passengers information
 * 
 * @author Yikai Wang
 * @version 1.0
 */
public class AdminPanel extends BasePanel implements ActionListener {
    /**
     * Add some basic components used in this panel
     */
    private MainFrame mainFrame;
    private JTable flightTable, personTable;
    private JScrollPane flightPane, personPane;
    private String[] name = { "FlightNo", "Plane", "From", "To",
            "Depature Time", "Arrival Time", "Time", "OccupiedSeat", "AvailableExtraSeat", "AvailableMeal" };
    private String[] personName = { "FlightNo", "ID", "Name", "BookingNo", "Date", "CheckinFinished", "SeatClassify",
            "SeatNo",
            "SeatExtraService", "MealClassify", "MealExtraService" };
    private List<Flight> allFlight;
    private List<CheckinInfoStruct> allCheckin;
    private JButton goButton, backButton, checkButton;
    private Object[][] tableInfo;
    private Object[][] checkInfo;

    public AdminPanel(MainFrame mainFrame) {

        // Invoke the parent class constructor
        super(mainFrame);
        this.mainFrame = mainFrame;
        this.setOpaque(false);
        this.setLayout(null);

        // Get all flight objects
        allFlight = mainFrame.getDataService().getAllFlight();

        // Create new tableInfo object
        tableInfo = new Object[allFlight.size()][10];
        for (int i = 0; i < allFlight.size(); i++) {

            tableInfo[i][0] = allFlight.get(i).getFlightNo();
            tableInfo[i][1] = allFlight.get(i).getPlane();
            tableInfo[i][2] = allFlight.get(i).getFrom();
            tableInfo[i][3] = allFlight.get(i).getTo();
            tableInfo[i][4] = allFlight.get(i).getDepartureTime();
            tableInfo[i][5] = allFlight.get(i).getArrivalTime();
            tableInfo[i][6] = allFlight.get(i).getTime();

            String[] occupiedSeat = allFlight.get(i).getOccupiedSeat().toArray(String[]::new);
            String[] availableExtraSeat = allFlight.get(i).getAvailableExtraSeat().toArray(String[]::new);
            String[] availableMeal = allFlight.get(i).getAvailableMeal().toArray(String[]::new);

            String occupiedSeatInfo = "", availableExtraSeatInfo = "", availableMealInfo = "";

            for (int j = 0; j < occupiedSeat.length; j++) {
                occupiedSeatInfo = occupiedSeatInfo + occupiedSeat[j];
                if (j != occupiedSeat.length - 1) {
                    occupiedSeatInfo = occupiedSeatInfo + ",";
                }
            }
            for (int j = 0; j < availableExtraSeat.length; j++) {
                availableExtraSeatInfo = availableExtraSeatInfo + availableExtraSeat[j];
                if (j != availableExtraSeat.length - 1) {
                    availableExtraSeatInfo = availableExtraSeatInfo + ",";
                }
            }
            for (int j = 0; j < availableMeal.length; j++) {
                availableMealInfo = availableMealInfo + availableMeal[j];
                if (j != availableMeal.length - 1) {
                    availableMealInfo = availableMealInfo + ",";
                }
            }
            tableInfo[i][7] = occupiedSeatInfo;
            tableInfo[i][8] = availableExtraSeatInfo;
            tableInfo[i][9] = availableMealInfo;
        }

        // Create new table with tableInfo to display flight information
        flightTable = new JTable(tableInfo, name);
        flightTable.setShowHorizontalLines(true);
        flightTable.setShowVerticalLines(true);
        // flightTable.setGridColor(Color.black);
        // Create new scrollpane
        flightPane = new JScrollPane(flightTable);
        flightPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        flightPane.setBounds(30, 50, 950, 610);
        this.add(flightPane);
        flightPane.setVisible(true);
        flightTable.setRowSelectionAllowed(true);
        flightTable.setColumnSelectionAllowed(true);

        // Create new buttons
        goButton = new JButton("Passenger List");
        goButton.addActionListener(this);
        goButton.setActionCommand("Go");
        goButton.setBounds(880, 675, 120, 40);
        this.add(goButton);
        backButton = new JButton("Flight List");
        backButton.addActionListener(this);
        backButton.setActionCommand("back");
        backButton.setBounds(10, 675, 120, 40);
        this.add(backButton);
        checkButton = new JButton("passenger login");
        checkButton.addActionListener(this);
        checkButton.setActionCommand("login");
        checkButton.setBounds(860, 20, 140, 20);
        this.add(checkButton);
    }

    /**
     * Listener for button
     */
    public void actionPerformed(ActionEvent e) {
        // When Go button is listened, displaying relevant passengers information
        if (e.getActionCommand().equals("Go")) {
            int row = flightTable.getSelectedRow();
            int col = flightTable.getSelectedColumn();
            if (row == -1) {
                JOptionPane.showMessageDialog(this, "Please select a flight number");
            } else {
                // personPane.setVisible(true);
                flightPane.setVisible(false);
                allCheckin = mainFrame.getDataService()
                        .getBookingsByFlightId((String) flightTable.getValueAt(row, col));
                System.out.println(flightTable.getValueAt(row, col));
                String a = (String) flightTable.getValueAt(row, col);

                if (a.substring(0, 2).equals("AB")) {
                    checkInfo = new Object[allCheckin.size()][11];
                    for (int i = 0; i < allCheckin.size(); i++) {
                        Person person = mainFrame.getDataService()
                                .getPersonByBookingNo(allCheckin.get(i).getBookingNo());
                        checkInfo[i][0] = allCheckin.get(i).getFlightNo();
                        checkInfo[i][1] = person.getBaseInfo().getId();
                        checkInfo[i][2] = person.getBaseInfo().getSurName() + person.getBaseInfo().getFirstName();
                        checkInfo[i][3] = allCheckin.get(i).getBookingNo();
                        checkInfo[i][4] = allCheckin.get(i).getDate();
                        checkInfo[i][5] = allCheckin.get(i).isCheckinFinished();
                        System.out.println(allCheckin.get(i).isCheckinFinished());
                        if (allCheckin.get(i).isCheckinFinished()) {
                            checkInfo[i][6] = allCheckin.get(i).getSeatPlan().getClassify();
                            checkInfo[i][7] = allCheckin.get(i).getSeatPlan().getSeatNo();
                            String[] seatExtra = allCheckin.get(i).getSeatPlan().getExtraService()
                                    .toArray(String[]::new);
                            String seatExtraInfo = "", mealExtraInfo = "";
                            for (int j = 0; j < seatExtra.length; j++) {
                                seatExtraInfo = seatExtraInfo + seatExtra[j];
                                if (j != seatExtra.length - 1) {
                                    seatExtraInfo = seatExtraInfo + ",";
                                }
                            }
                            checkInfo[i][8] = seatExtraInfo;
                            checkInfo[i][9] = allCheckin.get(i).getMealPlan().getClassify();
                            System.out.println(allCheckin.get(i).getMealPlan().getClassify());
                            String[] mealExtra = allCheckin.get(i).getMealPlan().getExtraService()
                                    .toArray(String[]::new);
                            for (int j = 0; j < mealExtra.length; j++) {
                                mealExtraInfo = mealExtraInfo + mealExtra[j];
                                if (j != mealExtra.length - 1) {
                                    mealExtraInfo = mealExtraInfo + ",";
                                }
                            }
                            checkInfo[i][10] = mealExtraInfo;
                        }
                    }

                    personTable = new JTable(checkInfo, personName);
                    personTable.setShowHorizontalLines(true);
                    personTable.setShowVerticalLines(true);
                    personTable.setRowSelectionAllowed(false);
                    personTable.setColumnSelectionAllowed(false);
                    // personTable.setGridColor(Color.black);
                    personPane = new JScrollPane(personTable);
                    personPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                    personPane.setBounds(30, 50, 950, 610);
                    this.add(personPane);
                } else {
                    JOptionPane.showMessageDialog(this, "Please select the flight number from the flightNo grid");
                }

            }
        }
        // When back button is listened, displaying original flight information
        else if (e.getActionCommand().equals("back")) {
            flightPane.setVisible(true);
            personPane.setVisible(false);

        }

        // When login button is listened, switching to the initial login screen
        else if (e.getActionCommand().equals("login")) {
            mainFrame.goPanel(Panels.ADMIN, Panels.WELCOME);
        }
    }
}