package g1304.Runner.KeyProcessor;

import com.googlecode.lanterna.input.KeyStroke;
import g1304.Runner.State.MenuState;

public class MenuKeyProcessor {
    MenuState menuState;

    public void ProcessKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp -> {
                if(menuState.getState().equals("Exit Game")) {
                    menuState.setState("Start Game");
                }
            }
            case ArrowDown -> {
                if (menuState.getState().equals("Start Game")) {
                    menuState.setState("Exit Game");
                }
            }
        }
    }

    public MenuKeyProcessor(MenuState menuState1) {
        menuState = menuState1;
    }

}
