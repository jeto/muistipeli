/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UI.listeners;

import UI.Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Jere
 */
public class ButtonListener implements ActionListener {
    private JButton button;
    private Game game;
    
    public ButtonListener(JButton button, Game game){
        this.button = button;
        this.game = game;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (button.getActionCommand()){
            case "Pelaa":
               game = new Game(2, 2);
        }
    }
    
}
