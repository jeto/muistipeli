/*
 * muistipeli
 * Ohjelmoinnin harjoitustyö syksy 2013
 * Jere Toivonen
 */
package Gamelogic;

public class Muistipeli {

    public static void main(String[] args) {
        Engine peli = new Engine(5,4);
        peli.turnCard(2, 2);
        peli.turnCard(1, 3);
        System.out.println("");
        peli.turnCard(1,1);
        peli.turnCard(0, 0);
    }
}
