package g1304.Runner.State;

public class EndScreen extends State{
    boolean running = true;
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
