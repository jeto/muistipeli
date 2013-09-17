package Gamelogic;

public class Engine {
    // Ensimmäisen kortin kääntäminen

    private boolean firstTurn;
    private Card turned;
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
    public Engine(Card[][] matrix){
        gameboard = new Gameboard(matrix);
        firstTurn = true;
        turns = 0;
        score = 0;
    }

    public void turnCard(int x, int y) {
        // Tarkistetaan käännetäänkö ensimmäistä vai toista korttia
        if (firstTurn && !gameboard.getCard(x, y).found()) {
            turnFirstCard(x, y);
        } else if (turned != null && gameboard.getCard(x, y) != turned && !gameboard.getCard(x, y).found()) {
            turnSecondCard(x, y);
        }
    }

    private void turnFirstCard(int x, int y) {
        gameboard.getCard(x, y).turn();
        firstTurn = false;
        turned = gameboard.getCard(x, y);
    }

    private void turnSecondCard(int x, int y) {
        gameboard.getCard(x, y).turn();
        // Jos löytyy pari, kasvatetaan tulosta ja vuoroa, asetetaan kortit löydetyiksi
        // Jos löydetty useampi peräkkäin, kasvatetaan tulosta myös putken verran
        if (turned.same(gameboard.getCard(x, y))) {
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
            gameboard.getCard(x, y).turn();
            turned.turn();
        }
        turned = null;
    }
    
    public Gameboard getGameboard(){
        return gameboard;
    }
}
