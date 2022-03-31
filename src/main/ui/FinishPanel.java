package main.ui;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import main.MainFrame;
import main.utils.Typings.Panels;
public class FinishPanel extends BasePanel implements ActionListener {
    private JButton back;
    private JButton finish;
    private MainFrame mainFrame;
    private JPanel jp1,jp2,P1,P2;
    private JLabel jl1,jl2,jl3;

    public FinishPanel(MainFrame mainFrame) {
        super(mainFrame);
        this.mainFrame = mainFrame;
        back = new JButton("back");
        finish = new JButton("finish");
        finish.addActionListener(this);
        finish.setActionCommand("finish");
        back.addActionListener(this);
        back.setActionCommand("Back");
        GridLayout layoutLabal = new GridLayout(3,1);
        jp1 = new JPanel(layoutLabal);
        jp2 = new JPanel();
        jl1 = new JLabel("The boarding pass, baggage tag and the ticket is pringting");
        jl2 = new JLabel("Please remember to bring them away");
        jl3 = new JLabel("Thank you for choose our flight");
        jl1.setFont(new Font("",Font.BOLD, 30));
        jl2.setFont(new Font("",Font.BOLD, 30));
        jl3.setFont(new Font("",Font.BOLD, 30));

        jp1.add(jl1);
        jp1.add(jl2);
        jp1.add(jl3);
        jp1.setOpaque(false);
        jp1.setBounds(100, 200, 1024, 300);

        jp2.add(back);
        jp2.add(finish);
        jp2.setOpaque(false);
        jp2.setBounds(400, 600, 200, 50);
        this.setLayout(null);
        this.add(jp1);
        this.add(jp2);

        P1 = new JPanel();
        P1.setBounds(0, 70, 10000, 5);
        P1.setBackground(new Color(100,100,200));
        this.add(P1);

        P2 = new JPanel();
        P2.setBounds(0, 655, 10000, 5);
        P2.setBackground(new Color(100,100,200));
        this.add(P2);


    }

    public void onCalled(){
        System.out.println("来到结束页面");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("finish")) {
            mainFrame.goPanel(Panels.FINISHED, Panels.WELCOME);
        }
        if(e.getActionCommand().equals("Back")) {
            mainFrame.goPanel(Panels.FINISHED, Panels.CONFIRMING);
        }

    }

    
}
