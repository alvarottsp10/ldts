package g1304.Runner.Controller;

import g1304.Runner.MovingObjects.Position;
import g1304.Runner.MovingObjects.MainCharacter;
import g1304.Runner.MovingObjects.Monsters.Slime;
import g1304.Runner.Helpers.Ruler;
import g1304.Runner.MovingObjects.Wall;

import java.util.ArrayList;
import java.util.List;

public class SlimeController implements Runnable {
    List<Slime> slimes = new ArrayList<>();
    MovementController movementController;
    MainCharacter mainCharacter;
    Ruler ruler = new Ruler();

    boolean running = true;

    Thread slimeTimeFlow = new Thread(this);
    @Override
    public void run() {
        while (running) {
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
        slimeTimeFlow.interrupt();
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
        else if (slime.getY() == mainCharacter.HeroY()){
            if (slime.getX() > mainCharacter.HeroX()) {
                movementController.MoveLeft(slime.getPosition());
            }
            else {
                movementController.MoveRight(slime.getPosition());
            }
        }

        else {
            if (slime.getX() > mainCharacter.HeroX()) {
                if (slime.getY() > mainCharacter.HeroY()) {
                    movementController.MoveUp(slime.getPosition());
                    movementController.MoveLeft(slime.getPosition());
                }
                else if (slime.getY() < mainCharacter.HeroY()) {
                    movementController.MoveDown(slime.getPosition());
                    movementController.MoveLeft(slime.getPosition());
                }
            }

            else if (slime.getX() < mainCharacter.HeroX()) {
                if (slime.getY() > mainCharacter.HeroY()) {
                    movementController.MoveUp(slime.getPosition());
                    movementController.MoveRight(slime.getPosition());
                }
                else if (slime.getY() < mainCharacter.HeroY()) {
                    movementController.MoveDown(slime.getPosition());
                    movementController.MoveRight(slime.getPosition());
                }
            }
        }
    }

    public SlimeController(List<Wall> walls, List<Slime> slimes_, MainCharacter mainCharacter1) {
        movementController = new MovementController(walls, slimes_);
        slimes = slimes_;
        mainCharacter = mainCharacter1;
    }

    public void StartSlimes() {
        slimeTimeFlow.start();
    }


    public void stopSlimes() {
        running = false;
    }
}
