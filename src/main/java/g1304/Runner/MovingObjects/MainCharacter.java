package g1304.Runner.MovingObjects;

import g1304.Runner.Controller.MovementController;
import g1304.Runner.Builders.GameMap;

import java.util.List;

public class MainCharacter {
    Position position;
    int lives = 10;
    String status = "Alive";

    String[] CurrentSprite = mainCharacterModel;


    private GameMap map;
    private MovementController movementController;


    public static final String[] mainCharacterModel = {
            "    ######",
            "   #XXXXXX#",
            "  #XXXXXXXX#",
            "  #XXXXXXXX#",
            " ###XYYYYX###",
            " ##H######H##",
            "#H#HHHHHHHH#H#",
            "#HHHH#HH#HHHH#",
            " ##HH#HH#HH##",
            " ###HHKKHH###",
            "#HH########HH#",
            "#HH########HH#",
            " ###%%##%%###",
            "  #%##%%##%#",
            "  #%%%##%%%#",
            "   ###  ###",
    };

    public static final String[] mainCharacterModelWalking = {
            "   ######",
            "  #XXXXXX#",
            " #XXXXXXXX#",
            " #XXXXXXXY##",
            "###XXXXXYYYY#",
            "#######XXX##",
            "######HH#H#",
            " ##HH#HH#H#",
            "  #HHHHHHH#",
            " %X##HHHX#",
            " %X######",
            " %%HH######",
            "%X#HH#XX#XX#",
            "%XX#####XX#",
            " ##    ###",
    };

    public void MoveHeroUp() {
        movementController.MoveUp(position);
    }

    public void MoveHeroDown() {
        movementController.MoveDown(position);
    }

    public void MoveHeroLeft() {
        movementController.MoveLeft(position);
    }

    public void MoveHeroRight() {
        movementController.MoveRight(position);
    }

    public int HeroX() {
        return position.getX();
    }

    public int HeroY() {
        return position.getY();
    }

     public MainCharacter(int x, int y, List<Wall> walls) {
        position = new Position(x, y);
        movementController = new MovementController(walls);

     }

     public MovementController getMovementController() {
        return movementController;
     }

     public String[] getCurrentSprite() {
        return CurrentSprite;
     }

     public void setCurrentSprite(String state) {
        switch (state) {
            case("walking") -> CurrentSprite = mainCharacterModelWalking;
            case("standing") -> CurrentSprite = mainCharacterModel;
        }
     }

     public boolean isDead() {
         return !status.equals("Alive");
     }

     public void Kill() {
        status = "Dead";
     }

     public void DamagePlayer(int damage) {
        lives -= damage;
     }

     public int getLives() {
        return lives;
     }

     public Position getPosition() {
        return position;
     }
}
