package g1304.Runner.Model.MovingObjects.Monsters;

import g1304.Runner.Model.MovingObjects.MainCharacter;
import g1304.Runner.Model.MovingObjects.Position;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SlimeCollisionTest {

    @Test
    void testSlimeHitsCharacter() {
        MainCharacter mainCharacter = mock(MainCharacter.class);
        Slime slime = new Slime(new Position(1, 2), 1);

        SlimeCollision slimeCollision = new SlimeCollision(mainCharacter, List.of(slime));

        when(mainCharacter.HeroX()).thenReturn(1);
        when(mainCharacter.HeroY()).thenReturn(2);

        assertTrue(slimeCollision.SlimeHitsCharacter(slime));

        // Verifying that the HeroX and HeroY methods were called
        verify(mainCharacter, times(1)).HeroX();
        verify(mainCharacter, times(1)).HeroY();
    }

    @Test
    void testSlimeAttackDown() {
        MainCharacter mainCharacter = mock(MainCharacter.class);
        Slime slime = new Slime(new Position(1, 2), 1);
        slime.setLastMovement("Down");

        SlimeCollision slimeCollision = new SlimeCollision(mainCharacter, List.of(slime));

        slimeCollision.SlimeAttack(slime);

        verify(mainCharacter, times(4)).MoveHeroDown();
    }

    @Test
    void testSlimeAttackUp() {
        MainCharacter mainCharacter = mock(MainCharacter.class);
        Slime slime = new Slime(new Position(1, 2), 1);
        slime.setLastMovement("Up");

        SlimeCollision slimeCollision = new SlimeCollision(mainCharacter, List.of(slime));

        slimeCollision.SlimeAttack(slime);

        verify(mainCharacter, times(4)).MoveHeroUp();
    }


}