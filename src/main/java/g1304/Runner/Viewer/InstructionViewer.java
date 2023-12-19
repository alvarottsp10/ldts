package g1304.Runner.Viewer;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class InstructionViewer {
    TerminalScreen screen;
    TextGraphics graphics;

    public void draw() throws IOException {
        graphics.setForegroundColor(TextColor.Factory.fromString("white"));
        graphics.putString(1, 1, "<-ESC", SGR.BLINK);
        graphics.setForegroundColor(TextColor.Factory.fromString("yellow"));
        graphics.setForegroundColor(TextColor.Factory.fromString("white"));
        graphics.putString(5, 8, "The game goal is that the hero defeats all the");
        graphics.putString(5, 9, "monsters without dying. There are three different");
        graphics.putString(5, 10, "levels.");
        graphics.putString(3, 13, "          MOVES                AWSD");
        graphics.putString(3, 14, "          ATTACKS              ARROWS");
        graphics.putString(5, 27, "You can press ESC to go back to the Main Menu");
        screen.refresh();
    }


    public InstructionViewer (TerminalScreen screen1, TextGraphics graphics1) {
        screen = screen1;
        graphics = graphics1;
    }
}
