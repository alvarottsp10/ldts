package g1304.Runner;

import g1304.Position;
import g1304.Runner.MovingObjects.Monsters.Slime;
import g1304.Runner.MovingObjects.MovementController;

import java.util.ArrayList;
import java.util.List;

public class SlimeController implements Runnable {
    List<Slime> slimes = new ArrayList<>();
    MovementController movementController;

    Thread slimeTimeFlow = new Thread(this);
    @Override
    public void run() {
        while (slimeTimeFlow != null) {
            for(Slime slime: slimes) {
                passiveMovement(slime);
            }
            try {
                Thread.sleep(500);
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

    SlimeController(List<Wall> walls, List<Slime> slimes_) {
        movementController = new MovementController(walls);
        slimes = slimes_;
    }

    void StartSlimes() {
        slimeTimeFlow.start();
    }
}
