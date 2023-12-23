package g1304.Runner.Model.MovingObjects;

import g1304.Runner.Model.MovingObjects.MainCharacter;
import g1304.Runner.Model.MovingObjects.Position;
import g1304.Runner.Model.MovingObjects.Wall;
import g1304.Runner.Model.MovingObjects.Monsters.Slime;
import g1304.Runner.Model.MovementController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class MainCharacterTest {

    private MainCharacter mainCharacter;
    private List<Wall> walls;
    private List<Slime> slimes;

    @BeforeEach
    void setUp() {
        walls = new ArrayList<>();
        slimes = new ArrayList<>();
        mainCharacter = new MainCharacter(0, 0, walls, slimes);
    }

    @Test
    void testInitialValues() {
        assertEquals(5, mainCharacter.getLives());
        assertNotNull(mainCharacter.getPosition());
        assertFalse(mainCharacter.isAttackingUp());
        assertFalse(mainCharacter.isAttackingDown());
        assertFalse(mainCharacter.isAttackingLeft());
        assertFalse(mainCharacter.isAttackingRight());
        assertNotNull(mainCharacter.getCurrentSprite());
    }

    @Test
    void testMoveHeroUp() {
        Position initialPosition = mainCharacter.getPosition();
        mainCharacter.MoveHeroUp();
        assertEquals(initialPosition.getY(), mainCharacter.HeroY());
    }

    @Test
    void testSetAttackingUp() {
        mainCharacter.setAttackingUp(true);
        assertTrue(mainCharacter.isAttackingUp());
    }


    @Test
    void testDamagePlayer() {
        mainCharacter.DamagePlayer(2);
        assertEquals(3, mainCharacter.getLives());
    }

}