package eugene.game;

import eugene.game.soudthread.SoudThread;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**
 * класс игры
 *
 * @author Eugene
 */
public class Game {
    private boolean flagStarted;
    private Random random = new Random();
    private ArrayList<File> soundList;
    private Thread soundThread;

    public Game() {

    }

    public void start() {
        this.flagStarted = true;
    }

    public void stop() {
        this.flagStarted = false;
    }

    public boolean isStarted() {
        return this.flagStarted;
    }

    public void loadSoudStore(String path) {
        File storeDir = new File(path);
        this.soundList = new ArrayList<>();
        for (File item : storeDir.listFiles()) {
            if (!".".equals(item.getName()) && !"..".equals(item.getName())) {
                this.soundList.add(item);
            }
        }
    }

    public void playSound() {
        try {
            File audio = this.soundList.get(random.nextInt(this.soundList.size()));
            this.soundThread = new SoudThread(audio);
            this.soundThread.start();
        } catch (Exception ex) {

        }
    }
    
    
}
