package main.ui;

import javax.swing.JPanel;

import com.alibaba.fastjson.JSONObject;

import main.MainFrame;

/**
 * Base panel, for the inheritance of other pages panel implementation
 *
 * @author Liang Hu
 * @version 1.0
 */
public abstract class BasePanel extends JPanel {
    public BasePanel(MainFrame mainFrame) {

    }

    public void onCalled(JSONObject param) {

    }

    public void onCalled() {

    }
}
