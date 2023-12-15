package g1304.Runner.Viewer;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import g1304.Runner.Model.MenuController;

import java.io.IOException;

public class MenuViewer {
    TextGraphics graphics;
    TerminalScreen screen;

    MenuController menuController;
    public static final String[] StartModel= {
            " #####  #####  #####  #####  #####",
            "##        #   ##   ## ##   #   #",
            " ####     #   ####### #####    #",
            "    ##    #   ##   ## ##  ##   #",
            " ####     #   ##   ## ##   ##  #",
    };

    public static final String[] ExitModel = {
            "#### #   # ### ######",
            "#     # #   #    ##",
            "###    #    #    ##",
            "#     # #   #    ##",
            "#### #   # ###   ##",
    };

    public void DrawMenu() {
        int y = 100;
        screen.clear();
        if (menuController.getOption().equals("Start Game")) {
            graphics.setBackgroundColor(TextColor.Factory.fromString("yellow"));
        } else {
            graphics.setBackgroundColor(TextColor.Factory.fromString("white"));
        }
        for (String s : StartModel) {
            for (int x = 0; x < s.length(); x+= 1) {
                if (s.charAt(x) == '#') {
                    graphics.fillRectangle(new TerminalPosition(x + 367, y + 1), new TerminalSize(1, 1), ' ');
                }
            }
            y+= 1;
        }
        y = 200;
        if (menuController.getOption().equals("Exit Game")) {
            graphics.setBackgroundColor(TextColor.Factory.fromString("yellow"));
        } else {
            graphics.setBackgroundColor(TextColor.Factory.fromString("white"));
        }
        for (String g : ExitModel) {
            for (int x = 0; x < g.length(); x += 1) {
                if (g.charAt(x) == '#') {
                    graphics.fillRectangle(new TerminalPosition(x + 367, y + 1), new TerminalSize(1, 1), ' ');
                }
            }
            y+= 1;
        }
        try {
            screen.refresh();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public MenuViewer(TerminalScreen screen1, TextGraphics graphics1, MenuController menuController1) {
        screen = screen1;
        graphics = graphics1;
        menuController = menuController1;
    }
}


