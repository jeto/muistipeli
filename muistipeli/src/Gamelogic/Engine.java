package Gamelogic;

public class Engine {
    // Ensimmäisen kortin kääntäminen

    private boolean firstTurn;
    private Card firstTurned;
    private Card secondTurned;
    // Kääntövuorot, pisteet ja peräkkäin löydetyt
    private int turns;
    private int score;
    private int streak;
    private Gameboard gameboard;

    public Engine(int height, int width) {
        gameboard = new Gameboard(height, width);
        firstTurn = true;
        turns = 0;
        score = 0;
    }

    // Engine valmiilla matriisilla testausta varten
    public Engine(Card[][] matrix) {
        gameboard = new Gameboard(matrix);
        firstTurn = true;
        turns = 0;
        score = 0;
    }

    public void turnCard(int x, int y) {
        // Tarkistetaan käännetäänkö ensimmäistä vai toista korttia
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
                score++;
                score += streak;
                turns++;
                streak++;
                firstTurn = true;
            } //Jos ei löydy paria, nollataan putki, kasvatetaan vuoroa, käännetään kortit
            else {
                streak = 0;
                turns++;
                firstTurn = true;
                secondTurned.turn();
                firstTurned.turn();
            }
            firstTurned = null;
            secondTurned = null;
        }
    }

    public Gameboard getGameboard() {
        return gameboard;
    }

    public boolean playing() {
        if (!gameboard.allFound()) {
            return true;
        } else {
            return false;
        }
    }

    public int getScore() {
        return score;
    }

    public int getTurns() {
        return turns;
    }
}
