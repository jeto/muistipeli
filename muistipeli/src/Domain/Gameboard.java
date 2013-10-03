package Domain;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Gameboard alustaa pelialustan luomalla kortit ja asettamalla ne matriisiin.
 * 
 * @author Jere Toivonen
 */
public class Gameboard {
    /**
     * Korttien määrä.
     */
    private int size;
    /**
     * Kentän korkeus.
     */
    private int height;
    /**
     * Kentän leveys.
     */
    private int width;
    /**
     * Lista johon kortit luodaan ja jossa ne sekoitetaan.
     */
    private ArrayList<Card> cards;
    /**
     * Matriisi johon kortit asetetaan sekoitettuina.
     */
    private Card[][] matrix;

    /** Alustaa pelialustan konstruktorissa annetulla kentän korkeudella ja leveydellä.
     * Tarkistetaan, että annetulla koolla kentälle tulee parillinen määrä kortteja
     * ja että niitä on oikea määrä (4-30 korttia) jonka jälkeen luo kortit.
     * @param width Kentän leveys
     * @param height Kentän korkeus
     */
    public Gameboard(int width, int height) {
        this.size = height * width;
        if (width < 2 || height < 2) {
            throw new IllegalArgumentException("Kentän minimikoko on 2x2");
        } else if (width > 6 || height > 5 || size > 30) {
            throw new IllegalArgumentException("Kentän maksimikoko on 5x6 tai 15 paria!");
        } else if (size % 2 != 0) {
            throw new IllegalArgumentException("Kentällä tulee olla parillinen määrä kortteja!");
        }
        this.height = height;
        this.width = width;
        cards = new ArrayList<Card>(size);
        createCards();
    }

    /**
     * Luo valmiin esitäytetyn järjestetyn pelialustan testausta varten.
     * @param matrix Esitäytetty järjestetty matriisi testausta varten.
     */
    public Gameboard(Card[][] matrix) {
        this.matrix = matrix;
    }

    /**
     * Luo korttiparit listaan.
     * Sekoittaa kortit ja asettaa ne matriisiin.
     */
    private void createCards() {
        for (int i = 0; i < size / 2; i++) {
            Card kortti;
            kortti = new Card(i);
            cards.add(kortti);
            kortti = new Card(i);
            cards.add(kortti);
        }
        shuffle();
        createMatrix();
    }

    /**
     * Sekoittaa korttilistan.
     * @see Collections
     */
    private void shuffle() {
        if (cards.isEmpty()) {
            throw new IllegalArgumentException("Kortteja ei ole luotu!");
        }
        Collections.shuffle(cards);
    }

    /**
     * Asettaa kortit matriisiin.
     */
    public void createMatrix() {
        int i = 0;
        matrix = new Card[height][width];
        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                matrix[row][column] = cards.get(i);
                i++;
            }
        }
    }

    public Card[][] getMatrix() {
        return matrix;
    }

    public Card getCard(int x, int y) {
        return matrix[y][x];
    }

    public int getSize() {
        return cards.size();
    }
    
    /**
     * Tarkistaa onko kaikki kortit löydetty.
     * @return Palauttaa true, jos kaikki kortit on löydetty, muuten false.
     */
    public boolean allFound(){
        for (Card card : cards) {
            if(!card.found()){
                return false;
            }
        }
        return true;
    }
}
