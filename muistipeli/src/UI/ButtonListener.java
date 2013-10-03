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
    private Engine engine;
    private Game game;
    private int x;
    private int y;
    private CardTurnTimer timer;

    public ButtonListener(Game game, CardButton card, Engine engine, int x, int y) {
        this.card = card;
        this.engine = engine;
        this.x = x;
        this.y = y;
        this.game = game;
        timer = new CardTurnTimer(this, 1500);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!engine.getFirstTurn()) {

            engine.turnCard(x, y);
            card.changeState();
            timer.start();

        } else {
            engine.turnCard(x, y);
            card.changeState();
        }
        System.out.println("" + engine.getScore());
    }

    public void turnFinished() {
        engine.checkTurnedCards();

        for (CardButton cards : game.getCardButtons()) {
            cards.changeState();
        }
    }
}