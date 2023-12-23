package g1304.Runner.Model.Builders;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import g1304.Runner.Model.MovingObjects.Wall;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class WallViewerTest {



    @Test
    public void testDrawWall() {
        WallViewer wallViewer = new WallViewer();

        Wall mockWall = new Wall(0, 0);
        TextGraphics mockGraphics = Mockito.mock(TextGraphics.class);

        wallViewer.drawWall(mockWall, mockGraphics);

        Mockito.verify(mockGraphics, Mockito.times(256)).fillRectangle(
                Mockito.any(TerminalPosition.class),
                Mockito.any(TerminalSize.class),
                Mockito.anyChar()
        );
    }
}