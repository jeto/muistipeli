package Gamelogic;

public class Engine {
    // Ensimmäisen kortin kääntäminen
    private boolean firstTurn;
    // Käännetyt kortit
    private Card firstTurned;
    private Card secondTurned;
    // Kääntövuorot, pisteet ja peräkkäin löydetyt
    private int turns;
    private int score;
    private int streak;
    private int highestStreak;
    // Pelilaudan muuttuja
    private Gameboard gameboard;

    // Alustetaan uusi pelilauta annetun koon perusteella
    // Asetetaan pisteet ja vuorot nolliin, ensimmäinen kortin kääntö true
    public Engine(int height, int width) {
        gameboard = new Gameboard(height, width);
        firstTurn = true;
        turns = 0;
        score = 0;
        highestStreak = 0;
    }

    // Engine valmiilla matriisilla testausta varten
    public Engine(Card[][] matrix) {
        gameboard = new Gameboard(matrix);
        firstTurn = true;
        turns = 0;
        score = 0;
        highestStreak = 0;
    }

    // Kortin kääntämismetodi
    public void turnCard(int x, int y) {
        // Tarkistetaan käännetäänkö ensimmäistä vai toista korttia
        // ja yritetäänkö kääntää jo käännettyä korttia
        if (firstTurn && !gameboard.getCard(x, y).found()) {
            turnFirstCard(x, y);
        } else if (firstTurned != null && gameboard.getCard(x, y) != firstTurned && !gameboard.getCard(x, y).found()) {
            turnSecondCard(x, y);
        }
    }
    
    // Käännä ensimmäinen kortti
    private void turnFirstCard(int x, int y) {
        gameboard.getCard(x, y).turn();
        firstTurn = false;
        firstTurned = gameboard.getCard(x, y);
    }
    
    // Käännä toinen kortti
    private void turnSecondCard(int x, int y) {
        gameboard.getCard(x, y).turn();
        secondTurned = gameboard.getCard(x, y);
    }
    
    // Käännettyjen korttien tarkistus
    public void checkTurnedCards() {
        // Jos löytyy pari, kasvatetaan tulosta ja vuoroa, asetetaan kortit löydetyiksi
        // Jos löydetty useampi peräkkäin, kasvatetaan tulosta myös putken verran
        if (secondTurned != null) {
            if (firstTurned.same(secondTurned)) {
                pairFound();
                firstTurn = true;
            } //Jos ei löydy paria, nollataan putki, kasvatetaan vuoroa, käännetään kortit
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

    private void pairFound(){
        score++;
        score += streak;
        streak++;
        highestStreak(streak);
        turns++;
    }
    
    private void pairNotFound(){
        streak = 0;
        turns++;
    }
    
    private void highestStreak(int streak){
        if(streak>highestStreak){
            highestStreak = streak;
        }
    }
    
    // Tarkistetaan onko peli käynnissä eli onko pelissä vielä löytämättömiä kortteja
    public boolean playing() {
        if (!gameboard.allFound()) {
            return true;
        } else {
            return false;
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
