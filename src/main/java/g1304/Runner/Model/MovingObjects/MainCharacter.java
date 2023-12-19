package g1304.Runner.Model.MovingObjects;

import g1304.Runner.Model.MovementController;
import g1304.Runner.Model.Builders.GameMap;
import g1304.Runner.Model.MovingObjects.Monsters.Slime;

import java.util.List;

public class MainCharacter {
    Position position;
    int lives = 5;

    boolean attackingUp = false;
    boolean attackingDown = false;
    boolean attackingRight = false;
    boolean attackingLeft = false;

    String[] CurrentSprite = mainCharacterModel1;


    private GameMap map;
    private MovementController movementController;


    public static final String[] mainCharacterModel1 = {
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

    public static final String[] mainCharacterAttackingModel = {
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
            "####HHYYHH####",
            "####HHYYHH####",
            " ###YYYYYY###",
            "  #%##XX##%#",
            "  #%%%XX%%%#",
            "   ###XX###",
            "      XX",
            "      XX",
            "      XX",
            "      XX",
            "      XX",
            "      XX",
            "      XX",
            "      XX",
    };

    public static final String[] mainCharacterModel2 = {
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
            "  #%%%######",
            "   ###",
    };

    public static final String[] mainCharacterAttackUpModel = {
            "       XX",
            "       XX",
            "       XX",
            "       XX",
            "       XX",
            "       XX",
            "       XX",
            "       XX",
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

    public static final String[] mainCharacterWalkingUp1 = {
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
            "  #XXXX#######",
            "   ####",
    };

    public static final String[] mainCharacterWalkingUp2 = {
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
            "  #######XXXX#",
            "         ####",
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

    public static final String[] mainCharacterModelAttackingLeft = {
            "                    ######",
            "                   #XXXXXX#",
            "                  #XXXXXXXX#",
            "                 ##YXXXXXXX#",
            "                #YYYYXXXXX###",
            "                 ##XXX#######",
            "                  #H#HH######",
            "                  #H#HH#HH##",
            "                  #HHHHHHH#",
            "                Y #HHHH##X%",
            "SSSSSSSSSSSSSSSSYYYHH#####%",
            "SSSSSSSSSSSSSSSSYYYHH####%%",
            "                Y #XXXX###",
            "                   #XXXXX#",
            "                    #####",
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

    public static final String[] mainCharacterModelAttackRight1 = {
            "   ######",
            "  #XXXXXX#",
            " #XXXXXXXX#",
            " #XXXXXXXY##",
            "###XXXXXYYYY#",
            "#######XXX##",
            "######HH#H#",
            " ##HH#HH#H#",
            "  #HHHHHHH#",
            " %X##HHHX# Y",
            " %X####HHYYYSSSSSSSSSSSSSSSS",
            " %%####HHYYYSSSSSSSSSSSSSSSS",
            "  ###XXXX# Y",
            "   #XXXXX#",
            "    #####",
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
            " %X#HH####",
            " %%#HH####",
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
            case ("walking down") -> {
                long lastUpdate = 0;
                if (System.currentTimeMillis() > lastUpdate + 1000 && CurrentSprite == mainCharacterModel1) {
                    CurrentSprite = mainCharacterModel2;
                    lastUpdate = System.currentTimeMillis();
                }
                else if (System.currentTimeMillis() > lastUpdate + 1000 && CurrentSprite == mainCharacterModel2) {
                    CurrentSprite = mainCharacterModel1;
                    lastUpdate = System.currentTimeMillis();
                }
                else if(CurrentSprite != mainCharacterModel1 && CurrentSprite != mainCharacterModel2) {
                    CurrentSprite = mainCharacterModel1;
                }
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

            case ("walking up") -> {
                long lastUpdate = 0;
                if (System.currentTimeMillis() > lastUpdate + 1000 && CurrentSprite == mainCharacterWalkingUp1) {
                    CurrentSprite = mainCharacterWalkingUp2;
                    lastUpdate = System.currentTimeMillis();
                }
                else if (System.currentTimeMillis() > lastUpdate + 1000 && CurrentSprite == mainCharacterWalkingUp2) {
                    CurrentSprite = mainCharacterWalkingUp1;
                    lastUpdate = System.currentTimeMillis();
                }
                else if(CurrentSprite != mainCharacterWalkingUp1 && CurrentSprite != mainCharacterWalkingUp2) {
                    CurrentSprite = mainCharacterWalkingUp1;
                }
            }

            case ("Attacking up") -> {
                CurrentSprite = mainCharacterAttackUpModel;
            }

            case ("Attacking down") -> {
                CurrentSprite = mainCharacterAttackingModel;
            }

            case ("Attacking left") -> {
                CurrentSprite = mainCharacterModelAttackingLeft;
            }

            case ("Attacking right") -> {
                CurrentSprite = mainCharacterModelAttackRight1;
            }


            case("standing") -> CurrentSprite = mainCharacterModel1;
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
     public String[] getMainCharacterAttackDownModel() {
        return mainCharacterAttackingModel;
    }
     public String[] getMainCharacterAttackLeftModel() {
        return mainCharacterModelAttackingLeft;
    }
     public String[] getMainCharacterAttackRightModel() {
        return mainCharacterModelAttackRight1;
    }

     public boolean isAttackingUp() {
        return attackingUp;
     }
    public boolean isAttackingDown() {
        return attackingDown;
    }
    public boolean isAttackingLeft() {
        return attackingLeft;
    }
    public boolean isAttackingRight() {
        return attackingRight;
    }

     public void setAttackingUp(boolean k) {
        attackingUp = k;
     }
    public void setAttackingLeft(boolean k) {
        attackingLeft = k;
    }
    public void setAttackingRight(boolean k) {
        attackingRight = k;
    }
    public void setAttackingDown(boolean k) {
        attackingDown = k;
    }
}
