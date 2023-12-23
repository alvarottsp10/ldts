package g1304.Runner.State;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import g1304.Runner.Model.Builders.GameMap;
import g1304.Runner.Model.Builders.ScreenBuilder;
import g1304.Runner.Model.CharacterController;
import g1304.Runner.Controller.GameKeyProcessor;
import g1304.Runner.Model.MovingObjects.AttackController;
import g1304.Runner.Model.MovingObjects.MainCharacter;
import g1304.Runner.Model.MovingObjects.Monsters.Slime;
import g1304.Runner.Model.MovingObjects.Monsters.SlimeCollision;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameStateTest {
    GameState gameState;
    TerminalScreen screen;
    ScreenBuilder screenBuilder;
    GameMap map;
    MainCharacter mainCharacter;
    AttackController attackController;
    GameKeyProcessor keyProcessor;
    CharacterController characterController;
    TextGraphics graphics;
    SlimeCollision slimeCollision;

    @BeforeEach
    void setUp() {
        screen = mock(TerminalScreen.class);
        screenBuilder = mock(ScreenBuilder.class);
        map = mock(GameMap.class);
        mainCharacter = mock(MainCharacter.class);
        attackController = mock(AttackController.class);
        keyProcessor = mock(GameKeyProcessor.class);
        characterController = mock(CharacterController.class);
        graphics = mock(TextGraphics.class);
        slimeCollision = mock(SlimeCollision.class);

        gameState = new GameState(screen, screenBuilder, map, mainCharacter, attackController, keyProcessor, characterController, graphics, slimeCollision);
    }

    @Test
    void nextState_LevelCleared_ReturnsNewGameState() {
        when(map.allSlimesDied()).thenReturn(true);


        State nextState = gameState.nextState();

        assertTrue(nextState instanceof GameState);
        verify(map, times(1)).allSlimesDied();
        try {
            verify(screen, times(1)).close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void nextState_LevelNotCleared_ReturnsGameOverState() {
        when(map.allSlimesDied()).thenReturn(false);

        State nextState = gameState.nextState();

        assertTrue(nextState instanceof GameOverState);
        verify(map, times(1)).allSlimesDied();
    }


    @Test
    void update_CallsMoveCharacterMethod() {
        gameState.update();

        verify(characterController, times(1)).MoveCharacter();
    }

    @Test
    void levelCleared_AllSlimesDied_ReturnsTrue() {
        when(map.allSlimesDied()).thenReturn(true);

        boolean result = gameState.levelCleared();

        assertTrue(result);
        verify(map, times(1)).allSlimesDied();
    }

    @Test
    void levelCleared_SlimesAlive_ReturnsFalse() {
        when(map.allSlimesDied()).thenReturn(false);

        boolean result = gameState.levelCleared();

        assertFalse(result);
        verify(map, times(1)).allSlimesDied();
    }


}

