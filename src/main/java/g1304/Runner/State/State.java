package g1304.Runner.State;

import java.io.IOException;

public abstract class State {
    public abstract State nextState();

   public abstract void startState() throws IOException;

   public abstract boolean isRunning();
}
