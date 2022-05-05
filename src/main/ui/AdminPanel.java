package main.ui;
import java.awt.*;

import javax.net.ssl.TrustManager;
import javax.swing.*;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.border.Border;

import com.alibaba.fastjson.JSONObject;

import org.w3c.dom.events.MouseEvent;

import main.MainFrame;
import main.entity.CheckinInfoStruct;
import main.entity.Flight;
import main.entity.MealPlanStruct;
import main.entity.SeatPlanStruct;
import main.utils.Resources;
import main.utils.Typings.Panels;
import java.util.List;
public class AdminPanel extends BasePanel implements ActionListener {
    private MainFrame mainFrame;
    private JTable flightTable,personTable;
    private JScrollPane flightPane;
    private String[] name={"Flight No","Plane","From","To",
                           "Depature Time","Arrival Time","Time","OccupiedSeat","AvailableExtraSeat","AvailableMeal"};
    private List<Flight> allFlight;
    private JButton button;
    private Object[][] tableInfo;
    private int x,y;
    public AdminPanel(MainFrame mainFrame) {
        super(mainFrame);
        this.mainFrame=mainFrame;
        this.setOpaque(false);
        this.setLayout(null);
        //flightTable= new JTable(5,6);
        //add(flightTable);
        /*for(int i=0;i<5;i++)
        {
            tableDate[i][0]="1000"+i;
            for(int j=1;j<8;j++)
            {
                tableDate[i][j]=0;
            }
        }
        String[] name={"学号","软件工程","Java","网络","数据结构","数据库","总成绩","平均成绩"};
        JTable table=new JTable(tableDate,name);*/
        allFlight = mainFrame.getDataService().getAllFlight();
        Object[][] tableInfo=new Object[allFlight.size()][10];
        for(int i=0;i<allFlight.size();i++){

            tableInfo[i][0]=allFlight.get(i).getFlightNo();
            tableInfo[i][1]=allFlight.get(i).getPlane();
            tableInfo[i][2]=allFlight.get(i).getFrom();
            tableInfo[i][3]=allFlight.get(i).getTo();
            tableInfo[i][4]=allFlight.get(i).getDepartureTime();
            tableInfo[i][5]=allFlight.get(i).getArrivalTime();
            tableInfo[i][6]=allFlight.get(i).getTime();
            String[] occupiedSeat=allFlight.get(i).getOccupiedSeat().toArray(String[]::new);
            String[] availableExtraSeat=allFlight.get(i).getAvailableExtraSeat().toArray(String[]::new);
            String[] availableMeal=allFlight.get(i).getAvailableMeal().toArray(String[]::new);
            String occupiedSeatInfo="",availableExtraSeatInfo="",availableMealInfo=""; 
            for(int j=0;j<occupiedSeat.length;j++){
                occupiedSeatInfo = occupiedSeatInfo + occupiedSeat[j];
                if(j!=occupiedSeat.length-1){
                    occupiedSeatInfo= occupiedSeatInfo+","; 
                }
            }
            for(int j=0;j<availableExtraSeat.length;j++){
                availableExtraSeatInfo = availableExtraSeatInfo + availableExtraSeat[j];
                if(j!=availableExtraSeat.length-1){
                    availableExtraSeatInfo= availableExtraSeatInfo+","; 
                }
            }
            for(int j=0;j<availableMeal.length;j++){
                availableMealInfo = availableMealInfo + availableMeal[j];
                if(j!=availableMeal.length-1){
                    availableMealInfo= availableMealInfo+","; 
                }
            }           
            tableInfo[i][7]=occupiedSeatInfo;
            tableInfo[i][8]=availableExtraSeatInfo;
            tableInfo[i][9]=availableMealInfo;
        }
        flightTable = new JTable(tableInfo,name);
        //flightTable.setBounds(10, 10, 800, 600);
        flightTable.setShowGrid(true);
        flightPane =new JScrollPane(flightTable);
        flightPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        flightPane.setBounds(10, 10, 900, 600);
        this.add(flightPane);

        x =flightTable.getSelectedRow();
        y=flightTable.getSelectedColumn();

        button = new JButton("Go");
        button.addActionListener(this);
        button.setActionCommand("Go");
        button.setBounds(900, 675, 100, 40);
        this.add(button);
        //CheckinInfoStruct allFlight.get(index).getFlightNo();
        
        /*flightTable.addMouseListener(new java.awt.event.MouseAdapter(){

            public void mouseClicked(MouseEvent e) {//仅当鼠标单击时响应

               //得到选中的行列的索引值

              int r= table.getSelectedRow();

              int c= table.getSelectedColumn();

              //得到选中的单元格的值，表格中都是字符串

              Object value= table.getValueAt(r, c);

           String info=r+"行"+c+"列值 : "+value.toString();

           javax.swing.JOptionPane.showMessageDialog(null,info);

            }

        });*/
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Go")){
            flightTable.setVisible(false);
            personTable = new JTable(5,5);
        }
        // TODO Auto-generated method stub
        
    }
}