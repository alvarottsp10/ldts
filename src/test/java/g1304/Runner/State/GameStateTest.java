package g1304.Runner.State;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import g1304.Runner.Builders.GameMap;
import g1304.Runner.Builders.ScreenBuilder;
import g1304.Runner.Controller.CharacterController;
import g1304.Runner.KeyProcessor.GameKeyProcessor;
import g1304.Runner.MovingObjects.AttackController;
import g1304.Runner.MovingObjects.MainCharacter;
import g1304.Runner.MovingObjects.Monsters.SlimeCollision;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameStateTest {
    GameState state;
    int level = 1;
    TerminalScreen screen;
    ScreenBuilder screenBuilder;
    GameMap map;
    MainCharacter mainCharacter;
    AttackController attackController;
    GameKeyProcessor keyProcessor;
    CharacterController characterController;
    TextGraphics graphics;
    SlimeCollision slimeCollision;
    boolean running = true;

    @BeforeEach
    void setUp(){
        screenBuilder = mock(ScreenBuilder.class);
        screen = mock(TerminalScreen.class);
        map = mock(GameMap.class);
        mainCharacter = mock(MainCharacter.class);
        attackController = mock(AttackController.class);
        keyProcessor = mock(GameKeyProcessor.class);
        characterController = mock(CharacterController.class);
        graphics = screen.newTextGraphics();
        slimeCollision = mock(SlimeCollision.class);
        state =Mockito.spy(new GameState(screen, screenBuilder, map, mainCharacter, attackController, keyProcessor, characterController, graphics, slimeCollision));

    }

    @Test
    public void startState() throws IOException {
        when(screenBuilder.BuildGameScreen()).thenReturn(screen);
        when(map.mainCharacter).thenReturn(mainCharacter);

        // Invoking the method under test
        try (MockedStatic<GameMap> mocked = Mockito.mockStatic(GameMap.class)) {
            mocked.when(() -> GameMap.ReadElements()).thenReturn(map);
            state.startState();
        }

        // Verify method invocations or state changes
        verify(map).ReadElements();

        // Assert on state changes or conditions
        assertTrue(state.isRunning()); // If the game is running after startState()
    }



}