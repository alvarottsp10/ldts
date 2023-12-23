package g1304.Runner.State;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import g1304.Runner.Model.Builders.ScreenBuilder;
import g1304.Runner.Controller.GameOverKeyProcessor;
import g1304.Runner.Music;
import g1304.Runner.Viewer.GameOverViewer;

import java.io.IOException;

public class GameOverState extends State{
    TerminalScreen screen;
    Music music;
    TextGraphics graphics;
    int level;

    ScreenBuilder screenBuilder = new ScreenBuilder();
    GameOverViewer gameOverViewer;
    GameOverKeyProcessor gameOverKeyProcessor;

    boolean running = true;

    @Override
    public State nextState() {
        if (gameOverKeyProcessor.GetOption().equals("Restart Game")) {
            return new GameState(music, level);
        }
        return null;
    }

    @Override
    public void startState() throws IOException {
        screen = screenBuilder.buildMenuScreen();
        graphics = screen.newTextGraphics();
        gameOverKeyProcessor = new GameOverKeyProcessor();
        gameOverViewer = new GameOverViewer(gameOverKeyProcessor, screen, graphics);
        gameOverViewer.DrawMenu();
        while(true) {
            try {
                KeyStroke key = screen.readInput();
                if(key.getKeyType() == KeyType.Enter) {
                    running = false;
                    screen.close();
                    break;

                }
                gameOverKeyProcessor.ProcessKey(key);
                gameOverViewer.DrawMenu();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean isRunning() {
        return false;
    }

    GameOverState(Music music1, int Level) {
        music = music1;
        level = Level;
    }

}
