package g1304.Runner.Viewer;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.mockito.Mockito.*;

class InstructionViewerTest {

    @Mock
    private TerminalScreen mockScreen;

    @Mock
    private TextGraphics mockGraphics;

    private InstructionViewer instructionViewer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        instructionViewer = new InstructionViewer(mockScreen, mockGraphics);
    }

    @Test
    void testDraw() throws IOException {
        instructionViewer.draw();
        verify(mockGraphics, times(1)).setForegroundColor(TextColor.Factory.fromString("yellow"));
        verify(mockGraphics, times(3)).putString(anyInt(), anyInt(), anyString(), any(), any());
        verify(mockScreen, times(1)).refresh();
    }
}