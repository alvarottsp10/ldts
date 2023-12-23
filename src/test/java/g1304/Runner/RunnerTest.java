package g1304.Runner;

import g1304.Runner.State.MenuState;
import g1304.Runner.State.State;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

import static org.mockito.Mockito.*;

class RunnerTest {

    @Test
    void testRunGame() throws IOException {
        State mockState = Mockito.mock(MenuState.class);
        when(mockState.isRunning()).thenReturn(false);


        Runner runner = spy(new Runner());
        doReturn(mockState).when(runner).getState();

        runner.RunGame();

        verify(mockState, times(1)).startState();
        verify(mockState, times(1)).nextState();
    }
}