package g1304.Runner.Model.MovingObjects;

import g1304.Runner.Model.MovementController;
import g1304.Runner.Model.MovingObjects.Monsters.Slime;

import java.util.ArrayList;
import java.util.List;

public class AttackController {
    List<Slime> slimes = new ArrayList<>();
    MovementController movementController;
    MainCharacter mainCharacter;
    long timeOfLastAttack = 0;

    public void AttackUp() {
        mainCharacter.setCurrentSprite("Attacking up");
        for(Slime slime: slimes) {
            if(slime.getX() == mainCharacter.HeroX() && slime.getY() == mainCharacter.HeroY() -16 && System.currentTimeMillis() > timeOfLastAttack + 500) {
                movementController.MoveUp(slime.getPosition());
                movementController.MoveUp(slime.getPosition());
                slime.DamageSlime(1);
                timeOfLastAttack = System.currentTimeMillis();
            }
        }
    }

    public void AttackDown() {
        mainCharacter.setCurrentSprite("Attacking down");
        for(Slime slime: slimes) {
            if(slime.getX() == mainCharacter.HeroX() && slime.getY() == mainCharacter.HeroY()  + 16 && System.currentTimeMillis() > timeOfLastAttack + 500) {
                movementController.MoveDown(slime.getPosition());
                movementController.MoveDown(slime.getPosition());
                slime.DamageSlime(1);
                timeOfLastAttack = System.currentTimeMillis();
            }
        }
    }

    public void AttackLeft() {
        mainCharacter.setCurrentSprite("Attacking left");
        for(Slime slime: slimes) {
            if(slime.getX() == mainCharacter.HeroX() - 16 && slime.getY() == mainCharacter.HeroY() && System.currentTimeMillis() > timeOfLastAttack + 500) {
                movementController.MoveLeft(slime.getPosition());
                movementController.MoveLeft(slime.getPosition());
                slime.DamageSlime(1);
                timeOfLastAttack = System.currentTimeMillis();
            }
        }
    }

    public void AttackRight() {
        mainCharacter.setCurrentSprite("Attacking right");
        for(Slime slime: slimes) {
            if(slime.getX() == mainCharacter.HeroX() +16 && slime.getY() == mainCharacter.HeroY()  + 16 && System.currentTimeMillis() > timeOfLastAttack + 500) {
                movementController.MoveRight(slime.getPosition());
                movementController.MoveRight(slime.getPosition());
                slime.DamageSlime(1);
                timeOfLastAttack = System.currentTimeMillis();
            }
        }
    }

    public AttackController(List<Slime> slimes1, MainCharacter mainCharacter1) {
        slimes = slimes1;
        mainCharacter = mainCharacter1;
        movementController = mainCharacter.getMovementController();
    }

}
