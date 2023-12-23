package g1304.Runner.Model.Helpers;

import g1304.Runner.Model.MovingObjects.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RulerTest {

    @Test
    public void testGetDistance() {
        Ruler ruler = new Ruler();


        Position pos1 = new Position(0, 0);
        Position pos2 = new Position(0, 0);
        assertEquals(0, ruler.getDistance(pos1, pos2));

        pos1 = new Position(1, 2);
        pos2 = new Position(4, 6);
        assertEquals(5, ruler.getDistance(pos1, pos2));


        pos1 = new Position(-1, -2);
        pos2 = new Position(-4, -6);
        assertEquals(8, ruler.getDistance(pos1, pos2));

        pos1 = new Position(-1, 2);
        pos2 = new Position(4, -6);
        assertEquals(9, ruler.getDistance(pos1, pos2));
    }
}