package g1304.Runner.Controller;

import com.googlecode.lanterna.input.KeyStroke;
import g1304.Runner.Model.MovingObjects.AttackController;
import g1304.Runner.Model.MovingObjects.MainCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.KeyEvent;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GameKeyProcessorTest {

    private MainCharacter mainCharacterMock;
    private AttackController attackControllerMock;
    private GameKeyProcessor gameKeyProcessor;

    @BeforeEach
    void setUp() {
        mainCharacterMock = mock(MainCharacter.class);
        attackControllerMock = mock(AttackController.class);
        gameKeyProcessor = new GameKeyProcessor(mainCharacterMock, attackControllerMock);
    }




    @Test
    void keyReleased_AttackUp() {
        KeyEvent keyEvent = new KeyEvent(new MockComponent(), KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_UP, KeyEvent.CHAR_UNDEFINED);
        gameKeyProcessor.keyReleased(keyEvent);

        assertFalse(gameKeyProcessor.isUpPressed());
        assertFalse(gameKeyProcessor.isDownPressed());
        assertFalse(gameKeyProcessor.isLeftPressed());
        assertFalse(gameKeyProcessor.isRightPressed());

        verify(mainCharacterMock).setAttackingUp(false);
        verify(attackControllerMock).AttackUp();
    }



    private static class MockComponent extends java.awt.Component {

    }
}