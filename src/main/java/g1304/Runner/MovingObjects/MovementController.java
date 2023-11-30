package g1304.Runner.MovingObjects;

import g1304.Collider;
import g1304.Position;
import g1304.Runner.Wall;

import java.util.List;

public class MovementController {
    List<Wall> walls;

    Collider collider = new Collider();

    public MovementController(List<Wall> walls1) {
        walls = walls1;
    }
    public void MoveUp(Position position) {
        if (CanMoveUp(position)) {
            position.addToY(-8);
        }
    }

    public void MoveDown(Position position) {
        if (CanMoveDown(position)) {
            position.addToY(8);
        }
    }

    public void MoveLeft(Position position) {
        if (CanMoveLeft(position)) {
            position.addToX(-8);
        }
    }

    public void MoveRight(Position position) {
        if (CanMoveRight(position)) {
            position.addToX(8);
        }
    }

    public boolean CanMoveUp(Position position) {
        Position desiredPosition = new Position(position.getX() , position.getY() -16);
        if (!collider.Collide(desiredPosition, walls)) {
            return true;
        }
        return false;
    }

    public boolean CanMoveDown(Position position) {
        Position desiredPosition = new Position(position.getX() , position.getY() +16);
        if (!collider.Collide(desiredPosition, walls)) {
            return true;
        }
        return false;
    }

    public boolean CanMoveLeft(Position position) {
        Position desiredPosition = new Position(position.getX() - 16, position.getY());
        if (!collider.Collide(desiredPosition, walls)) {
            return true;
        }
        return false;
    }

    public boolean CanMoveRight(Position position) {
        Position desiredPosition = new Position(position.getX() +16 , position.getY() );
        if (!collider.Collide(desiredPosition, walls)) {
            return true;
        }
        return false;
    }
}
