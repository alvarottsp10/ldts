package g1304.Runner.State;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import g1304.Runner.Model.Builders.ScreenBuilder;
import g1304.Runner.Model.MenuController;
import g1304.Runner.Music;
import g1304.Runner.Viewer.MenuViewer;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class MenuStateTest {




    @Test
    void testIsRunning() {
        MenuState menuState = new MenuState();
        assertTrue(menuState.isRunning());
    }

    @Test
    void testNextStateStartGame() {
        MenuController mockMenuController = mock(MenuController.class);
        when(mockMenuController.getOption()).thenReturn("Start Game");

        MenuState menuState = new MenuState();
        menuState.menuController = mockMenuController;

        Music music = new Music();
        assertEquals(new GameState(music, 1).getClass(), menuState.nextState().getClass());
    }

    @Test
    void testNextStateInstructions() {
        MenuController mockMenuController = mock(MenuController.class);
        when(mockMenuController.getOption()).thenReturn("Instructions");

        MenuState menuState = new MenuState();
        menuState.menuController = mockMenuController;

        assertEquals(new InstructionState().getClass(), menuState.nextState().getClass());
    }
}