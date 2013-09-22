package Gamelogic;
/**
 * Engine aloittaa pelin, hallinnoi korttien kääntämistä ja pisteitä.
 * @author Jere
 */
public class Engine {
    /**
     * Onko kyseessä ensimmäinen kääntövuoro.
     */
    private boolean firstTurn;
    /**
     * Ensimmäinen käännetty kortti.
     */
    private Card firstTurned;
    /**
     * Toinen käännetty kortit.
     */
    private Card secondTurned;
    /**
     * Pelialustan muuttuja.
     */
    private Gameboard gameboard;
    
    private Score score;

    /**
     * Konstruktori alustaa uuden pelialustan annetun koon perusteella.
     * Alustaa pisteet, pisimmän putken ja vuorot nollaan ja ensimmäisen kääntövuoron true.
     * @param height Kentän korkeus
     * @param width Kentän leveys
     */
    public Engine(int height, int width) {
        gameboard = new Gameboard(height, width);
        firstTurn = true;
        score = new Score();
    }

    /**
     * Alustaa uuden pelialustan valmiilla esitäytetyllä matriisilla testausta varten.
     * @param matrix Esitäytetty järjestetty matriisi testausta varten.
     */
    public Engine(Card[][] matrix) {
        gameboard = new Gameboard(matrix);
        firstTurn = true;  
        score = new Score();
    }

    /**
     * Tarkistaa onko kyseessä ensimmäisen vai toisen kortin kääntö,
     * sekä onko kortti jo löydetty ja kääntää kortin.
     * @param x Kortin x-koordinaatti
     * @param y Kortin y-koordinaatti
     */
    public void turnCard(int x, int y) {
        // Tarkistetaan käännetäänkö ensimmäistä vai toista korttia
        // ja yritetäänkö kääntää jo käännettyä korttia
        if (firstTurn && !gameboard.getCard(x, y).found()) {
            turnFirstCard(x, y);
        } else if (firstTurned != null && gameboard.getCard(x, y) != firstTurned && !gameboard.getCard(x, y).found()) {
            turnSecondCard(x, y);
        }
    }
    
    /**
     * Kääntää ensimmäisen kortin. Asettaa firstTurn muuttujan false joka
     * implikoi että seuraava kääntö on toisen kortin kääntö.
     * @param x Kortin x-koordinaatti
     * @param y Kortin y-koordinaatti
     */
    private void turnFirstCard(int x, int y) {
        gameboard.getCard(x, y).turn();
        firstTurn = false;
        firstTurned = gameboard.getCard(x, y);
    }
    
    /**
     * Kääntää toisen kortin.
     * @param x Kortin x-koordinaatti
     * @param y Kortin y-koordinaatti
     */
    private void turnSecondCard(int x, int y) {
        gameboard.getCard(x, y).turn();
        secondTurned = gameboard.getCard(x, y);
    }
    
    /**
     * Tarkistaa ovatko käännetyt kortit pari vai ei.
     */
    public void checkTurnedCards() {
        if (secondTurned != null) {
            if (firstTurned.same(secondTurned)) {
                pairFound();
                firstTurn = true;
            }
            else {
                pairNotFound();
                firstTurn = true;
                secondTurned.turn();
                firstTurned.turn();
            }
            firstTurned = null;
            secondTurned = null;
        }
    }
    
    /**
     * Kasvattaa tulosta ja vuoroa, asettaa kortit löydetyiksi
     * ja jos löydetty useampi pari peräkkäin kasvattaa tulosta putken verran ja putkea.
     */
    private void pairFound(){
        score.addScore();
        score.addStreak();
        score.addTurn();
    }
    /**
     * Nollaa putken, kasvattaa vuoroa ja kääntää kortit takaisin väärinpäin.
     */
    private void pairNotFound(){
        score.resetStreak();
        score.addTurn();
    }
    
    /**
     * Kertoo onko peli käynnissä tarkistamalla onko löytämättömiä kortteja.
     * @return Palauttaa false jos kaikki kortit ovat jo löytyneet, muuten true.
     */
    public boolean playing() {
        if (gameboard.allFound()) {
            return false;
        } else {
            return true;
        }
    }
    
    public Gameboard getGameboard() {
        return gameboard;
    }

    public int getScore() {
        return score.getScore();
    }
    
    public int getFinalScore(){
        return score.getFinalScore();
    }
    
    public int getStreak(){
        return score.getStreak();
    }
    
    public int getHighestStreak(){
        return score.getLongestStreak();
    }

    public int getTurns() {
        return score.getTurns();
    }
}
