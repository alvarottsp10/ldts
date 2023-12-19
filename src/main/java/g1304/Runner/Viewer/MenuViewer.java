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
        int y = 10;
        screen.clear();
        if (menuController.getOption().equals("Start Game")) {
            graphics.setForegroundColor(TextColor.Factory.fromString("yellow"));
        } else {
            graphics.setForegroundColor(TextColor.Factory.fromString("white"));
        }
        graphics.putString(12, 10, "Start");
        if (menuController.getOption().equals("Instructions")) {
            graphics.setForegroundColor(TextColor.Factory.fromString("yellow"));
        } else {
            graphics.setForegroundColor(TextColor.Factory.fromString("white"));
        }
        graphics.putString(12, 15, "Instructions");
        if (menuController.getOption().equals("Exit Game")) {
            graphics.setForegroundColor(TextColor.Factory.fromString("yellow"));
        } else {
            graphics.setForegroundColor(TextColor.Factory.fromString("white"));
        }
        graphics.putString(12, 20, "Exit");
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


