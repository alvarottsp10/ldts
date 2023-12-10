package g1304.Runner.Controller;

import g1304.Runner.KeyProcessor.GameKeyProcessor;
import g1304.Runner.MovingObjects.MainCharacter;

public class CharacterController {
    MainCharacter mainCharacter;

    GameKeyProcessor keyProcessor;
   void MoveCharacter() {
       if (keyProcessor.isDownPressed()) {
           mainCharacter.MoveHeroDown();
           mainCharacter.setCurrentSprite("walking");
       }
       else if (keyProcessor.isLeftPressed()) {
           mainCharacter.MoveHeroLeft();
           mainCharacter.setCurrentSprite("walking");
       }
       else if (keyProcessor.isUpPressed()) {
           mainCharacter.MoveHeroUp();
           mainCharacter.setCurrentSprite("walking");
       }
       else if (keyProcessor.isRightPressed()) {
           mainCharacter.MoveHeroRight();
           mainCharacter.setCurrentSprite("walking");
       }
       else {
           mainCharacter.setCurrentSprite("standing");
       }
   }

   CharacterController(MainCharacter mainCharacter1, GameKeyProcessor keyProcessor1) {
       mainCharacter = mainCharacter1;
       keyProcessor = keyProcessor1;
   }


}
