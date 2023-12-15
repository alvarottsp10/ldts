package g1304.Runner.State;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import g1304.Runner.Model.Builders.GameMap;
import g1304.Runner.Model.Builders.ScreenBuilder;
import g1304.Runner.Model.CharacterController;
import g1304.Runner.Controller.GameKeyProcessor;
import g1304.Runner.Model.MovingObjects.AttackController;
import g1304.Runner.Model.MovingObjects.MainCharacter;
import g1304.Runner.Model.MovingObjects.Monsters.SlimeCollision;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
    public void testNextState() {
        State nextState = state.nextState();
        assert nextState instanceof GameOverState;
    }

}

