package eugene.game;

import static org.testng.Assert.*;
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
    
    @Test(enabled = false)
    public void testActivePlayer(){
        Game game =  new Game();
        game.loadSoudStore("soud-store");
        game.getVariants();
        game.makeStap("sjdfh");
        int res = game.getActivePlayer();
        assertEquals(1,res);
    }
    
    @Test
    public void testGetVariants(){
        Game game =  new Game();
        game.loadSoudStore("soud-store");
        String[] variants = game.getVariants();
        assertEquals(variants.length>0,true);
    }
    
    @Test
    public void testStringResult(){
        Game game =  new Game();
        game.loadSoudStore("soud-store");
        game.getVariants();
        game.start();
        game.makeStap("sjdfh");
        String result = game.getStringResult();
        assertEquals(result.indexOf("Игра активна")>=0,true);
    }
    
    @Test
    public void testStringResultNotActive(){
        Game game =  new Game();
        game.loadSoudStore("soud-store");
        game.stop();
        String result = game.getStringResult();
        assertEquals(result.indexOf("Игра не активна\n")>=0,true);
    }
}
