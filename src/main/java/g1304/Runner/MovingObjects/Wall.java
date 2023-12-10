package g1304.Runner.MovingObjects;

import g1304.Runner.MovingObjects.Position;

public class Wall {
    private Position wallPosition;

    public Wall(int x, int y) {
        wallPosition = new Position(x, y);
    }

    public int getX() {
        return wallPosition.getX();
    }

    public int getY() {
        return wallPosition.getY();
    }
}
