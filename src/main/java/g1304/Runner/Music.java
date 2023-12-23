package g1304.Runner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class Music {
    private Clip soundTrack;

    public boolean isPlaying(){return soundTrack.isRunning();}


    public void loadSound(String sound) throws NullPointerException{
        try {
            String rootPath = new File(System.getProperty("user.dir")).getPath();
            String musicPath = rootPath + "/src/main/java/g1304/resources/" + sound;
            File musicFile = new File(musicPath);
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-25.0f);
            soundTrack = musicClip;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void start() {
        soundTrack.setMicrosecondPosition(0);
        soundTrack.start();
        soundTrack.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {soundTrack.stop();}
}
