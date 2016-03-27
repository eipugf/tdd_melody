package eugene.game;

/**
 * класс игры
 * @author Eugene
 */
public class Game {
    private boolean flagStarted;
    
    public Game(){
    
    }
    
    public void start(){
    
    }
    
    public void stop(){
        this.flagStarted = false;
    }
    
    public boolean isStarted(){
        return this.flagStarted;
    }
}
