package g1304.Runner.State;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import g1304.Runner.Controller.MenuKeyProcessor;
import g1304.Runner.Model.Builders.ScreenBuilder;
import g1304.Runner.Model.MenuController;
import g1304.Runner.Viewer.MenuViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MenuStateTest {

    private MenuState menuState;
    private TerminalScreen screen;
    private MenuController menuController;
    private MenuViewer menuViewer;
    private ScreenBuilder screenBuilder;

    @BeforeEach
    void setUp() {
        screen = mock(TerminalScreen.class);
        menuController = mock(MenuController.class);
        menuViewer = mock(MenuViewer.class);
        screenBuilder = mock(ScreenBuilder.class);
        menuController = mock(MenuController.class);

        // Mock behavior for the screen builder
        when(screenBuilder.buildMenuScreen()).thenReturn(screen);

        menuState = new MenuState(menuController, screenBuilder, null, menuViewer);
    }



    @Test
    void testIsRunning() {
        assertTrue(menuState.isRunning());
    }
}