package g1304.Runner.Model;

import g1304.Runner.Model.MovingObjects.Position;
import g1304.Runner.Model.MovingObjects.MainCharacter;
import g1304.Runner.Model.MovingObjects.Monsters.Slime;
import g1304.Runner.Model.Helpers.Ruler;
import g1304.Runner.Model.MovingObjects.Wall;

import java.util.ArrayList;
import java.util.List;

public class SlimeController implements Runnable {
    List<Slime> slimes = new ArrayList<>();
    MovementController movementController;
    MainCharacter mainCharacter;
    List<Wall> walls;
    Ruler ruler = new Ruler();

    boolean running = true;

    Thread slimeTimeFlow = new Thread(this);
    @Override
    public void run() {
        while (running) {
            for(Slime slime: slimes) {
                if (!slime.isDead()) {
                    if (ruler.getDistance(mainCharacter.getPosition(), slime.getPosition()) < 160 && !existsWallBetween(slime, mainCharacter)) {
                        chaseMovement(slime, mainCharacter);
                    }
                    else {
                        passiveMovement(slime);
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

    public SlimeController(List<Wall> walls1, List<Slime> slimes_, MainCharacter mainCharacter1) {
        movementController = new MovementController(walls1, slimes_);
        walls = walls1;
        slimes = slimes_;
        mainCharacter = mainCharacter1;
    }

    public boolean existsWallBetween (Slime slime, MainCharacter mainCharacter) {
        for (Wall wall: walls) {
            if (wall.getX() > mainCharacter.HeroX() && slime.getX() > wall.getX() && wall.getY() == slime.getY()) {
                return true;
            }
            else if (wall.getX() < mainCharacter.HeroX() && slime.getX() < wall.getX() && wall.getY() == slime.getY()) {
                return true;
            }
        }
        return false;
    }

    public void StartSlimes() {
        slimeTimeFlow.start();
    }


    public void stopSlimes() {
        running = false;
    }

    public boolean slimesDied() {
        for(Slime slime: slimes) {
            if (!slime.isDead()) {
                return false;
            }
        }
        return true;
    }
}
