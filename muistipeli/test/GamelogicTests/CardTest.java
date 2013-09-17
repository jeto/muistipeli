package GamelogicTests;

import Gamelogic.Card;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {
    
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
    }
    
    @After
    public void tearDown() {
    }
    
//    @Test
//    public void kuvapuoliAlaspainLuotaessa(){
//        Card kortti = new Card(1);
//        assertEquals(false, kortti.getFace());
//    }
    
//    @Test
//    public void kortinKaantaminen(){
//        Card kortti = new Card(1);
////        assertEquals(false, kortti.getFace());
//        kortti.turn();
//        assertEquals(true, kortti.getFace());
//        kortti.turn();
//        assertEquals(false, kortti.getFace());
//    }
    
    @Test
    public void cardGetter(){
        Card kortti1 = new Card(1);
        Card kortti2 = new Card(2);
        
        assertEquals(1, kortti1.getCard());
        assertEquals(2, kortti2.getCard());
    }
    
    @Test
    public void cardComparison(){
        Card kortti1 = new Card(1);
        Card kortti2 = new Card(1);
        assertEquals(true, kortti1.same(kortti2));
    }
    
    @Test
    public void cardComparisonFails(){
        Card kortti1 = new Card(1);
        Card kortti2 = new Card(2);
        assertEquals(false, kortti1.same(kortti2));
    }
}
