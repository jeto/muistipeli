/**
 * muistipeli
 * Ohjelmoinnin harjoitustyö syksy 2013
 */
package Gamelogic;
import UI.TextUI;
import UI.GUI;
/**
 * Main -luokka, aloittaa pelin.
 * @author Jere
 */
public class Muistipeli {

    public static void main(String[] args) {
//        TextUI peli = new TextUI();
        GUI peli = new GUI();
        peli.run();
    }
}
