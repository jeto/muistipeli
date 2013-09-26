package UI;

import java.awt.CardLayout;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Dimension;
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
//        menu = new Menu(container);
        game = new Game(6,5);
//        container.add(menu);
        container.add(game);
    }
    
    private void createMenu(){
        JPanel panel = new JPanel(new CardLayout());
    }
    
    public JFrame getFrame() {
        return jframe;
    }
    
}
