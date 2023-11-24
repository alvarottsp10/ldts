package ldts.project.g1304.Runner;

import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Menu {
    int option = 0;
    boolean startGame = true;
    boolean exitGame = false;

    public void MenuSelection(Screen screen) {
        while(true) {
            try {
                if (screen.readInput().getKeyType() == KeyType.ArrowDown && option == 0) {
                    option = 1;
                    startGame = false;
                    exitGame = true;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (screen.readInput().getKeyType() == KeyType.ArrowUp && option == 1) {
                    option = 0;
                    startGame = true;
                    exitGame = false;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                if (screen.readInput().getKeyType() == KeyType.Enter) {
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
