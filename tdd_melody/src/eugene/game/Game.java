package eugene.game;

import eugene.game.soudthread.SoudThread;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
    private int[] payersCounts = new int[]{0, 0, 0};
    private String nameActiveMelody;
    private int activeIndex = 0;
    private int countStaps = 0;
    private int activePlayer = 0;

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
    
    public void soundStop(){
        if(this.soundThread!=null && !this.soundThread.isInterrupted())
        {
            soundThread.interrupt();
        }
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
            if(this.soundThread!=null){
                this.soundThread.interrupt();
                this.soundThread = null;
            }
            File audio = this.soundList.get(this.activeIndex);
            this.soundThread = new SoudThread(audio);
            this.soundThread.start();
        } catch (Exception ex) {

        }
    }

    public int getMaxPlayer() {
        int res = 0;
        for (int index = 0; index < this.payersCounts.length; index++) {
            if (this.payersCounts[index] > this.payersCounts[res]) {
                res = index;
            }
        }
        return res + 1;
    }

    public boolean makeStap(String name) {
        this.countStaps++;
        boolean res = false;
        if (name.equalsIgnoreCase(this.nameActiveMelody.replace(".wav",""))) {
            this.payersCounts[activePlayer]++;
            res = true;
        }
        this.activePlayer = (this.activePlayer + 1) % 3;
        return res;
    }

    public String[] getVariants() {
        this.activeIndex = random.nextInt(this.soundList.size());
        this.nameActiveMelody = this.soundList.get(activeIndex).getName();
        String[] variants = new String[4];
        int idxRight = random.nextInt(4);
        variants[idxRight] = this.nameActiveMelody;
        int count = 0;
        ArrayList variantsList = new ArrayList();
        variantsList.add(this.activeIndex);
        int idxForVar = 0;
        while (true) {
            if (count == 3) {
                break;
            }
            int idx = random.nextInt(this.soundList.size());
            if (!variantsList.contains(idx)) {
                if (idxForVar == idxRight) {
                    idxForVar++;
                }
                variants[idxForVar] = this.soundList.get(idx).getName();
                count++;
                idxForVar++;
            }
        }
        return variants;
    }

    public String getResult() {
        int res = 0;
        for (int index = 0; index < this.payersCounts.length; index++) {
            if (this.payersCounts[index] > this.payersCounts[res]) {
                res = index;
            } else if (this.payersCounts[index] > this.payersCounts[res] && countStaps == 9) {
                return "Победителя нет. Игра закончена";
            } else if (this.payersCounts[index] > this.payersCounts[res]) {
                return "Победителя нет.";
            }
        }
        return "Побеждает "+String.valueOf(res + 1);
    }

    public int getActivePalyer() {
        return this.activePlayer;
    }

    public String getStringResult() {
        StringBuilder res = new StringBuilder();
        if (this.countStaps != 9) {
            if (this.isStarted()) {
                res.append("Игра активна");
            } else {
                res.append("Игра не активна\n");
            }
            res.append("\nАктивен игрок - ").append(this.activePlayer + 1);
        } else if(countStaps==9) {
            this.stop();
            this.soundStop();
            res.append("Игра закончена");
            res.append('\n').append(this.getResult());
            return res.toString();
        }
        res.append("\n\nИгрок 1 угадал - ").append(this.payersCounts[0]);
        res.append("\nИгрок 2 угадал - ").append(this.payersCounts[1]);
        res.append("\nИгрок 3 угадал - ").append(this.payersCounts[2]);
        return res.toString();
    }

    int getActivePlayer() {
        return this.activePlayer;
    }
    
    
}
