// Pelialusta alustaa pelin luomalla kortit ja asettamalla ne matriisiin.
package Gamelogic;

import java.util.ArrayList;
import java.util.Collections;

public class Gameboard {
    // Korttien määrä

    private int size;
    //Kentän korkeus & leveys
    private int height;
    private int width;
    // Korteille lista
    private ArrayList<Card> cards;
    // Korteille matriisi
    private Card[][] matrix;

    /* Alustetaan pelialusta konstruktorissa antamalla kentän korkeus ja leveys
     * Tarkistetaan, että annetulla koolla kentällä on parillinen määrä kortteja
     * ja että niitä on oikea määrä (4-30 korttia).
     * Luodaan kortit
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
        cards = new ArrayList<>(size);
        createCards();
    }

    // Luodaan valmis lauta testejä varten.
    public Gameboard(Card[][] matrix) {
        this.matrix = matrix;
    }

    // Luodaan korttiparit ja sekoitetaan lista
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

    // Sekoitetaan kortit
    private void shuffle() {
        if (cards.isEmpty()) {
            throw new IllegalArgumentException("Kortteja ei ole luotu!");
        }
        Collections.shuffle(cards);
    }

    // Asetetaan kortit matriisiin
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

    // Matriisille getteri
    public Card[][] getMatrix() {
        return matrix;
    }

//    public void removeFromMatrix(int x, int y){
//        matrix[y][x] = null;
//    }
    // Matriisista kortin getteri
    public Card getCard(int x, int y) {
        return matrix[y][x];
    }

    //Testiprinttejä
//    public void printCards(){
//        for (Card kortti : cards) {
//            System.out.println(kortti.getCard());
//        }
//    }
    public void printMatrix() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!matrix[i][j].getFace() && !matrix[i][j].found()) {
                    System.out.print("[] ");
                } else if (matrix[i][j].found()) {
                    System.out.print("   ");
                } else {
                    if (matrix[i][j].getCard() < 10) {
                        System.out.print(matrix[i][j].getCard() + "  ");
                    } else {
                        System.out.print(matrix[i][j].getCard() + " ");
                    }
                }
            }
            System.out.println("");
        }
    }

    // Korttien määrälle getteri
    public int getSize() {
        return cards.size();
    }
    public boolean allFound(){
        for (Card card : cards) {
            if(!card.found()){
                return false;
            }
        }
        return true;
    }
}
