/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Jere
 */
public class CardTurnTimer extends Timer implements ActionListener  {

    private CardButtonListener bl;
    public CardTurnTimer(CardButtonListener bl, int aika){
        super(aika, null);
        this.bl = bl;
        this.addActionListener(this);
        this.setRepeats(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        bl.turnFinished();
    }
    
}
