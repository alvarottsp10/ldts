package ldts.project.g1304;


import ldts.project.g1304.screen.BuildScreen;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Game {
    public static void main(String[] args) {
        try {
            BuildScreen buildScreen = new BuildScreen();
            Screen screen = buildScreen.createScreen();// Create a screen using DefaultScreenFactory
            screen.startScreen();// Start the screen
            buildScreen.startGameTimeFlow();
            screen.setCursorPosition(null);// N o cursor needed
            screen.clear();// Clear the screen
            screen.refresh();// Refresh the screen to display changes
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
