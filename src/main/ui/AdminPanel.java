package main.ui;
import java.awt.*;
import javax.swing.*;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.border.Border;

import com.alibaba.fastjson.JSONObject;

import main.MainFrame;
import main.entity.CheckinInfoStruct;
import main.entity.Flight;
import main.entity.MealPlanStruct;
import main.entity.SeatPlanStruct;
import main.utils.Resources;
import main.utils.Typings.Panels;

public class AdminPanel extends BasePanel implements ActionListener {
    private MainFrame mainFrame;

    public AdminPanel(MainFrame mainFrame) {
        super(mainFrame);
        this.mainFrame=mainFrame;
        this.setOpaque(false);
        this.setLayout(null);

        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
}