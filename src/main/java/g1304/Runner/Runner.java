package g1304.Runner;


import g1304.Runner.State.MenuState;
import g1304.Runner.State.State;

import java.awt.*;
import java.io.IOException;

public class Runner {
    State state;
    public void RunGame() throws IOException {
        state = new MenuState();
        while(state != null) {
            state.startState();
            while (state.isRunning()) {

            }
            state = state.nextState();
        }

    }

}
