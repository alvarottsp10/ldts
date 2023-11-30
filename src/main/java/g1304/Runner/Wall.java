package g1304.Runner;

import g1304.Position;

public class Wall {
    private Position wallPosition;

    Wall(int x, int y) {
        wallPosition = new Position(x, y);
    }

    public int getX() {
        return wallPosition.getX();
    }

    public int getY() {
        return wallPosition.getY();
    }
}
