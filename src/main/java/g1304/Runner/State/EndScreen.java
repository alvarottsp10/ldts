package g1304.Runner.State;

import g1304.Runner.Music;

public class EndScreen extends State{
    boolean running = true;
    Music music;

    EndScreen(Music music1) {
        music = music1;
    }

    public EndScreen() {

    }

    @Override
    public State nextState() {
        return null;
    }

    @Override
    public void startState() {
        System.out.println("Congratulations you beat the tower");

    }

    @Override
    public boolean isRunning() {
        return running;
    }


}
