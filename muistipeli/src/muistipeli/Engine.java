package muistipeli;

public class Engine {

    private boolean firstTurn;
    private Card turned;
    private int turns;
    private int score;
    private Pelialusta alusta;

    public Engine(int height, int width) {
        alusta = new Pelialusta(height, width);
        firstTurn = true;
        turns = 0;
        score = 0;
    }

    public void turnCard(int x, int y) {
        // Tarkistetaan käännetäänkö ensimmäistä vai toista korttia
        if (firstTurn && alusta.getCard(x, y) != null) {
            firstTurn = false;
            turned = alusta.getCard(x, y);
        } else if (turned != null && alusta.getCard(x, y) != null) {
            // Jos löytyy pari, kasvatetaan tulosta, poistetaan pari matriisista
            if (turned.same(alusta.getCard(x, y))) {
                score++;
                turns++;
                firstTurn = true;
            }


            turned = null;
        }

    }
}
