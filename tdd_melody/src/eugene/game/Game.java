package eugene.game;

import eugene.game.soudthread.SoudThread;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * класс игры
 * @author Eugene
 */
public class Game {
    private boolean flagStarted;
    private int coutFiles = 10;
    private Random random = new Random();
    private ArrayList<File> soundList;
    private Thread soundThread;
    
    public Game(){
    
    }
    
    public void start(){
        this.flagStarted = true;
    }
    
    public void stop(){
        this.flagStarted = false;
    }
    
    public boolean isStarted(){
        return this.flagStarted;
    }
    
    public void playSound(){
        File audio = this.soundList.get(random.nextInt(coutFiles));
        this.soundThread = new SoudThread(audio);
    }
}
