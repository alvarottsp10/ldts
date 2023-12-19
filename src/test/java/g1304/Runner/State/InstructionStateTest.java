package g1304.Runner.State;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import g1304.Runner.Model.Builders.ScreenBuilder;
import g1304.Runner.State.InstructionState;
import g1304.Runner.State.MenuState;
import g1304.Runner.State.State;
import g1304.Runner.Viewer.InstructionViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class InstructionStateTest {

    private InstructionState instructionState;
    private TerminalScreen screen;
    private InstructionViewer instructionViewer;
    private ScreenBuilder screenBuilder;
    private TextGraphics graphics;

    @BeforeEach
    void setUp() {
        screen = mock(TerminalScreen.class);
        instructionViewer = mock(InstructionViewer.class);
        screenBuilder = mock(ScreenBuilder.class);
        graphics = mock(TextGraphics.class);

        // Mock behavior for the screen builder
        when(screenBuilder.buildMenuScreen()).thenReturn(screen);

        instructionState = new InstructionState(screenBuilder, instructionViewer);
    }

    @Test
    void testNextState() {
        State nextState = instructionState.nextState();
        assert nextState instanceof MenuState;
    }

    @Test
    void testIsRunning() {
        assert instructionState.isRunning();
    }
}