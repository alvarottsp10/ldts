package g1304.Runner.Model.Builders;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import g1304.Runner.Model.Builders.GameMap;
import g1304.Runner.Model.MovingObjects.MainCharacter;
import g1304.Runner.Model.MovingObjects.Monsters.Slime;
import g1304.Runner.Model.MovingObjects.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameMapTest {

    private GameMap gameMap;

    @BeforeEach
    public void setUp() {
        gameMap = new GameMap(1);
    }

    @Test
    public void testInitialization() {
        assertNotNull(gameMap);
        assertEquals(1, gameMap.level);
        assertNotNull(gameMap.slimes);
        assertNotNull(gameMap.walls);
        assertNull(gameMap.mainCharacter);
        assertNull(gameMap.slimeController);
    }

    @Test
    public void testGetWalls() {
        List<Wall> walls = gameMap.GetWalls();
        assertNotNull(walls);
        assertEquals(0, walls.size());
    }

    @Test
    public void testReadElements_Level1Map() {
        gameMap.ReadElements();
        assertNotNull(gameMap.GetWalls());
        assertFalse(gameMap.allSlimesDied());
    }

    @Test
    public void testReadElements_Level2Map() {
        gameMap.level = 2;
        gameMap.ReadElements();
        assertNotNull(gameMap.GetWalls());
    }

    @Test
    public void testReadElements_Level3Map() {
        gameMap.level = 3;
        gameMap.ReadElements();
        assertNotNull(gameMap.GetWalls());

    }



}