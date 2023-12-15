package g1304.Runner.Model.Helpers;

import g1304.Runner.Model.MovingObjects.Monsters.Slime;
import g1304.Runner.Model.MovingObjects.Position;
import g1304.Runner.Model.MovingObjects.Wall;

import java.util.List;

public class Collider {
    public boolean Collide(Position pos1, List<Wall> walls) {
        for (Wall wall: walls) {
            if (pos1.getX() == wall.getX() && pos1.getY() == wall.getY()) {
                return true;
            }
        }
        return false;
    }

    public boolean CollideWithSlime(Position pos, List<Slime> slimes) {
        for(Slime slime: slimes) {
            if (pos.getX() == slime.getX() && pos.getY() == slime.getY() && !slime.isDead()) {
                return true;
            }
        }
        return false;
    }
}
