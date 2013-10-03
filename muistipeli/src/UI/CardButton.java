/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Domain.Card;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Jere
 */
public class CardButton extends JButton {

    private Card card;
    private ImageIcon back = new ImageIcon("src/resources/card.png");
    private ImageIcon front = new ImageIcon("src/resources/animals/1.png");
    private ImageIcon front2 = new ImageIcon("src/resources/cardplain.png");
    private ImageIcon found = new ImageIcon("src/resources/found.png");

    public CardButton(Card card) {
        super();
        this.card = card;
        setSize(100, 100);
        setIcon(back);
        setBorder(BorderFactory.createEmptyBorder());
        setContentAreaFilled(false);
        setCardIcon();
        setDisabledIcon(found);
        setRolloverEnabled(true);
        setRolloverIcon(front2);
    }

    private void setCardIcon() {
        String dir = card.getCard() + "";
        front = new ImageIcon("src/resources/animals/" + dir + ".png");
    }

    
    public void changeState() {
        if (card.getFace() && !card.found()) {
            setRolloverEnabled(false);
            setIcon(front);
        } else if (!card.getFace() && !card.found()){
            setRolloverEnabled(true);
            setIcon(back);
        } else if (card.found()){
            setEnabled(false);
        }
    }
}
