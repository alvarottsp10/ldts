package g1304.Runner.Viewer;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import g1304.Runner.Controller.GameOverKeyProcessor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

class GameOverViewerTest {

    @Mock
    private TerminalScreen mockScreen;

    @Mock
    private GameOverKeyProcessor mockGameOverKeyProcessor;

    @Mock
    private TextGraphics mockGraphics;

    private GameOverViewer gameOverViewer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        gameOverViewer = new GameOverViewer(mockGameOverKeyProcessor, mockScreen, mockGraphics);
    }

    @Test
    void testDrawMenu() throws IOException {

        when(mockGameOverKeyProcessor.GetOption()).thenReturn("Restart Game");

        gameOverViewer.DrawMenu();

        verify(mockGraphics).setForegroundColor(TextColor.Factory.fromString("yellow"));
        verify(mockGraphics).putString(12, 10, "Retry");
        verify(mockScreen).refresh();

        reset(mockGraphics, mockScreen);

        when(mockGameOverKeyProcessor.GetOption()).thenReturn("Exit Game");

        gameOverViewer.DrawMenu();

        verify(mockGraphics).setForegroundColor(TextColor.Factory.fromString("white"));
        verify(mockGraphics).putString(12, 20, "Exit");
        verify(mockScreen).refresh();
    }
}