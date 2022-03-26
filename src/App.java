import javax.swing.*;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

import com.formdev.flatlaf.*;

import main.MainFrame;

public class App {

    public static void main(String[] args) throws Exception {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        new MainFrame();
    }

}
