/**
 * muistipeli
 * Ohjelmoinnin harjoitustyö syksy 2013
 */
package Main;
import UI.TextUI;
import UI.GUI;
/**
 * Main -luokka, aloittaa pelin.
 * @author Jere
 */
public class Main {

    public static void main(String[] args) {
//        TextUI peli = new TextUI();
        GUI peli = new GUI();
        peli.run();
    }
}
