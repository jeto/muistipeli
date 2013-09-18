package GamelogicTests;

import Gamelogic.Card;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {
    private Card card1;
    private Card card1_2;
    private Card card2;
    
    public CardTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        card1 = new Card(1);
        card2 = new Card(2);
        card1_2 = new Card(1);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void faceDownWhenCreated(){
        assertEquals(false, card1.getFace());
    }
    
    @Test
    public void cardNotFoundWhenCreated(){
        assertEquals(false,card1.found());
    }
    
    @Test
    public void turningCard(){
        // Kortin kääntäminen kääntää oikeinpäin, kahdesti kääntäminen takaisin väärinpäin
        card1.turn();
        card2.turn();
        card2.turn();
        assertEquals(true, card1.getFace());
        assertEquals(false, card2.getFace());
    }
    
    @Test
    public void cardGetterReturnsCardID(){
        assertEquals(1, card1.getCard());
        assertEquals(2, card2.getCard());
    }
    
    @Test
    public void cardComparison(){
        // Saman ID korttien vertaaminen palauttaa true
        assertEquals(true, card1.same(card1_2));
    }
    
    @Test
    public void findingSameCards(){
        // Kahden saman kortin vertaaminen merkitsee molemmat löydetyiksi
        card1.same(card1_2);
        assertEquals(true, card1.found());
        assertEquals(true, card1_2.found());
    }
    
    @Test
    public void cardComparisonFails(){
        // Kahden eri ID kortin vertaaminen palauttaa false
        assertEquals(false, card1.same(card2));
    }
    
    
}
