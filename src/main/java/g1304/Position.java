package g1304;

public class Position {
    private int x;
    private int y;

    public Position(int x_, int y_) {
        x = x_;
        y = y_;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void addToX(int increment) {
        x = x + increment;
    }

    public void addToY(int increment) {
        y = y + increment;
    }
}
