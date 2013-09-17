package GamelogicTests;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Gamelogic.Gameboard;
import java.lang.reflect.Field;


public class GameboardTest {
    
    public GameboardTest() {
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
    public void rightAmountOfCards2x2() throws Exception {
        assertEquals(4, createGameBoard(2,2).getSize()); // 2 Paria, 4 korttia
    }
    @Test
    public void rightAmountOfCards2x3() throws Exception {
        assertEquals(6, createGameBoard(2,3).getSize()); // 3 Paria, 6 korttia
    }
    @Test
    public void rightAmountOfCards4x4() throws Exception {
        assertEquals(16, createGameBoard(4,4).getSize()); // 8 Paria, 16 korttia
    }
    @Test
    public void rightAmountOfCards5x6() throws Exception {
        assertEquals(30, createGameBoard(6,5).getSize()); // 15 Paria, 30 korttia
    }
    @Test
    public void matrixSize2x2() throws Exception{
        assertEquals(5, createGameBoard(6,5).getMatrix().length); // 6 Riviä matriisissa
    }
    
    // Pelialustan luomismetodi
    private Gameboard createGameBoard(int x, int y){
        return new Gameboard(x, y);
    }
}
