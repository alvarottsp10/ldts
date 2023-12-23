package g1304.Runner;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MusicTest {

    private Music music;

    @BeforeEach
    public void setUp() {
        music = new Music();
    }

    @Test
    public void testLoadSound() {
        try {
            music.loadSound("CeltaIsraelita.wav");
            assertNotNull(music.getSoundTrack());
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testStartAndStop() {
        try {
            music.loadSound("CeltaIsraelita.wav");
            music.start();
            assertTrue(music.isPlaying());
            music.stop();
            assertFalse(music.isPlaying());
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}