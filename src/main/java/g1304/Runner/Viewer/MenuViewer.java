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


    public void DrawMenu() {
        screen.clear();
        graphics.setForegroundColor(TextColor.Factory.fromString("red"));
        graphics.putString(8, 0, "__________                    ___________         ");
        graphics.putString(8, 1, "\\____    /___________  ____  \\__    ___/___    ");
        graphics.putString(8, 2, "  /     // __ \\_  __ \\/  _ \\    |    | /  _ \\   ");
        graphics.putString(8, 3, " /     /\\  ___/|  | \\(  <_> )   |    |(  <_> ) ");
        graphics.putString(8, 4, "/_______ \\___  >__|   \\____/    |____| \\____/ ");
        graphics.putString(8, 5, "        \\/   \\/                             ");
        graphics.putString(15, 6, "  ___ ___                      ");
        graphics.putString(15, 7, " /   |   \\  ___________  ____ ");
        graphics.putString(15, 8, "/    ~    _/ __ \\_  __ \\/  _ \\ ");
        graphics.putString(15, 9, "\\    Y    \\  ___/|  | \\(  <_> )");
        graphics.putString(15, 10, " \\___|_  / \\___  |__|   \\____/ ");
        graphics.putString(15, 11, "        \\/      \\/               ");

        if (menuController.getOption().equals("Start Game")) {
            graphics.setForegroundColor(TextColor.Factory.fromString("yellow"));
        } else {
            graphics.setForegroundColor(TextColor.Factory.fromString("white"));
        }
        graphics.putString(12, 15, "Start");
        if (menuController.getOption().equals("Instructions")) {
            graphics.setForegroundColor(TextColor.Factory.fromString("yellow"));
        } else {
            graphics.setForegroundColor(TextColor.Factory.fromString("white"));
        }
        graphics.putString(12, 20, "Instructions");
        if (menuController.getOption().equals("Exit Game")) {
            graphics.setForegroundColor(TextColor.Factory.fromString("yellow"));
        } else {
            graphics.setForegroundColor(TextColor.Factory.fromString("white"));
        }
        graphics.putString(12, 25, "Exit");
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


