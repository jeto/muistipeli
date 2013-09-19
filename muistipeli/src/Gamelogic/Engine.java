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
     * Kääntövuorot.
     */
    private int turns;
    /**
     * Pisteet.
     */
    private int score;
    /**
     * Peräkkäin löydetyt parit.
     */
    private int streak;
    /**
     * Pisin putki peräkkäin löydettyjä pareja.
     */
    private int highestStreak;
    /**
     * Pelialustan muuttuja.
     */
    private Gameboard gameboard;

    /**
     * Konstruktori alustaa uuden pelialustan annetun koon perusteella.
     * Alustaa pisteet, pisimmän putken ja vuorot nollaan ja ensimmäisen kääntövuoron true.
     * @param height Kentän korkeus
     * @param width Kentän leveys
     */
    public Engine(int height, int width) {
        gameboard = new Gameboard(height, width);
        firstTurn = true;
        turns = 0;
        score = 0;
        highestStreak = 0;
    }

    /**
     * Alustaa uuden pelialustan valmiilla esitäytetyllä matriisilla testausta varten.
     * @param matrix Esitäytetty järjestetty matriisi testausta varten.
     */
    public Engine(Card[][] matrix) {
        gameboard = new Gameboard(matrix);
        firstTurn = true;   
        turns = 0;
        score = 0;
        highestStreak = 0;
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
        score++;
        score += streak;
        streak++;
        highestStreak(streak);
        turns++;
    }
    /**
     * Nollaa putken, kasvattaa vuoroa ja kääntää kortit takaisin väärinpäin.
     */
    private void pairNotFound(){
        streak = 0;
        turns++;
    }
    /**
     * Tarkistaa onko peräkkäin löydetetyt kortit pisin putki pelissä.
     * @param streak Peräkkäin löydetyt parit
     */
    private void highestStreak(int streak){
        if(streak>highestStreak){
            highestStreak = streak;
        }
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
        return score;
    }
    
    public int getStreak(){
        return streak;
    }
    
    public int getHighestStreak(){
        return highestStreak;
    }

    public int getTurns() {
        return turns;
    }
}
