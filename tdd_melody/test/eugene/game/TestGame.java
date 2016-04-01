package eugene.game;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestGame {

    @Test(enabled = false)
    public void testStarGame() {
        Game game = new Game();
        game.start();
        assertEquals(game.isStarted(), true);
    }

    @Test(enabled = false)
    public void testStopGame() {
        Game game = new Game();
        game.stop();
        assertEquals(game.isStarted(), false);
    }

    @Test(enabled = false)
    public void testPlaySound() throws InterruptedException {
        Game game = new Game();
        game.loadSoudStore("soud-store");
        game.playSound();
        Thread.sleep(60 * 1000);
    }

    @Test(enabled = false)
    public void testGetActivePlayer() {
        Game game = new Game();
        int numPlayer = game.getActivePalyer();
        assertEquals(numPlayer, 1);
    }

    @Test(enabled = false)
    public void testMakeStap() {
        Game game = new Game();
        boolean res = game.makeStap("Увертюра");
        assertEquals(res, true);
    }
    
    @Test
    public void testActivePlayer(){
        Game game =  new Game();
        game.loadSoudStore("soud-store");
        game.getVariants();
        game.makeStap("sjdfh");
        int res = game.getActivePlayer();
        assertEquals(1,res);
    }
}
