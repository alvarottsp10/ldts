package g1304.Runner.Model;

import g1304.Runner.Controller.GameKeyProcessor;
import g1304.Runner.Model.MovingObjects.MainCharacter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CharacterControllerTest {

    @Test
    void testMoveCharacter() {
        MainCharacter mainCharacter = mock(MainCharacter.class);
        GameKeyProcessor keyProcessor = mock(GameKeyProcessor.class);

        CharacterController characterController = new CharacterController(mainCharacter, keyProcessor);


        when(keyProcessor.isDownPressed()).thenReturn(true);
        characterController.MoveCharacter();
        verify(mainCharacter, times(1)).MoveHeroDown();
        verify(mainCharacter, times(1)).setCurrentSprite("walking down");


        reset(mainCharacter, keyProcessor);

        when(keyProcessor.isLeftPressed()).thenReturn(true);
        characterController.MoveCharacter();
        verify(mainCharacter, times(1)).MoveHeroLeft();
        verify(mainCharacter, times(1)).setCurrentSprite("walking left");

        reset(mainCharacter, keyProcessor);

        when(keyProcessor.isUpPressed()).thenReturn(true);
        characterController.MoveCharacter();
        verify(mainCharacter, times(1)).MoveHeroUp();
        verify(mainCharacter, times(1)).setCurrentSprite("walking up");

        reset(mainCharacter, keyProcessor);

        when(keyProcessor.isRightPressed()).thenReturn(true);
        characterController.MoveCharacter();
        verify(mainCharacter, times(1)).MoveHeroRight();
        verify(mainCharacter, times(1)).setCurrentSprite("walking right");

        reset(mainCharacter, keyProcessor);

        when(keyProcessor.isDownPressed()).thenReturn(false);
        when(keyProcessor.isLeftPressed()).thenReturn(false);
        when(keyProcessor.isUpPressed()).thenReturn(false);
        when(keyProcessor.isRightPressed()).thenReturn(false);

        characterController.MoveCharacter();
        verify(mainCharacter, times(1)).setCurrentSprite("standing");
    }
}