/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GamelogicTests;

import Gamelogic.Score;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jere
 */
public class ScoreTest {
    private Score score;
    
    public ScoreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        score = new Score();
    }
    
    @Test
    public void scoreInitializedZero(){
        assertEquals(0, score.getScore());
    }
    
    @Test
    public void scoreIncreases(){
        score.addScore();
        assertEquals(1, score.getScore());
    }
    
    @Test
    public void streakIncreasesScore(){
        score.addScore();
        score.addStreak();
        score.addScore();
        assertEquals(3, score.getScore());
    }
}