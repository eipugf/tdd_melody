package eugene.game.soudthread;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Eugene
 */
public class SoudThread extends Thread {
    private final File audio;
    private final int LENGTH_PLAYING = 10;

    public SoudThread(File audio) {
        if(audio == null)
            throw new IllegalArgumentException("audio = null!");
        this.audio = audio;
    }

    @Override
    public void run() {
        try {
            AudioInputStream ais = AudioSystem.getAudioInputStream(audio);
            Clip clip = AudioSystem.getClip();
            clip.open(ais);
            clip.setFramePosition(0);
            clip.start();
            Thread.sleep(this.LENGTH_PLAYING);
        } catch (Exception ex) {

        }
    }
}
