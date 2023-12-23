package g1304.Runner.Model.MovingObjects;

import g1304.Runner.Model.MovementController;
import g1304.Runner.Model.MovingObjects.MainCharacter;
import g1304.Runner.Model.MovingObjects.Position;
import g1304.Runner.Model.MovingObjects.Monsters.Slime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class AttackControllerTest {

    private AttackController attackController;
    private MovementController movementController;
    private MainCharacter mainCharacter;
    private List<Slime> slimes;

    @BeforeEach
    void setUp() {
        slimes = Arrays.asList(mock(Slime.class), mock(Slime.class));
        mainCharacter = mock(MainCharacter.class);
        movementController = mock(MovementController.class);

        when(mainCharacter.getMovementController()).thenReturn(movementController);

        attackController = new AttackController(slimes, mainCharacter);
        attackController.movementController = movementController;
    }

    @Test
    void testAttackUp() {
        when(mainCharacter.HeroX()).thenReturn(10);
        when(mainCharacter.HeroY()).thenReturn(20);

        when(slimes.get(0).getX()).thenReturn(10);
        when(slimes.get(0).getY()).thenReturn(4);
        when(slimes.get(1).getX()).thenReturn(15);
        when(slimes.get(1).getY()).thenReturn(20);


        attackController.AttackUp();


        verify(mainCharacter).setCurrentSprite("Attacking up");
        verify(slimes.get(0)).DamageSlime(1);
        verify(slimes.get(1), never()).DamageSlime(1);
    }


    @Test
    void testAttackDown() {
        when(mainCharacter.HeroX()).thenReturn(10);
        when(mainCharacter.HeroY()).thenReturn(20);

        when(slimes.get(0).getX()).thenReturn(10);
        when(slimes.get(0).getY()).thenReturn(36);
        when(slimes.get(1).getX()).thenReturn(15);
        when(slimes.get(1).getY()).thenReturn(20);


        attackController.AttackDown();


        verify(mainCharacter).setCurrentSprite("Attacking down");
        verify(slimes.get(0)).DamageSlime(1);
        verify(slimes.get(1), never()).DamageSlime(1);
    }

    @Test
    void testAttackLeft() {
        when(mainCharacter.HeroX()).thenReturn(20);
        when(mainCharacter.HeroY()).thenReturn(20);

        when(slimes.get(0).getX()).thenReturn(4);
        when(slimes.get(0).getY()).thenReturn(20);
        when(slimes.get(1).getX()).thenReturn(50);
        when(slimes.get(1).getY()).thenReturn(20);


        attackController.AttackLeft();


        verify(mainCharacter).setCurrentSprite("Attacking left");
        verify(slimes.get(0)).DamageSlime(1);
        verify(slimes.get(1), never()).DamageSlime(1);
    }

    @Test
    void testAttackRight() {
        when(mainCharacter.HeroX()).thenReturn(20);
        when(mainCharacter.HeroY()).thenReturn(20);

        when(slimes.get(0).getX()).thenReturn(36);
        when(slimes.get(0).getY()).thenReturn(20);
        when(slimes.get(1).getX()).thenReturn(50);
        when(slimes.get(1).getY()).thenReturn(20);


        attackController.AttackRight();


        verify(mainCharacter).setCurrentSprite("Attacking right");
        verify(slimes.get(0)).DamageSlime(1);
        verify(slimes.get(1), never()).DamageSlime(1);
    }

}