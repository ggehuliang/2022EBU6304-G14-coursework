package main.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;

import javax.swing.border.Border;
import com.alibaba.fastjson.*;
import main.MainFrame;
import main.entity.Person;
import main.utils.Resources;
import main.utils.Typings.Panels;

/**
 * Title: SecondPanel.java
 * 
 * This class is used to design the interface for user to check in and improve
 * the interface interactivity.
 * 
 * @author Jiangshan Wang Group14
 * @version 2.0
 */
public class AdminLoginPanel extends BasePanel implements ActionListener {

	private MainFrame mainFrame;
	private JPanel top, bot;
	private JPanel bnp;
	private JPanel jp2, jp3;
	private JButton jb3, jb_back;
	private JLabel title_zong;
	private JTextField jtf, jtf2;

	private JPanel P1, P2, P5, P6, P7, P8, P9, P10;
	private JLabel PL1, PL2, PL3, PL4, PLL;

	/**
	 * This is a constructor for class SecondPanel, which create the main interface.
	 */
	public AdminLoginPanel(MainFrame mainFrame) {
		super(mainFrame);
		this.mainFrame = mainFrame;

		title_zong = new JLabel("Input your username and password", JLabel.CENTER);
		title_zong.setFont(new Font("", Font.BOLD, 46));

		top = new JPanel();
		bot = new JPanel();
		jb_back = new JButton("Back");
		jb_back.addActionListener(this);
		jb_back.setActionCommand("back");
		top.add(jb_back);

		// jp_title = new JPanel();
		// jp_title.add(title_zong);
		// bnp=bookingnumPanel();

		Border lineBorder;
		lineBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2);

		jb3 = new JButton("Check In!");
		jb3.addActionListener(this);
		jb3.setActionCommand("Check In!bn");
		jtf = new JTextField(15);
		jtf.setBorder(BorderFactory.createTitledBorder(lineBorder, "Username"));
		jtf2 = new JTextField(15);
		jtf2.setBorder(BorderFactory.createTitledBorder(lineBorder, "Password"));

		
		jtf.setBounds(410, 240, 190, 50);
		jtf2.setBounds(410, 370, 190, 50);
		jb3.setBounds(450, 500, 110, 40);

		title_zong.setBounds(70, 100, 900, 100);

		jb_back.setBounds(15, 25, 100, 20);
		bot.setBounds(0, 370, 1000, 60);

		this.setLayout(null);
		this.add(jb3);
		this.add(jtf);
		this.add(jtf2);
		this.add(title_zong);
		this.add(jb_back);

		// this.add(bot);

		// 加线
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

	/**
	 * This method is used to create the panel for users using booking number to
	 * check in.
	 */
	protected JPanel bookingnumPanel() {

		bnp = new JPanel();

		Border lineBorder;
		lineBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2);

		jp2 = new JPanel();
		jp3 = new JPanel();
		jb3 = new JButton("Check In!");
		jb3.addActionListener(this);
		jb3.setActionCommand("Check In!bn");
		jtf = new JTextField(15);
		jtf.setBorder(BorderFactory.createTitledBorder(lineBorder, "booking number"));
		jp2.add(jtf);
		jp3.add(jb3);

		bnp.setLayout(new GridLayout(3, 1));
		bnp.add(jp2);
		bnp.add(jp3);
		// bnp.setBorder(BorderFactory.createTitledBorder(etchedBorder));
		// bnp.setBounds(100,200,800,400);
		return bnp;
	}


	public void onCalled() {
		System.out.println("来到信息填写页");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Check In!bn")) {

			String name = jtf.getText();
			String pwd = jtf2.getText();

			if (name.equals("")||pwd.equals("")) {
				JOptionPane.showMessageDialog(null, "Please fill in the blank!",
						"Missing information", JOptionPane.ERROR_MESSAGE);
			} 

			else if(!mainFrame.getDataService().checkAdminPassword(name, pwd)){
				JOptionPane.showMessageDialog(null, "User name and password doesn't match!",
						"Wrong information", JOptionPane.ERROR_MESSAGE);
			}
			else{
				mainFrame.goPanel(Panels.ADMIN_LOGIN, Panels.ADMIN);
			}
		}

		if (e.getActionCommand().equals("back")) {
			mainFrame.goPanel(Panels.ADMIN_LOGIN, Panels.WELCOME);

			System.out.println("回");
		}
	}
}
