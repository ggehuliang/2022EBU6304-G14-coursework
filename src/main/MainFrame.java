package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.alibaba.fastjson.*;

import main.ui.BasePanel;
import main.ui.FirstPanel;
import main.ui.SecondPanel;
import main.utils.Typings.Panels;

public class MainFrame extends JFrame implements ActionListener {

    private MainFrame mainFrame;
    private BasePanel panels[] = new BasePanel[Panels.values().length];
    private JSONObject nowInfo;

    public void goPanel(Panels nowPanel, Panels targetPanel) {
        // TODO: 如果有可能的话做成滑动的切换效果？
        // set now panel invisible
        panels[nowPanel.ordinal()].setEnabled(false);
        panels[nowPanel.ordinal()].setVisible(false);

        // set target visible
        panels[targetPanel.ordinal()].onCalled();
        panels[targetPanel.ordinal()].setEnabled(true);
        panels[targetPanel.ordinal()].setVisible(true);

        this.repaint();
    }

    public JSONObject getNowInfo() {
        return nowInfo;
    }

    public void setNowInfo(JSONObject nowInfo) {
        this.nowInfo = nowInfo;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public MainFrame() {
        mainFrame = this;
        panels[Panels.WELCOME.ordinal()] = new FirstPanel(mainFrame);
        panels[Panels.CODE_INPUT.ordinal()] = new SecondPanel(mainFrame);

        panels[Panels.WELCOME.ordinal()].setBounds(0, 0, 400, 800);
        for (BasePanel p : panels) {
            if (p == null) {
                continue;
            }
            p.setEnabled(false);
            p.setVisible(false);
            this.add(p);
        }
        panels[0].setEnabled(true);
        panels[0].setVisible(true);
        // firstPanel.setVisible(true);
        this.setTitle("G14's Kiosk Program");
        this.setSize(1024, 768);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
