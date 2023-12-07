package g1304.Runner;

import com.googlecode.lanterna.input.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MenuKeyProcessor {
    MenuState menuState = new MenuState();

    void ProcessKey(KeyStroke key) {
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

}
