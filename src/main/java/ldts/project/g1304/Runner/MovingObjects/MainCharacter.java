package ldts.project.g1304.Runner.MovingObjects;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;

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
        y -= 5;
    }

    public void MoveHeroDown() {
        y += 5;
    }

    public void MoveHeroLeft() {
        x -= 5;
    }

    public void MoveHeroRight() {
        x += 5;
    }

    public int HeroX() {
        return x;
    }

    public int HeroY() {
        return y;
    }


}
