package g1304.Runner.MovingObjects;

import g1304.Runner.Controller.MovementController;
import g1304.Runner.MovingObjects.Monsters.Slime;

import java.util.ArrayList;
import java.util.List;

public class AttackController {
    List<Slime> slimes = new ArrayList<>();
    MovementController movementController;
    MainCharacter mainCharacter;
    long timeOfLastAttack = 0;

    public void AttackUp() {
        for(Slime slime: slimes) {
            if(slime.getX() == mainCharacter.HeroX() && slime.getY() == mainCharacter.HeroY() -16 && System.currentTimeMillis() > timeOfLastAttack + 500) {
                movementController.MoveUp(slime.getPosition());
                slime.DamageSlime(1);
                timeOfLastAttack = System.currentTimeMillis();
            }
        }
    }

    public void AttackDown() {
        for(Slime slime: slimes) {
            if(slime.getX() == mainCharacter.HeroX() && slime.getY() == mainCharacter.HeroY()  + 16 && System.currentTimeMillis() > timeOfLastAttack + 500) {
                movementController.MoveDown(slime.getPosition());
                slime.DamageSlime(1);
                timeOfLastAttack = System.currentTimeMillis();
            }
        }
    }

    public void AttackLeft() {
        for(Slime slime: slimes) {
            if(slime.getX() == mainCharacter.HeroX() - 16 && slime.getY() == mainCharacter.HeroY() && System.currentTimeMillis() > timeOfLastAttack + 500) {
                movementController.MoveLeft(slime.getPosition());
                slime.DamageSlime(1);
                timeOfLastAttack = System.currentTimeMillis();
            }
        }
    }

    public void AttackRight() {
        for(Slime slime: slimes) {
            if(slime.getX() == mainCharacter.HeroX() +16 && slime.getY() == mainCharacter.HeroY()  + 16 && System.currentTimeMillis() > timeOfLastAttack + 500) {
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
