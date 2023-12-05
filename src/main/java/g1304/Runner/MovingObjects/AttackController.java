package g1304.Runner.MovingObjects;

import g1304.Runner.MovingObjects.Monsters.Slime;

import java.util.ArrayList;
import java.util.List;

public class AttackController {
    List<Slime> slimes = new ArrayList<>();
    MovementController movementController;
    MainCharacter mainCharacter;

    public void AttackUp() {
        for(Slime slime: slimes) {
            if(slime.getX() == mainCharacter.HeroX() && slime.getY() == mainCharacter.HeroY() -16) {
                movementController.MoveUp(slime.getPosition());
            }
        }
    }

    public void AttackDown() {
        for(Slime slime: slimes) {
            if(slime.getX() == mainCharacter.HeroX() && slime.getY() == mainCharacter.HeroY()  + 16) {
                movementController.MoveDown(slime.getPosition());
            }
        }
    }

    public void AttackLeft() {
        for(Slime slime: slimes) {
            if(slime.getX() == mainCharacter.HeroX() - 16 && slime.getY() == mainCharacter.HeroY()) {
                movementController.MoveLeft(slime.getPosition());
            }
        }
    }

    public void AttackRight() {
        for(Slime slime: slimes) {
            if(slime.getX() == mainCharacter.HeroX() +16 && slime.getY() == mainCharacter.HeroY()  + 16) {
                movementController.MoveRight(slime.getPosition());
            }
        }
    }

    public AttackController(List<Slime> slimes1, MainCharacter mainCharacter1) {
        slimes = slimes1;
        mainCharacter = mainCharacter1;
        movementController = mainCharacter.getMovementController();
    }

}
