package g1304.Runner;

import g1304.Position;
import g1304.Runner.MovingObjects.MainCharacter;
import g1304.Runner.MovingObjects.Monsters.Slime;
import g1304.Runner.MovingObjects.MovementController;

import java.util.ArrayList;
import java.util.List;

public class SlimeController implements Runnable {
    List<Slime> slimes = new ArrayList<>();
    MovementController movementController;
    MainCharacter mainCharacter;
    Ruler ruler = new Ruler();

    Thread slimeTimeFlow = new Thread(this);
    @Override
    public void run() {
        while (slimeTimeFlow != null) {
            for(Slime slime: slimes) {
                if (!slime.isDead()) {
                    if (ruler.getDistance(mainCharacter.getPosition(), slime.getPosition()) > 160) {
                        passiveMovement(slime);
                    }
                    else {
                        chaseMovement(slime, mainCharacter);
                    }
                }
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    void passiveMovement(Slime slime) {
        if (movementController.CanMoveDown(new Position(slime.getX(), slime.getY())) && slime.getLastMovement() == "Down") {
            movementController.MoveDown(slime.getPosition());
        }
        else if (!movementController.CanMoveDown(new Position(slime.getX(), slime.getY())) && slime.getLastMovement() == "Down") {
            movementController.MoveUp(slime.getPosition());
            slime.setLastMovement("Up");
        }
        else if(movementController.CanMoveUp(new Position(slime.getX(), slime.getY())) && slime.getLastMovement() == "Up") {
            movementController.MoveUp(slime.getPosition());
        }
        else if (!movementController.CanMoveUp(new Position(slime.getX(), slime.getY())) && slime.getLastMovement() == "Up") {
            movementController.MoveDown(slime.getPosition());
            slime.setLastMovement("Down");
        }

    }

    void chaseMovement(Slime slime, MainCharacter mainCharacter) {
        if (slime.getX() == mainCharacter.HeroX()) {
            if (slime.getY() > mainCharacter.HeroY()) {
                movementController.MoveUp(slime.getPosition());
            }
            else {
                movementController.MoveDown(slime.getPosition());
            }
        }
        else {
            if (slime.getX() > mainCharacter.HeroX()) {
                movementController.MoveLeft(slime.getPosition());
            }
            else {
                movementController.MoveRight(slime.getPosition());
            }
        }
    }

    SlimeController(List<Wall> walls, List<Slime> slimes_, MainCharacter mainCharacter1) {
        movementController = new MovementController(walls);
        slimes = slimes_;
        mainCharacter = mainCharacter1;
    }

    void StartSlimes() {
        slimeTimeFlow.start();
    }
}
