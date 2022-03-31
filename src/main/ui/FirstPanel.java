package main.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import main.MainFrame;
import main.utils.Typings.Panels;

public class FirstPanel extends BasePanel implements ActionListener{
    private MainFrame mainFrame;
    private JPanel jp1,jp2;
	private JButton jb1;
	private JLabel title;
    //test
    //test

    public FirstPanel(MainFrame mainFrame) {
        super(mainFrame);
        this.mainFrame=mainFrame;

        title=new JLabel("Welcome to flight check-in kiosk!",JLabel.CENTER);
		title.setFont(new Font("",Font.BOLD, 50));
		// Border etchedBorder;
		// etchedBorder = BorderFactory.createEtchedBorder();
		jp1=new JPanel();
		jp2=new JPanel();
		jb1=new JButton("Check In!");
        jb1.setFont(new Font("",Font.BOLD, 25));
		jb1.addActionListener(this);
		jb1.setActionCommand("Check In!");
		
		jp1.add(title,BorderLayout.CENTER);
		jp2.add(jb1);
        jp1.setBounds(0,80,1024,200);
        jb1.setBounds(390,400,240,50);
        // jp1.setBorder(BorderFactory.createTitledBorder(etchedBorder));
        // jb1.setBorder(BorderFactory.createTitledBorder(etchedBorder));
		// this.setSize(1024,768);
		this.setLayout(null);
		this.add(jp1);
		this.add(jb1);
    }

    public void onCalled(){
        System.out.println("来到了初始界面");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Check In!")) {
            //			System.out.print("lallala");
            mainFrame.goPanel(Panels.WELCOME, Panels.CODE_INPUT);
        }

    }
}
