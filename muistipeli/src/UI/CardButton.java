/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Gamelogic.Card;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Jere
 */
public class CardButton extends JButton {

    private Card card;
    ImageIcon back = new ImageIcon("src/resources/card.png");
    ImageIcon front = new ImageIcon("src/resources/animals/1.png");

    public CardButton(Card card) {
        super();
        this.card = card;
        setSize(100, 100);
        setIcon(back);
        setBorder(BorderFactory.createEmptyBorder());
        setContentAreaFilled(false);
        setCardIcon();

    }

    private void setCardIcon() {
        String dir = card.getCard() + "";
        front = new ImageIcon("src/resources/animals/" + dir + ".png");
    }

    
    public void turn() {
        if (!card.getFace()) {
            setIcon(front);
        } else {
            setIcon(back);
        }
    }
}
