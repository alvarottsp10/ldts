package g1304.Runner.Model.MovingObjects.Monsters;

import g1304.Runner.Model.MovingObjects.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SlimeTest {

    @Test
    public void testConstructorAndGetters() {
        Position position = new Position(10, 20);
        Slime slime = new Slime(position, 3);

        assertEquals(10, slime.getX());
        assertEquals(20, slime.getY());
        assertEquals(position, slime.getPosition());
        assertEquals(3, slime.slimeDamage());
        assertFalse(slime.isDead());
    }

    @Test
    public void testSetAndGetLastMovement() {
        Slime slime = new Slime(new Position(0, 0), 1);

        slime.setLastMovement("Left");
        assertEquals("Left", slime.getLastMovement());

        slime.setLastMovement("Up");
        assertEquals("Up", slime.getLastMovement());
    }


    @Test
    public void testIsDead() {
        Slime slime = new Slime(new Position(0, 0), 1);

        assertFalse(slime.isDead());

        slime.DamageSlime(1);
        assertFalse(slime.isDead());

        slime.DamageSlime(1);
        assertTrue(slime.isDead());
    }
}