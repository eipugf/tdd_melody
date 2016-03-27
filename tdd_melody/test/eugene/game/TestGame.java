package eugene.game;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


/**
 * тест игры
 * @author Eugene
 */
public class TestGame {
    
    public TestGame(){}
    
    @BeforeClass
    public void setUp(){
    
    }
    
    @Test(enabled = false)
    public void testStarGame(){
        Game game = new Game();
        game.start();
        assertEquals(game.isStarted(), true);
    }
    
    @Test(enabled = false)
    public void testStopGame(){
        Game game = new Game();
        game.stop();
        assertEquals(game.isStarted(), false);
    }
    
    @Test
    public void testPlaySound(){
        Game game = new Game();
        game.playSound();
    }
}
