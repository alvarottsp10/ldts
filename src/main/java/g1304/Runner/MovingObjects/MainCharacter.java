package g1304.Runner.MovingObjects;

public class MainCharacter {
    int x = 50;
    int y = 20;

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
        y -= 3;
    }

    public void MoveHeroDown() {
        y += 3;
    }

    public void MoveHeroLeft() {
        x -= 3;
    }

    public void MoveHeroRight() {
        x += 3;
    }

    public int HeroX() {
        return x;
    }

    public int HeroY() {
        return y;
    }


}
