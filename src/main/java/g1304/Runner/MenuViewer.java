package g1304.Runner;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class MenuViewer {
    TextGraphics graphics;
    TerminalScreen screen;

    MenuState menuState = new MenuState();
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
        int y = 278;
        screen.clear();
        if (menuState.getState().equals("Start Game")) {
            graphics.setBackgroundColor(TextColor.Factory.fromString("yellow"));
        } else {
            graphics.setBackgroundColor(TextColor.Factory.fromString("white"));
        }
        for (String s : StartModel) {
            for (int x = 0; x < s.length(); x++) {
                if (s.charAt(x) == '#') {
                    graphics.fillRectangle(new TerminalPosition(x + 367, y + 1), new TerminalSize(1, 1), ' ');
                }
            }
            y++;
        }
        y = 278 + 15;
        if (menuState.getState().equals("Exit Game")) {
            graphics.setBackgroundColor(TextColor.Factory.fromString("yellow"));
        } else {
            graphics.setBackgroundColor(TextColor.Factory.fromString("white"));
        }
        for (String g : ExitModel) {
            for (int x = 0; x < g.length(); x++) {
                if (g.charAt(x) == '#') {
                    graphics.fillRectangle(new TerminalPosition(x + 367, y + 1), new TerminalSize(1, 1), ' ');
                }
            }
            y++;
        }
        try {
            screen.refresh();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    MenuViewer(TerminalScreen screen1, TextGraphics graphics1) {
        screen = screen1;
        graphics = graphics1;
    }
}


