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
    private int[] payersCounts = new int[]{0,0,0};
    private String nameActiveMelody = "Увертюра";
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
    
    public int getMaxPlayer(){
        int res = 0;
        for(int index=0; index < this.payersCounts.length; index++){
            if(this.payersCounts[index] > this.payersCounts[res])
                res = index;
        }
        return res+1;
    }
    
    public boolean makeStap(String name){
        this.countStaps++;
        boolean res = false;
        if(name.equalsIgnoreCase(this.nameActiveMelody)){
            this.payersCounts[activePlayer]++;
            res = true;
        }
        this.activePlayer = (this.activePlayer+1)%3;
        return res;
    }
    
    public String[] getVariants(){
        String[] variants = new String[4];
        int idxRight = random.nextInt(4);
        variants[idxRight] = this.nameActiveMelody;
        int count = 0;
        ArrayList variantsList = new ArrayList();
        variantsList.add(idxRight);
        int idxForVar = 0;
        while(true){
            if(count==3)
                break;
            int idx = random.nextInt(this.soundList.size());
            if(!variantsList.contains(idx)){
                if(idxForVar==idxRight)
                    idxForVar++;
                variants[idxForVar] = this.soundList.get(idx).getName();
                count++;
                idxForVar++;
            }
        }
        return variants;
    }
    
    public String getResult(){
        int res = 0;
        for(int index=0; index < this.payersCounts.length; index++){
            if(this.payersCounts[index] > this.payersCounts[res])
                res = index;
            else if(this.payersCounts[index] > this.payersCounts[res] && countStaps==9){
                return "Победителя нет. Игра закончена";
            } else if(this.payersCounts[index] > this.payersCounts[res]){
                return "Победителя нет.";
            }
        }
        return String.valueOf(res+1);
    }
    
    public int getActivePalyer(){
        return 1;
    }
}
