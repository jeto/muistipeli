package UI;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import Gamelogic.Engine;

/**
 *
 * @author Jere
 */
public class Game extends JPanel {

    Image background;
    Font scoreFont;
    GridBagConstraints c;
    Engine game;

    public Game(int width, int height) {
        super(new GridBagLayout());
        game = new Engine(width, height);

        c = new GridBagConstraints();
//        background = new ImageIcon(this.getClass().getResource("src/resources/background.png")).getImage();
        createCardButtons(width, height);
        createMenuButtons();
    }

    private void createCardButtons(int width, int height) {
        CardButton button;
        
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                button = new CardButton(game.getGameboard().getCard(column, row));
                
                ButtonListener bl = new ButtonListener(button, game, column, row);
                button.addActionListener(bl);
                
                c.gridx = column;
                c.gridy = row;
                c.weightx = 1;
                c.weighty = 1;
                add(button, c);
            }
        }
    }

    private void createMenuButtons() {
        JLabel score;
        JButton button;
        score = new JLabel("Score "+game.getScore());
        button = new JButton("New Game");
//        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.PAGE_END;
        add(score, c);
        add(button, c);
    }
}
