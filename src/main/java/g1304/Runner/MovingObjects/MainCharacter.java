package g1304.Runner.MovingObjects;

import g1304.Position;
import g1304.Runner.GameMap;
import g1304.Runner.KeyProcessor;

public class MainCharacter {
    Position position;

    private KeyProcessor keyProcessor;

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

     public MainCharacter(int x, int y, GameMap map_, KeyProcessor keyProcessor_) {
        position = new Position(x, y);
        map = map_;
        movementController = new MovementController(map.GetWalls());
        keyProcessor = keyProcessor_;

     }


}
