package g1304.Runner.Model;

import g1304.Runner.Model.Helpers.Collider;
import g1304.Runner.Model.MovingObjects.Position;
import g1304.Runner.Model.MovingObjects.Wall;
import g1304.Runner.Model.MovingObjects.Monsters.Slime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class MovementControllerTest {

    private MovementController movementController;
    private Collider collider;
    private List<Wall> walls;
    private List<Slime> slimes;

    @BeforeEach
    void setUp() {
        collider = mock(Collider.class);
        walls = Arrays.asList(mock(Wall.class), mock(Wall.class));
        slimes = Arrays.asList(mock(Slime.class), mock(Slime.class));

        movementController = new MovementController(walls, slimes);
        movementController.collider = collider;
    }

    @Test
    void testCanMoveUp() {
        Position position = new Position(0, 16);

        // Mock behavior for collider methods
        when(collider.Collide(position, walls)).thenReturn(false);
        when(collider.CollideWithSlime(position, slimes)).thenReturn(false);

        assertTrue(movementController.CanMoveUp(position));
    }

    @Test
    void testCanMoveDown() {
        Position position = new Position(0, 0);

        // Mock behavior for collider methods
        when(collider.Collide(position, walls)).thenReturn(false);
        when(collider.CollideWithSlime(position, slimes)).thenReturn(false);

        assertTrue(movementController.CanMoveDown(position));
    }

    @Test
    void testCanMoveLeft() {
        Position position = new Position(16, 0);

        // Mock behavior for collider methods
        when(collider.Collide(position, walls)).thenReturn(false);
        when(collider.CollideWithSlime(position, slimes)).thenReturn(false);

        assertTrue(movementController.CanMoveLeft(position));
    }

    @Test
    void testCanMoveRight() {
        Position position = new Position(0, 0);

        // Mock behavior for collider methods
        when(collider.Collide(position, walls)).thenReturn(false);
        when(collider.CollideWithSlime(position, slimes)).thenReturn(false);

        assertTrue(movementController.CanMoveRight(position));
    }

    // Additional tests for scenarios where movement is not possible
    // ...

}