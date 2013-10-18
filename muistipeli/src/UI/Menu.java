package UI;

import java.awt.Container;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Gamelogic.Engine;

/**
 *
 * @author Jere
 */
public class Menu extends JPanel {
    
    public Menu(){
        super(new FlowLayout());
        createMenu();
        
    }
    
    private void createMenu(){
        JLabel score = new JLabel("pisteet");
        JButton button = new JButton("pelaa");
        add(score);
        add(button);
    }
    
}
