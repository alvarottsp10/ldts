package g1304.Runner.Viewer;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import g1304.Runner.Controller.GameOverKeyProcessor;

import java.io.IOException;

public class GameOverViewer {

    TerminalScreen screen;

    GameOverKeyProcessor gameOverKeyProcessor;
    TextGraphics graphics;

    public static final String[] GameOverModel= {
            "###                     ###",
            "#                      #   #",
            "# ##  ## ####  ###     #   # # # ### ###",
            "#  # # # # # # # #     #   # # # # # #",
            "###  ### # # # ##       ###   #  ##  #",
    };

    public static final String[] RestartModel= {
            "####       #",
            "#   #      #",
            "####  ### ### ### #  #",
            "# #   # #  #  #   #  #",
            "#  ## ##   ## #    ###",
            "                     #",
            "                   ###",
    };

    public static final String[] ExitModel = {
            "#### #   # ### ######",
            "#     # #   #    ##",
            "###    #    #    ##",
            "#     # #   #    ##",
            "#### #   # ###   ##",
    };


    public void DrawMenu() throws IOException {
        if (gameOverKeyProcessor.GetOption().equals("Restart Game")) {
            graphics.setForegroundColor(TextColor.Factory.fromString("yellow"));
        } else {
            graphics.setForegroundColor(TextColor.Factory.fromString("white"));
        }
        graphics.putString(12, 10, "Retry");
        screen.refresh();
        if (gameOverKeyProcessor.GetOption().equals("Exit Game")) {
            graphics.setForegroundColor(TextColor.Factory.fromString("yellow"));
        } else {
            graphics.setForegroundColor(TextColor.Factory.fromString("white"));
        }
        graphics.putString(12, 20, "Exit");
            screen.refresh();
    }

    public GameOverViewer(GameOverKeyProcessor gameOverKeyProcessor1, TerminalScreen screen1, TextGraphics graphics1) {
        gameOverKeyProcessor = gameOverKeyProcessor1;
        screen = screen1;
        graphics = graphics1;
    }

}
