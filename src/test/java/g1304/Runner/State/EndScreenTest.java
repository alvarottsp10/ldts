package g1304.Runner.State;

import g1304.Runner.State.EndScreen;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class EndScreenTest {

    @Test
    void testNextState() {
        EndScreen endScreen = new EndScreen();
        assertNull(endScreen.nextState());
    }

    @Test
    void testStartState() {
        EndScreen endScreen = new EndScreen();
        SystemOutRedirect systemOutRedirect = new SystemOutRedirect();
        systemOutRedirect.start();
        endScreen.startState();
        systemOutRedirect.stop();
        String printedOutput = systemOutRedirect.getOutput();
        assertTrue(printedOutput.contains("Congratulations you beat the tower"));
    }

    @Test
    void testIsRunning() {
        EndScreen endScreen = new EndScreen();
        assertTrue(endScreen.isRunning()); // The isRunning method always returns true
    }
}

class SystemOutRedirect {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    public void start() {
        System.setOut(new PrintStream(outputStream));
    }

    public void stop() {
        System.setOut(originalOut);
    }

    public String getOutput() {
        return outputStream.toString();
    }
}