package g1304.Runner.State;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import g1304.Runner.Viewer.MenuViewer;
import g1304.Runner.Model.Builders.ScreenBuilder;
import g1304.Runner.Model.MenuController;
import g1304.Runner.Controller.MenuKeyProcessor;

import java.io.IOException;

public class MenuState extends State {
    MenuController menuController;
    TerminalScreen screen;
    MenuKeyProcessor keyProcessor;
    MenuViewer menuViewer;
    ScreenBuilder screenBuilder = new ScreenBuilder();
    TextGraphics graphics;

    boolean running = true;



    @Override
    public void startState() {
        menuController = new MenuController();
        screen = screenBuilder.buildMenuScreen();
        keyProcessor = new MenuKeyProcessor(menuController);
        graphics = screen.newTextGraphics();
        menuViewer = new MenuViewer(screen, graphics, menuController);
        menuViewer.DrawMenu();
        while(true) {
            try {
                KeyStroke key = screen.readInput();
                if(key.getKeyType() == KeyType.Enter) {
                    running = false;
                    screen.close();
                    break;
                }
                keyProcessor.ProcessKey(key);
                menuViewer.DrawMenu();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public boolean isRunning() {
        return running;
    }


    @Override
    public State nextState() {
        if (menuController.getOption().equals("Start Game")) {
            return new GameState(1);
        }
        return null;
    }
}
