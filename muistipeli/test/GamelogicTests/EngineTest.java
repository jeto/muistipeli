package GamelogicTests;

import Gamelogic.Card;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Gamelogic.Engine;
import java.util.ArrayList;

public class EngineTest {
    private Card[][] matrix;
    private ArrayList<Card> cards;
    private Engine engine;
    
    public EngineTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        createCards();
        engine = new Engine(matrix);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void turningTurnsCard(){
        engine.turnCard(1, 1);
        assertEquals(true, engine.getGameboard().getCard(1, 1).getFace());
    }
    
//    @Test
//    public void turningTwoSameCards(){
//        engine.turnCard(0, 0);
//        engine.turnCard(1,0);
//        assertEquals(true, engine.getGameboard().getCard(0, 0).found());
//        assertEquals(true, engine.getGameboard().getCard(0, 1).found());
//    }
    
    // Luo valmiin pelialustan valmiilla matriisilla
    
    private void createMatrix(){
        int i = 0;
        matrix = new Card[4][4];
        for (int row = 0; row < 4; row++) {
            for (int column = 0; column < 4; column++) {
                matrix[row][column] = cards.get(i);
                i++;
            }
        }
    }
    private void createCards() {
        cards = new ArrayList<>(16);
        for (int i = 0; i < 8; i++) {
            Card kortti;
            kortti = new Card(i);
            cards.add(kortti);
            kortti = new Card(i);
            cards.add(kortti);
        }
        createMatrix();
    }
}
