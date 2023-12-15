package g1304.Runner.Controller;

import com.googlecode.lanterna.input.KeyStroke;

public class GameOverKeyProcessor {
    String state = "Restart Game";
    public void ProcessKey(KeyStroke key) {
        switch (key.getKeyType()) {
            case ArrowUp -> {
                if(state.equals("Exit Game")) {
                    state = "Restart Game";
                }
            }
            case ArrowDown -> {
                if (state.equals("Restart Game")) {
                    state = "Exit Game";
                }
            }
        }
    }

    public String GetOption() {
        return state;
    }
}
