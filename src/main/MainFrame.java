package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.alibaba.fastjson.*;

import main.ui.BasePanel;
import main.ui.FirstPanel;
import main.ui.SecondPanel;
import main.ui.PaymentPanel;
import main.utils.Typings.Panels;

public class MainFrame extends JFrame implements ActionListener {

    private MainFrame mainFrame;
    private BasePanel panels[] = new BasePanel[Panels.values().length];
    private JSONObject nowInfo;
    private JPanelWithBackground bgPanel;

    public void goPanel(Panels nowPanel, Panels targetPanel) {
        // TODO: 如果有可能的话做成滑动的切换效果？
        // set now panel invisible

        // this.getContentPane().remove(bgPanel);
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
        panels[Panels.FEE_PAYMENT.ordinal()] = new PaymentPanel(mainFrame);
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
        try {
            this.bgPanel = new JPanelWithBackground(
                    "resources/img/bg.jpeg");
        } catch (Exception ex) {
            System.out.println(ex);
        }

        // TODO：背景图还有问题，解除注释可以看到图，但第二页会无法显示
        // this.getContentPane().add(this.bgPanel);

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public class JPanelWithBackground extends JPanel {

        private Image backgroundImage;

        // Some code to initialize the background image.
        // Here, we use the constructor to load the image. This
        // can vary depending on the use case of the panel.
        public JPanelWithBackground(String fileName) throws IOException {
            backgroundImage = ImageIO.read(MainFrame.class.getClassLoader().getResource(fileName));
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Draw the background image.
            g.drawImage(backgroundImage.getScaledInstance(1024, 768, Image.SCALE_SMOOTH), 0, 0, this);
        }
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
