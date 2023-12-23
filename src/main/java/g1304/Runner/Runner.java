package g1304.Runner;


import g1304.Runner.State.MenuState;
import g1304.Runner.State.State;

import java.awt.*;
import java.io.IOException;

public class Runner {
    Music music = new Music();
    State state;
    public void RunGame() throws IOException {
        state = new MenuState(music);
        while(state != null) {
            state.startState();
            while (state.isRunning()) {

            }
            state = state.nextState();
        }

    }

    public State getState() {
        return state;
    }
}
