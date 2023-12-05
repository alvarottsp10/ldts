package g1304.Runner;

import g1304.Runner.MovingObjects.MainCharacter;

public class CharacterController {
    MainCharacter mainCharacter;

    KeyProcessor keyProcessor;
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

   CharacterController(MainCharacter mainCharacter1, KeyProcessor keyProcessor1) {
       mainCharacter = mainCharacter1;
       keyProcessor = keyProcessor1;
   }


}
