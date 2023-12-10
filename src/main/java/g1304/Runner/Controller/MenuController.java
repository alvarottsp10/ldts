package g1304.Runner.Controller;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import g1304.Runner.KeyProcessor.MenuKeyProcessor;
import g1304.Runner.Builders.MenuViewer;
import g1304.Runner.Builders.ScreenBuilder;
import g1304.Runner.State.MenuState;

import java.io.IOException;

public class MenuController {
    MenuViewer menuViewer;
    ScreenBuilder screenBuilder = new ScreenBuilder();
    TerminalScreen screen;
    TextGraphics graphics;

    MenuKeyProcessor keyProcessor;
    GameController gameController = new GameController();
    MenuState menuState = new MenuState();


    public void StartMenu() {
          screen = screenBuilder.BuildGameScreen();
          keyProcessor = new MenuKeyProcessor(menuState);
          graphics = screen.newTextGraphics();
          menuViewer = new MenuViewer(screen, graphics, menuState);
          menuViewer.DrawMenu();
          while(true) {
              try {
                  KeyStroke key = screen.readInput();
                  if(key.getKeyType() == KeyType.Enter) {
                      screen.close();
                      break;

                  }
                  keyProcessor.ProcessKey(key);
                  menuViewer.DrawMenu();
              } catch (IOException e) {
                  throw new RuntimeException(e);
              }
          }
          gameController.StartState();
    }



}
