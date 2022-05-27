package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

import com.alibaba.fastjson.*;

import main.ui.AdminPanel;
import main.ui.AdminLoginPanel;
import main.ui.BasePanel;
import main.ui.FifthPanel;
import main.ui.FinishPanel;
import main.ui.FirstPanel;
import main.ui.FlightInfoPanel;
import main.ui.FourthPanel;
import main.ui.SecondPanel;
import main.ui.PaymentPanel;
import main.ui.ConfirmingPanel;
import main.utils.DataService;
import main.utils.Resources;
import main.utils.Typings.Panels;

/**
 * The entire program window, different pages and data reading and writing are
 * included in this class as properties and methods for easy normalization of
 * calling
 * 
 * @author Liang Hu
 * @version 2.0
 */
public class MainFrame extends JFrame implements ActionListener {

    private MainFrame mainFrame;
    private BasePanel panels[] = new BasePanel[Panels.values().length];
    private String operatingBookingNo;
    private DataService dataService = new DataService();

    /**
     * Go to the specified page panel without param
     * 
     * @author Liang Hu
     * @param nowPanel    now page panel
     * @param targetPanel target page panel
     */
    public void goPanel(Panels nowPanel, Panels targetPanel) {
        goPanel(nowPanel, targetPanel, new JSONObject());
    }

    /**
     * Go to the specified page panel with param
     * 
     * @author Liang Hu
     * @param nowPanel    now page panel
     * @param targetPanel target page panel
     * @param param       JSON params
     */
    public void goPanel(Panels nowPanel, Panels targetPanel, JSONObject param) {

        // TODO: 如果有可能的话做成滑动的切换效果？
        // set now panel invisible

        panels[nowPanel.ordinal()].setEnabled(false);
        panels[nowPanel.ordinal()].setVisible(false);

        // call onCall with or without param

        if (param.size() < 1) {

            panels[targetPanel.ordinal()].onCalled();

        } else {
            panels[targetPanel.ordinal()].onCalled(param);

        }
        // set target visible
        panels[targetPanel.ordinal()].setEnabled(true);
        panels[targetPanel.ordinal()].setVisible(true);

        this.repaint();
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public String getOperatingBookingNo() {
        return operatingBookingNo;
    }

    public void setOperatingBookingNo(String operatingBookingNo) {
        this.operatingBookingNo = operatingBookingNo;
    }

    public DataService getDataService() {
        return dataService;
    }

    public MainFrame() {
        mainFrame = this;

        try {
            this.setContentPane(new JPanelWithBackground("bg-768.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        panels[Panels.WELCOME.ordinal()] = new FirstPanel(mainFrame);
        panels[Panels.CODE_INPUT.ordinal()] = new SecondPanel(mainFrame);
        panels[Panels.FLIGHT_INFO.ordinal()] = new FlightInfoPanel(mainFrame);
        panels[Panels.FEE_PAYMENT.ordinal()] = new PaymentPanel(mainFrame);
        panels[Panels.CONFIRMING.ordinal()] = new ConfirmingPanel(mainFrame);
        panels[Panels.SEAT_PLAN.ordinal()] = new FourthPanel(mainFrame);
        panels[Panels.MEAL_PLAN.ordinal()] = new FifthPanel(mainFrame);
        panels[Panels.FINISHED.ordinal()] = new FinishPanel(mainFrame);
        panels[Panels.ADMIN.ordinal()] = new AdminPanel(mainFrame);
        panels[Panels.ADMIN_LOGIN.ordinal()] = new AdminLoginPanel(mainFrame);
        for (BasePanel p : panels) {
            if (p == null) {
                continue;
            }
            p.setEnabled(false);
            p.setBounds(0, 0, 1024, 768);
            p.setVisible(false);
            p.setOpaque(false);
            this.getContentPane().add(p);
        }
        panels[0].setEnabled(true);
        panels[0].setVisible(true);
        this.setTitle("G14's Kiosk Program");
        this.setSize(1024, 768);

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public class JPanelWithBackground extends JComponent {

        private Image backgroundImage;

        // Some code to initialize the background image.
        // Here, we use the constructor to load the image. This
        // can vary depending on the use case of the panel.
        public JPanelWithBackground(String fileName) throws IOException {
            backgroundImage = ImageIO.read(Resources.getImgByName(fileName));
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
