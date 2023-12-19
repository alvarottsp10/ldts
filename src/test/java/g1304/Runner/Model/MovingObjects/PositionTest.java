package g1304.Runner.Model.MovingObjects;

import static org.junit.jupiter.api.Assertions.*;
import g1304.Runner.Model.MovingObjects.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
class PositionTest {
    @Test
    public void getXShouldReturnInitializedX() {
        Position position = new Position(5, 10);
        assertEquals(5, position.getX());
    }

    @Test
    public void getYShouldReturnInitializedY() {
        Position position = new Position(5, 10);
        assertEquals(10, position.getY());
    }

    @Test
    public void addToXShouldIncrementX() {
        Position position = new Position(5, 10);
        position.addToX(3);
        assertEquals(8, position.getX());
    }

    @Test
    public void addToYShouldIncrementY() {
        Position position = new Position(5, 10);
        position.addToY(2);
        assertEquals(12, position.getY());
    }

}