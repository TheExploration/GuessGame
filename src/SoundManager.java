
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class SoundManager {

    public SoundManager() {

    }

    public void playSFX(String filename) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
        String currentDirectory = System.getProperty("user.dir");
        String filePath = currentDirectory + "/" + filename;

        File file = new File(filePath);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }

}
