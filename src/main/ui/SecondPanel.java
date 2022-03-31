package main.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

import main.MainFrame;
import main.utils.Typings.Panels;

public class SecondPanel extends BasePanel implements ActionListener {
    private JButton back;
    private JButton go;
    private MainFrame mainFrame;
    private JPanel top,med,bot;
	private JPanel bnp,pip,cp;
	private JPanel jp_title,jp1,jp2,jp3,jp4,jp5,jp6,jp7;
	private JPanel button;
	private JButton jb3,jb7,jb_back;
	private JLabel title_zong,title,title_1,title_2;
	private JTextField jtf,jtf5,jtf6;
	
    public SecondPanel(MainFrame mainFrame) {
        super(mainFrame);
        this.mainFrame = mainFrame;
        Border etchedBorder;
		etchedBorder = BorderFactory.createEtchedBorder();
		Border lineBorder;
		lineBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY,2);
		
		title_zong=new JLabel("Please choose one option to check in",JLabel.CENTER);
		title_zong.setFont(new Font("",Font.BOLD, 50));

		title=new JLabel("booking number",JLabel.CENTER);
		title.setFont(new Font("",Font.BOLD, 22));
		jp_title=new JPanel();
		bnp=new JPanel();
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jb3=new JButton("Check In!");
		jb3.addActionListener(this);
		jb3.setActionCommand("Check In!");
		jtf=new JTextField(10);
		
		jp1.add(title,BorderLayout.CENTER);
		jp2.add(jtf);
		jp3.add(jb3);
		
		bnp.setLayout(new GridLayout(3,1));
		bnp.add(jp1);
		bnp.add(jp2);
		bnp.add(jp3);
		
		//--------------------------------------------------------------------
		title_1=new JLabel("personal info",JLabel.CENTER);
		title_1.setFont(new Font("",Font.BOLD, 22));
		pip=new JPanel();
		jp4=new JPanel();
		jp5=new JPanel();
		jp6=new JPanel();
		jp7=new JPanel();
		jb7=new JButton("Check In!");
		jb7.addActionListener(this);
		jb7.setActionCommand("Check In!");
		jtf5=new JTextField(10);
		jtf6=new JTextField(10);
		
		jp4.add(title_1,BorderLayout.CENTER);
		jp5.add(jtf5);
		jtf5.setBorder(BorderFactory.createTitledBorder(lineBorder,"surname"));
		jp6.add(jtf6);
		jtf6.setBorder(BorderFactory.createTitledBorder(lineBorder,"ID number"));
		jp7.add(jb7);
		
		pip.setLayout(new GridLayout(4,1));
		pip.add(jp4);
		pip.add(jp5);
		pip.add(jp6);
		pip.add(jp7);
		//-------------------------------------------------------------------
		
		cp=new JPanel();
		title_2=new JLabel("Scan your card",JLabel.CENTER);
		title_2.setFont(new Font("",Font.BOLD, 22));
		cp.add(title_2);
		//-------------------------------------------------------------------
		
		top=new JPanel();
		bot=new JPanel();
		jb_back=new JButton("Back");
		jb_back.addActionListener(this);
		jb_back.setActionCommand("back");
		button=new JPanel();
		button.add(jb_back);
//		top.setLayout(new GridLayout(1,9));
//		top.setLayout(new GridLayout(1,8));
		top.add(button);
//		for(int i=0;i<7;i++) {
//			top.add(new JLabel());
//		}
		
		bnp.setBorder(BorderFactory.createTitledBorder(etchedBorder));
		pip.setBorder(BorderFactory.createTitledBorder(etchedBorder));
		cp.setBorder(BorderFactory.createTitledBorder(etchedBorder));
		
		bnp.setBounds(100,250,250,350);
		pip.setBounds(385,250,250,350);
		cp.setBounds(670,250,250,350);

		jp_title.add(title_zong);
		jp_title.setBounds(70,100,900,100);
//		bnp.setSize(500,500);
//		med.setLayout(null);
//		med.add(bnp);
//		med.add(pip);
//		med.add(cp);
		
		top.setBounds(10,10,100,60);
		// top.setBorder(BorderFactory.createTitledBorder(etchedBorder,"Month"));
//		med.setBounds(0,100,1000,300);
//		med.setBorder(BorderFactory.createTitledBorder(etchedBorder,"Month"));
		bot.setBounds(0,370,1000,60);
//		bot.setBorder(BorderFactory.createTitledBorder(etchedBorder,"Month"));
		
		this.setLayout(null);
		this.add(jp_title);
		this.add(top);
		this.add(bnp);
		this.add(pip);
		this.add(cp);
		this.add(bot);
    }

    public void onCalled(){
        System.out.println("来到信息填写页");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Check In!")) {
            mainFrame.goPanel(Panels.CODE_INPUT, Panels.FLIGHT_INFO);
        }
        if (e.getActionCommand().equals("back")) {
            mainFrame.goPanel(Panels.CODE_INPUT, Panels.WELCOME);

            System.out.println("回");
        }
    }
}
