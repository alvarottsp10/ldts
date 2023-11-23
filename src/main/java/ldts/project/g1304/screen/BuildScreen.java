package ldts.project.g1304.screen;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class BuildScreen {
    final int originalTileSize = 16; //We will be creating 16*16 tiles, characters and mobs
    final int scale = 3; //We will scale it three times, so it does not look too tiny in modern pcs resolution
    final int tileSize = originalTileSize * scale; //Displayed size: 42*42
    final int columns = 16; //Columns of 16 tiles
    final int rows = 12; //Rows of 12 tiles
    final int screenWidth = tileSize * columns; // 768 pixels
    final int screenHeight = tileSize * rows; // 576 pixels


    //Creates Screen with the desired dimensions
    public TerminalScreen createScreen() {
        try {
            // Create a default terminal factory
            DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
            // Set the terminal size (width, height) in characters
            terminalFactory.setInitialTerminalSize(new TerminalSize(screenWidth, screenHeight));
            // Create a terminal instance
            Terminal terminal = terminalFactory.createTerminal();
            return new TerminalScreen(terminal); //return a screen with the desired dimensions
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
