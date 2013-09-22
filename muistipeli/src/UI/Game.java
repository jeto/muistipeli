package UI;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Jere
 */
public class Game extends JPanel {
    
    public Game(int width, int height){
//        super(new BoxLayout());
        super(new GridLayout(height, width, 20, 20));
        createButtons(width, height);
    }
    
    private void createButtons(int width, int height){
//        Container container = new Container();
        ImageIcon icon = new ImageIcon("src/resources/card.png");
        for (int i = 0; i < height*width; i++) {
//            BoxLayout layout = new BoxLayout(container, BoxLayout.X_AXIS);
//            container.setLayout(layout);
            JButton button = new JButton();
            button.setIcon(icon);
            button.setSize(100, 100);
//            container.add(button);
            add(button);
        }
    }
}
