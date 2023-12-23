package g1304.Runner.Viewer;

import static org.mockito.Mockito.*;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import g1304.Runner.Model.Builders.GameMap;
import g1304.Runner.Model.MovingObjects.MainCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class GameViewerTest {

    private TerminalScreen mockScreen;
    private TextGraphics mockGraphics;
    private MainCharacter mockMainCharacter;
    private GameMap mockGameMap;
    private GameViewer gameViewer;

    @BeforeEach
    void setUp() {
        mockScreen = mock(TerminalScreen.class);
        mockGraphics = mock(TextGraphics.class);
        mockMainCharacter = mock(MainCharacter.class);
        mockGameMap = mock(GameMap.class);

        gameViewer = new GameViewer();
        gameViewer.screen = mockScreen;
        gameViewer.graphics = mockGraphics;
        gameViewer.mainCharacter = mockMainCharacter;
        gameViewer.map = mockGameMap;
    }



        @Test
        void testDraw() throws IOException {

            when(mockMainCharacter.getCurrentSprite()).thenReturn(new String[]{"###", "XXX", "YYY"});
            when(mockMainCharacter.getMainCharacterAttackUpModel()).thenReturn(new String[]{"###", "HHH", "%%%"}); // Additional sprite for testing

            doAnswer(invocation -> {
                TerminalPosition position = invocation.getArgument(0);
                TerminalSize size = invocation.getArgument(1);
                char character = invocation.getArgument(2);

                return null;
            }).when(mockGraphics).fillRectangle(any(TerminalPosition.class), any(TerminalSize.class), anyChar());

            gameViewer.draw();

            verify(mockScreen).clear();
            verify(mockGameMap).Draw(mockGraphics);

            verify(mockGraphics, times(3)).fillRectangle(any(TerminalPosition.class), any(TerminalSize.class), anyChar());
            verify(mockGraphics, times(3)).setBackgroundColor(any(TextColor.class));

            verify(mockGraphics, times(3)).fillRectangle(any(TerminalPosition.class), any(TerminalSize.class), anyChar());
            verify(mockGraphics, times(2)).setBackgroundColor(any(TextColor.class));

            verify(mockScreen, times(2)).refresh();
        }
    }
