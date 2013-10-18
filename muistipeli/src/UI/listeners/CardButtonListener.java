/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.listeners;

import Gamelogic.Engine;
import UI.CardButton;
import UI.CardTurnTimer;
import UI.Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Jere
 */
public class CardButtonListener implements ActionListener {

    private CardButton card;
    private Engine engine;
    private Game game;
    private int x;
    private int y;
    private CardTurnTimer timer;

    public CardButtonListener(Game game, CardButton card, Engine engine, int x, int y) {
        this.card = card;
        this.engine = engine;
        this.x = x;
        this.y = y;
        this.game = game;
        timer = new CardTurnTimer(this, 1500);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.stop();
        engine.checkTurnedCards();
        
        if (!engine.getFirstTurn()) {

            engine.turnCard(x, y);
            card.changeState();
            timer.start();

        } else {
            engine.turnCard(x, y);
            card.changeState();
        }
    }

    public void turnFinished() {
        engine.checkTurnedCards();

        for (CardButton cards : game.getCardButtons()) {
            cards.changeState();
        }
        
        if(!engine.playing()){
            System.out.println("Peli ohi, pisteesi: "+ engine.getFinalScore());
            System.out.println("Käytit " + engine.getTurns() + " vuoroa.");
            System.out.println("Pisin putkesi oli "+ engine.getHighestStreak() + " korttia putkeen!");
        }
    }
}