package g1304.Runner.MovingObjects.Monsters;

import g1304.Position;

public class Slime {
    private Position position;

    int lives = 2;

    String status = "Alive";

    private String LastMovement = "Down";
    public static final String[] SlimeModel = {
            "",
            "",
            "",
            "",
            "",
            "",
            "      #####",
            "    ##XRRRX##",
            "   #XRWWWRRRX#",
            "  #RRWWRRRRRXX#",
            " #XRRRRRRRRXXXX#",
            " #XRRRRRRRXXXXX#",
            "#XXXRRRRXXXXXXXX#",
            "#XXXXXXXXXXXXXXX#",
            "#XXXXXXXXXXXXXXX#",
            " ###############",
    };

    public Slime(Position position1) {
        position = position1;
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


    public void DamageSlime(int damage) {
        lives -= damage;
    }


}
