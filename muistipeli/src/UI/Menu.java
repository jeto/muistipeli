package UI;

import java.awt.Container;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Jere
 */
public class Menu extends JPanel {
    
    public Menu(Container container){
        super(new BoxLayout(container, BoxLayout.Y_AXIS));
        
        
    }
    
    private void createMenu(){
        JButton button = new JButton("pelaa");
        add(button);
    }
    
}
