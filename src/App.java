import javax.swing.*;

import java.awt.Color;

import com.formdev.flatlaf.*;

import main.MainFrame;

/**
 * The entry class of the program, with the entry method in this class,
 * defines the Swing theme
 * 
 * @author Liang Hu
 * @version 2.0
 */
public class App {

    public static void main(String[] args) throws Exception {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            UIManager.put("Label.foreground", Color.white);
            UIManager.put("Button.foreground", Color.white);
            ;
            UIManager.put("RadioButton.foreground", Color.white);
            UIManager.put("TextField.foreground", Color.white);
            UIManager.put("String.foreground", Color.white);
            UIManager.put("Panel.foreground", Color.white);
            UIManager.put("CheckBox.foreground", Color.white);
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        new MainFrame();
    }

}
