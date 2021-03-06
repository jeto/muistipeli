package GamelogicTests;

import Domain.Card;
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
    
    @Test
    public void turningTwoSameCards(){
        turnTwoFirstCards();
        engine.checkTurnedCards();
        assertEquals(true, engine.getGameboard().getCard(0, 0).found());
        assertEquals(true, engine.getGameboard().getCard(1, 0).found());
    }
    
    @Test
    public void scoreUpdatesAfterFindingPair(){
        turnTwoFirstCards();
        engine.checkTurnedCards();
        assertEquals(1, engine.getScore());
    }
    
    @Test
    public void scoreAndStreakUpdatesAfterFindingTwoPairsInARow(){
        turnTwoFirstCards();
        engine.checkTurnedCards();
        turnTwoLastCards();
        engine.checkTurnedCards();
        assertEquals(3, engine.getScore());
    }
    
    @Test
    public void streakDoesNotAffectScore(){
        // Jos välissä arvataan väärin, putki ei lisää pisteitä
        turnTwoLastCards();
        engine.checkTurnedCards();
        turnTwoDifferentCards();
        engine.checkTurnedCards();
        turnTwoFirstCards();
        engine.checkTurnedCards();
        assertEquals(2, engine.getScore());
    }
    
    @Test
    public void turnsUpdateAfterFindingPair(){
        turnTwoFirstCards();
        engine.checkTurnedCards();
        assertEquals(1, engine.getTurns());
    }
    
    @Test
    public void turnsUpdateAfterNotFindingPair(){
        turnTwoDifferentCards();
        engine.checkTurnedCards();
        assertEquals(1, engine.getTurns());
    }
    
    @Test
    public void scoreDoesNotUpdateAfterNotFindingPair(){
        turnTwoDifferentCards();
        engine.checkTurnedCards();
        assertEquals(0, engine.getScore());
    }
    
    // Korttipari
    private void turnTwoFirstCards(){
        engine.turnCard(0, 0);
        engine.turnCard(1, 0);
    }
    private void turnTwoLastCards(){
        engine.turnCard(3,3);
        engine.turnCard(2,3);
    }
    
    private void turnTwoDifferentCards(){
        engine.turnCard(0,0);
        engine.turnCard(1,1);
    }
    
    // Luo valmiin järjestetyn pelialustan valmiilla matriisilla

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
        cards = new ArrayList<Card>(16);
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
