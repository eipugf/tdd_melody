package eugene.game;

import javafx.stage.Stage;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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
    
    /**
     * Не должно быть исключения, файл звуковой не найден
     */
    @Test
    public void testPlaySound(){
        Game game = new Game();
        game.playSound();
    }
}
