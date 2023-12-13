package g1304.Runner.KeyProcessor;

import com.googlecode.lanterna.input.KeyStroke;
import g1304.Runner.Controller.MenuController;
import g1304.Runner.State.MenuState;

public class MenuKeyProcessor {
    MenuController menuController;

    public void ProcessKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp -> {
                if(menuController.getOption().equals("Exit Game")) {
                    menuController.setOption("Start Game");
                }
            }
            case ArrowDown -> {
                if (menuController.getOption().equals("Start Game")) {
                    menuController.setOption("Exit Game");
                }
            }
        }
    }

    public MenuKeyProcessor(MenuController menuController1) {
        menuController = menuController1;
    }

}
