package testit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import muistipeli.Pelialusta;
import java.lang.reflect.Field;


public class PelialustaTest {
    
    public PelialustaTest() {
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
    public void oikeaMaaraKortteja() throws Exception {
        Pelialusta alusta = new Pelialusta(2,2); // 2 Paria, 4 korttia
        assertEquals(4, alusta.getSize());
    }
    @Test
    public void oikeaMaaraKortteja2() throws Exception {
        Pelialusta alusta = new Pelialusta(2,3); // 3 Paria, 6 korttia
        assertEquals(6, alusta.getSize());
    }
    @Test
    public void oikeaMaaraKortteja3() throws Exception {
        Pelialusta alusta = new Pelialusta(4,4); // 8 Paria, 16 korttia
        assertEquals(16, alusta.getSize());
    }
    @Test
    public void oikeaMaaraKortteja4() throws Exception {
        Pelialusta alusta = new Pelialusta(5,6); // 3 Paria, 6 korttia
        assertEquals(6, alusta.getSize());
    }

}
