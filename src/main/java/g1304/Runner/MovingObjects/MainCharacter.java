package g1304.Runner.MovingObjects;

import g1304.Runner.Controller.MovementController;
import g1304.Runner.Builders.GameMap;
import g1304.Runner.MovingObjects.Monsters.Slime;

import java.util.List;

public class MainCharacter {
    Position position;
    int lives = 5;

    boolean attacking = false;

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

    public static final String[] mainCharacterAttackUpModel = {
            "       XX",
            "       XX",
            "       XX",
            "       XX",
            "       XX",
            "       XX",
            "     YYYYYY",
            "       YY",
            "    ########",
            "   #XXXXXXXX#",
            "  #XXXXXXXXXX#",
            "  #XXXXXXXXXX#",
            " ##XXXXXXXXXX##",
            " ###XXXXXXXX###",
            "#W############W#",
            "#WW##########WW#",
            " ##WW######WW##",
            " #X##XXXXXX##X#",
            " #X#X######X#X#",
            "  ##XXXYYXXX##",
            "  ###XXXXXX###",
            "  #X########X#",
            "  #XXXX##XXXX#",
            "   ####  ####",
    };

    public static final String[] mainCharacterModelWalkingLeft1 = {
            "    ######",
            "   #XXXXXX#",
            "  #XXXXXXXX#",
            " ##YXXXXXXX#",
            "#YYYYXXXXX###",
            " ##XXX#######",
            "  #H#HH######",
            "  #H#HH#HH##",
            "  #HHHHHHH#",
            "   #HHHH##X%",
            "    ####HH#%",
            "    ####HH%%",
            "   #XXXX###",
            "   #XXXXX#",
            "    #####",
    };

    public static final String[] mainCharacterModelWalkingLeft2 = {
            "    ######",
            "   #XXXXXX#",
            "  #XXXXXXXX#",
            " ##YXXXXXXX#",
            "#YYYYXXXXX###",
            " ##XXX#######",
            "  #H#HH######",
            "  #H#HH#HH##",
            "  #HHHHHHH#",
            "   #HHHH##X%",
            "    ####HHX%",
            "  ######HH%%",
            " #XX#XX#HH#x%",
            "  #XX#####XX%",
            "   ###    ##",
    };

    public static final String[] mainCharacterModelWalkingRight1 = {
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
            " %XHH####",
            " %%HH####",
            "  ###XXXX#",
            "   #XXXXX#",
            "    #####",
    };

    public static final String[] mainCharacterModelWalkingRight2 = {
            "   ######",
            "  #XXXXXX#",
            " #XXXXXXXX#",
            " ##YXXXXXXX#",
            "#YYYYXXXXX###",
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

    public static final String[] Heart = {
            "  ####   ####",
            " #RRRR# #RRRR#",
            "#RRRRRR#RRRRRR#",
            "#RRRRRRRRRRRRR#",
            "#RRRRRRRRRRRRR#",
            "#RRRRRRRRRRRRR#",
            " #RRRRRRRRRRR#",
            "  #RRRRRRRRR#",
            "   #RRRRRRR#",
            "    #RRRRR#",
            "     #RRR#",
            "      #R#",
            "       #",
            "",
            "",
            "",
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

     public MainCharacter(int x, int y, List<Wall> walls, List<Slime> slimes) {
        position = new Position(x, y);
        movementController = new MovementController(walls, slimes);

     }

     public MovementController getMovementController() {
        return movementController;
     }

     public String[] getCurrentSprite() {
        return CurrentSprite;
     }

     public void setCurrentSprite(String state) {
        switch (state) {
            case ("walking") -> {
                CurrentSprite = mainCharacterModelWalkingRight1;
            }

            case ("walking right") -> {
                long lastUpdate = 0;
                if (System.currentTimeMillis() > lastUpdate + 1000 && CurrentSprite == mainCharacterModelWalkingRight1) {
                    CurrentSprite = mainCharacterModelWalkingRight2;
                    lastUpdate = System.currentTimeMillis();
                }
                else if (System.currentTimeMillis() > lastUpdate + 1000 && CurrentSprite == mainCharacterModelWalkingRight2) {
                    CurrentSprite = mainCharacterModelWalkingRight1;
                    lastUpdate = System.currentTimeMillis();
                }
                else if(CurrentSprite != mainCharacterModelWalkingRight1 && CurrentSprite != mainCharacterModelWalkingRight2) {
                    CurrentSprite = mainCharacterModelWalkingRight1;
                }

            }

            case ("walking left") -> {
                long lastUpdate = 0;
                if (System.currentTimeMillis() > lastUpdate + 1000 && CurrentSprite == mainCharacterModelWalkingLeft1) {
                    CurrentSprite = mainCharacterModelWalkingLeft2;
                    lastUpdate = System.currentTimeMillis();
                }
                else if (System.currentTimeMillis() > lastUpdate + 1000 && CurrentSprite == mainCharacterModelWalkingLeft2) {
                    CurrentSprite = mainCharacterModelWalkingLeft1;
                    lastUpdate = System.currentTimeMillis();
                }
                else if(CurrentSprite != mainCharacterModelWalkingLeft1 && CurrentSprite != mainCharacterModelWalkingLeft2) {
                    CurrentSprite = mainCharacterModelWalkingLeft1;
                }

            }

            case("standing") -> CurrentSprite = mainCharacterModel;
        }
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

     public String[] getHeartModel() {
        return Heart;
     }

     public String[] getMainCharacterAttackUpModel() {
        return mainCharacterAttackUpModel;
     }

     public boolean isAttacking() {
        return attacking;
     }

     public void setAttacking(boolean k) {
        attacking = k;
     }
}
