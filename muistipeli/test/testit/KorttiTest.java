package testit;

import muistipeli.Kortti;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KorttiTest {
    
    public KorttiTest() {
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
    
    @Test
    public void kuvapuoliAlaspainLuotaessa(){
        Kortti kortti = new Kortti(1);
        assertEquals(false, kortti.getFace());
    }
    
    @Test
    public void kortinKaantaminen(){
        Kortti kortti = new Kortti(1);
//        assertEquals(false, kortti.getFace());
        kortti.turn();
        assertEquals(true, kortti.getFace());
        kortti.turn();
        assertEquals(false, kortti.getFace());
    }
    
    @Test
    public void kortinGetteri(){
        Kortti kortti1 = new Kortti(1);
        Kortti kortti2 = new Kortti(2);
        
        assertEquals(1, kortti1.getKortti());
        assertEquals(2, kortti2.getKortti());
    }
    
    @Test
    public void korttienVertaus(){
        Kortti kortti1 = new Kortti(1);
        Kortti kortti2 = new Kortti(1);
        assertEquals(true, kortti1.same(kortti2));
    }
    
    @Test
    public void korttienVertausFail(){
        Kortti kortti1 = new Kortti(1);
        Kortti kortti2 = new Kortti(2);
        assertEquals(false, kortti1.same(kortti2));
    }
}
