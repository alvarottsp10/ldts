package g1304.Runner.Controller;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import g1304.Runner.Model.MenuController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MenuKeyProcessorTest {

    @Test
    void processKey_ArrowUpInExitGame_StateChangesToInstructions() {
        MenuController menuControllerMock = mock(MenuController.class);
        when(menuControllerMock.getOption()).thenReturn("Exit Game");
        MenuKeyProcessor menuKeyProcessor = new MenuKeyProcessor(menuControllerMock);
        KeyStroke keyStroke = createKeyStroke(KeyType.ArrowUp);


        menuKeyProcessor.ProcessKey(keyStroke);


        verify(menuControllerMock, times(1)).getOption();
        verify(menuControllerMock, times(1)).setOption("Instructions");
    }


    @Test
    void processKey_ArrowDownInStartGame_StateChangesToInstructions() {
        MenuController menuControllerMock = mock(MenuController.class);
        when(menuControllerMock.getOption()).thenReturn("Start Game");
        MenuKeyProcessor menuKeyProcessor = new MenuKeyProcessor(menuControllerMock);
        KeyStroke keyStroke = createKeyStroke(KeyType.ArrowDown);

        menuKeyProcessor.ProcessKey(keyStroke);

        verify(menuControllerMock, times(1)).getOption();
        verify(menuControllerMock, times(1)).setOption("Instructions");
    }


    private KeyStroke createKeyStroke(KeyType keyType) {
        return new KeyStroke(keyType);
    }
}