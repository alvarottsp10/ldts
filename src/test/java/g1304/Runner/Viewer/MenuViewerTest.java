package g1304.Runner.Viewer;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import g1304.Runner.Model.MenuController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

class MenuViewerTest {

    @Mock
    private TerminalScreen mockScreen;

    @Mock
    private TextGraphics mockGraphics;

    @Mock
    private MenuController mockMenuController;

    private MenuViewer menuViewer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        menuViewer = new MenuViewer(mockScreen, mockGraphics, mockMenuController);
    }

    @Test
    void testDrawMenu() throws IOException {
        when(mockMenuController.getOption()).thenReturn("Start Game");

        menuViewer.DrawMenu();

        // Adjust the expected number of times based on your actual logic
        verify(mockScreen, times(1)).clear();
        verify(mockGraphics, times(3)).setForegroundColor(any());
        verify(mockGraphics, times(3)).putString(anyInt(), anyInt(), anyString());
        verify(mockScreen, times(1)).refresh();
    }
}