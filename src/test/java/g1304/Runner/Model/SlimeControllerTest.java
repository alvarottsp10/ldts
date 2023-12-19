package g1304.Runner.Model;

import g1304.Runner.Model.Helpers.Ruler;
import g1304.Runner.Model.MovingObjects.MainCharacter;
import g1304.Runner.Model.MovingObjects.Position;
import g1304.Runner.Model.MovingObjects.Monsters.Slime;
import g1304.Runner.Model.MovingObjects.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SlimeControllerTest {

    private SlimeController slimeController;
    private MovementController movementController;
    private MainCharacter mainCharacter;
    private Ruler ruler;
    private List<Wall> walls;
    private List<Slime> slimes;

    @BeforeEach
    void setUp() {
        movementController = mock(MovementController.class);
        mainCharacter = mock(MainCharacter.class);
        ruler = mock(Ruler.class);
        walls = Arrays.asList(mock(Wall.class), mock(Wall.class));
        slimes = Arrays.asList(mock(Slime.class), mock(Slime.class));

        slimeController = new SlimeController(walls, slimes, mainCharacter);
        slimeController.movementController = movementController;
        slimeController.ruler = ruler;
    }

    @Test
    void testRun() throws InterruptedException {
        // Set up mocks for the run method
        when(ruler.getDistance(Mockito.any(), Mockito.any())).thenReturn(150);
        when(ruler.getDistance(Mockito.any(), Mockito.any())).thenReturn(170);

        CountDownLatch latch = new CountDownLatch(1);

        // Start the SlimeController thread
        new Thread(() -> {
            slimeController.run();
            latch.countDown();
        }).start();

        // Allow some time for the SlimeController thread to execute
        latch.await(1, TimeUnit.SECONDS);

        // Assert your expectations based on the mocks and the behavior of the run method
        // ...

        // Stop the SlimeController thread
        slimeController.stopSlimes();
    }

    // Additional tests for other methods in SlimeController
    // ...

}