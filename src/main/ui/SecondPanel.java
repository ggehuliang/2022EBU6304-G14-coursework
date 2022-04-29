package main.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;

import javax.swing.border.Border;
import com.alibaba.fastjson.*;
import main.MainFrame;
import main.utils.Typings.Panels;

public class SecondPanel extends BasePanel implements ActionListener {

    private MainFrame mainFrame;
    private JPanel top,med,bot;
	private JPanel bnp,pip,cp;
	private JPanel jp_title,jp1,jp2,jp3,jp4,jp5,jp6,jp7;
	private JPanel button;
	private JButton jb3,jb7,jb_back;
	private JLabel title_zong,title,title_1,title_2;
	private JTextField jtf,jtf5,jtf6;

	private JTabbedPane jtp;
	private JPanel P1,P2,P5,P6,P7,P8,P9,P10;
    private JLabel PL1,PL2,PL3,PL4,PLL;
	
    public SecondPanel(MainFrame mainFrame) {
        super(mainFrame);
        this.mainFrame = mainFrame;

		jtp = new JTabbedPane();

        Border etchedBorder;
		etchedBorder = BorderFactory.createEtchedBorder();
		
		
		title_zong=new JLabel("Please choose one option to check in",JLabel.CENTER);
		title_zong.setFont(new Font("",Font.BOLD, 50));
		
		top=new JPanel();
		bot=new JPanel();
		jb_back=new JButton("Back");
		jb_back.addActionListener(this);
		jb_back.setActionCommand("back");
		button=new JPanel();
		button.add(jb_back);
		top.add(button);

		// bnp.setBounds(100,250,250,350);
		// pip.setBounds(385,250,250,350);
		// cp.setBounds(670,250,250,350);
		jp_title=new JPanel();
		jp_title.add(title_zong);
		jp_title.setBounds(70,100,900,100);

		
		top.setBounds(10,10,100,60);
		bot.setBounds(0,370,1000,60);
		
		this.setLayout(null);
		
		this.add(jp_title);
		this.add(top);

		JTabbedPane jtp = creatJTabbedPaneDemo();
		jtp.setBorder(BorderFactory.createTitledBorder(etchedBorder));
		jtp.setBounds(100,200,800,400);
		this.add(jtp);
		// this.add(bnp);
		// this.add(pip);
		// this.add(cp);
		this.add(bot);

		//加线
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

	public JTabbedPane creatJTabbedPaneDemo()
	{
	    JTabbedPane tabbedPane=new JTabbedPane();
	    ImageIcon icon=createImageIcon("tab.jp1g");
	    JComponent panel1=bookingnumPanel();
	    tabbedPane.addTab("booking number",icon, panel1, "Does nothing");
	    tabbedPane.setMnemonicAt(0,KeyEvent.VK_1);
	    JComponent panel2=nameidPanel();
	    tabbedPane.addTab("personal info",icon,panel2, "Does twice as much nothing");
	    tabbedPane.setMnemonicAt(1,KeyEvent.VK_2);

	    JComponent panel3=cardPanel();
	    tabbedPane.addTab("card",icon,panel3, "Still does nothing");
	    tabbedPane.setMnemonicAt(2,KeyEvent.VK_3);

	    return tabbedPane;
	}

	protected static ImageIcon createImageIcon(String path)
	{
	    java.net.URL imgURL=SecondPanel.class.getResource(path);
	    if(imgURL!=null)
	    {
	        return new ImageIcon(imgURL);
	    }
	    else
	    {
	        System.err.println("Couldn't find file: "+path);
	        return null;
	    }
	}

	protected JComponent bookingnumPanel()
	{
		Border etchedBorder;
		etchedBorder = BorderFactory.createEtchedBorder();
		Border lineBorder;
		lineBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY,2);
		title=new JLabel("Use your booking number to check in",JLabel.CENTER);
		title.setFont(new Font("",Font.BOLD, 22));
		
		bnp=new JPanel();
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jb3=new JButton("Check In!");
		jb3.addActionListener(this);
		jb3.setActionCommand("Check In!");
		jtf=new JTextField(15);
		jtf.setBorder(BorderFactory.createTitledBorder(lineBorder,"booking number"));
		jp1.add(title,BorderLayout.CENTER);
		jp2.add(jtf);
		jp3.add(jb3);
		
		bnp.setLayout(new GridLayout(3,1));
		bnp.add(jp1);
		bnp.add(jp2);
		bnp.add(jp3);
		// bnp.setBorder(BorderFactory.createTitledBorder(etchedBorder));
		// bnp.setBounds(100,200,800,400);
	    return bnp;
	}

	protected JComponent nameidPanel()
	{
		Border etchedBorder;
		etchedBorder = BorderFactory.createEtchedBorder();
		Border lineBorder;
		lineBorder = BorderFactory.createLineBorder(Color.LIGHT_GRAY,2);
		title_1=new JLabel("Use your personal information to check in",JLabel.CENTER);
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
		// pip.setBorder(BorderFactory.createTitledBorder(etchedBorder));
		return pip;
	}

	protected JComponent cardPanel(){
		Border etchedBorder;
		etchedBorder = BorderFactory.createEtchedBorder();
		cp=new JPanel();
		title_2=new JLabel("Scan your card to check in",JLabel.CENTER);
		title_2.setFont(new Font("",Font.BOLD, 22));
		cp.add(title_2);
		// cp.setBorder(BorderFactory.createTitledBorder(etchedBorder));
		return cp;
	}
	

    public void onCalled(){
        System.out.println("来到信息填写页");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Check In!")) {

			String bn=jtf.getText();
			String surname=jtf5.getText();
			String id=jtf6.getText();

			// JSONObject person=mainFrame.getDataService().getPersonById(id);
			
			// String name="";
			// try {
			// 	name=person.getJSONObject("baseInfo").getString("surName");
			// } catch (Exception ex) {
			
			// }

			// if(!name.equals(surname)){
			// 	JOptionPane.showMessageDialog(null, "ID and name not match!", 
			// 		"Missing information",JOptionPane.ERROR_MESSAGE);
			// }

			// else{
			// 	if(jtf.getText().equals("")) bn="None";
			// 	if(jtf5.getText().equals("")) surname="None";
			// 	if(jtf6.getText().equals("")) id="None";
			// 	JSONObject info=JSON.parseObject("{\"booking_num\":\""+bn+"\",\"surname\":\""+surname+"\",\"id\":\""+id+"\"}");
			// 	String s1 = info.getString("booking_num");
			// 	String s2 = info.getString("surname");
			// 	String s3 = info.getString("id");
			// 	System.out.println(s1+s2+s3);
			// 	mainFrame.goPanel(Panels.CODE_INPUT, Panels.FLIGHT_INFO,info);
			// }
			if(jtf.getText().equals("")) bn="None";
			if(jtf5.getText().equals("")) surname="None";
			if(jtf6.getText().equals("")) id="None";
			JSONObject info=JSON.parseObject("{\"booking_num\":\""+bn+"\",\"surname\":\""+surname+"\",\"id\":\""+id+"\"}");
			String s1 = info.getString("booking_num");
			String s2 = info.getString("surname");
			String s3 = info.getString("id");
			System.out.println(s1+s2+s3);
			mainFrame.goPanel(Panels.CODE_INPUT, Panels.FLIGHT_INFO,info);
			
        
            // mainFrame.goPanel(Panels.CODE_INPUT, Panels.FLIGHT_INFO);
            
        }
        if (e.getActionCommand().equals("back")) {
            mainFrame.goPanel(Panels.CODE_INPUT, Panels.WELCOME);

            System.out.println("回");
        }
    }
}
