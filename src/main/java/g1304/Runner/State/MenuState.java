package g1304.Runner.State;

public class MenuState extends State{
    String state = "Start Game";
    public void setState(String state1) {
        state = state1;
    }

    public String getState() {
        return state;
    }

    @Override
    public State NextState() {
        return null;
    }
}
