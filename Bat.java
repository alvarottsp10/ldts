package g1304.Runner.Model.MovingObjects.Monsters;

import g1304.Runner.Model.MovingObjects.Position;

public class Bat {
    private Position position;

    int lives = 1;

    int damage;

    private String LastMovement = "Down";


    public static final String[] BatModel = {
            " /\\                    /\\",
            "/  \\    (\\    /\\    /  \\",
            "\\   \\   / /\\   /\\   /   /",
            " \\   \\ / /  \\ /  \\ /   /",
            "  \\   / /   |   \\   /",
            "   \\ / /    |    \\ /",
            "    \\ /      \\     /",
            "     |        |",
            "     |        |",
    };

    public Bat(Position position1, int level) {
        position = position1;
        damage = level;
    }
    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public Position getPosition() {
        return position;
    }

    public void setLastMovement(String lastMovement) {
        LastMovement = lastMovement;
    }

    public String getLastMovement() {
        return LastMovement;
    }

    public boolean isDead() {
        return lives <= 0;
    }

    public int batDamage() {
        return damage;
    }

    public void DamageBat(int damage) {
        lives -= damage;
    }

}
