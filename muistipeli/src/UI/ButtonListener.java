/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Gamelogic.Engine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Jere
 */
public class ButtonListener implements ActionListener {
    
    private CardButton card;
    private Engine game;
    private int x;
    private int y;
    
    public ButtonListener(CardButton card, Engine game, int x, int y){
        this.card = card;
        this.game = game;
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        card.turn();
        game.turnCard(x, y);
        if(!game.getFirstTurn()){
            game.checkTurnedCards();
        }
        System.out.println(""+game.getScore());
    }
    
}
