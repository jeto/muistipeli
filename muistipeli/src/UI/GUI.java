package UI;

import java.awt.CardLayout;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Graafinen käyttöliittymä muistipelille.
 * @author Jere
 */
public class GUI implements Runnable {
    private JFrame jframe;
    private Game game;
    private Menu menu;
    private JPanel platform;
    
    public GUI(){
        
    }

    @Override
    public void run() {
        jframe = new JFrame("muistipeli");
            
        jframe.setPreferredSize(new Dimension(800, 600));
        jframe.setResizable(false);
        jframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        createComponents(jframe.getContentPane());
        jframe.setVisible(true);
        jframe.pack();
    }
    
    private void createComponents(Container container){
//        JLabel background = new JLabel(new ImageIcon("src/resources/background.png"));
        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);
        container.setLayout(layout);
        game = new Game(6,4);
//        platform = new JPanel(layout, true);
        menu = new Menu();
//        container.add(background);
//        container.add(platform);
        container.add(game);
        container.add(menu);
    }
    
    public JFrame getFrame() {
        return jframe;
    }
    
}
