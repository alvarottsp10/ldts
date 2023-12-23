package g1304.Runner.Controller;

import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOverKeyProcessorTest {

    @Test
    void processKey_ArrowUpInExitGame_StateChangesToRestartGame() {
        GameOverKeyProcessor gameOverKeyProcessor = new GameOverKeyProcessor();
        KeyStroke keyStroke = createKeyStroke(KeyType.ArrowUp);
        gameOverKeyProcessor.ProcessKey(keyStroke);
        assertEquals("Restart Game", gameOverKeyProcessor.GetOption());
    }

    @Test
    void processKey_ArrowDownInRestartGame_StateChangesToExitGame() {
        GameOverKeyProcessor gameOverKeyProcessor = new GameOverKeyProcessor();
        KeyStroke keyStroke = createKeyStroke(KeyType.ArrowDown);
        gameOverKeyProcessor.ProcessKey(keyStroke);

        assertEquals("Exit Game", gameOverKeyProcessor.GetOption());
    }

    @Test
    void getOption_InitialState_ReturnsRestartGame() {
        GameOverKeyProcessor gameOverKeyProcessor = new GameOverKeyProcessor();

        String option = gameOverKeyProcessor.GetOption();

        assertEquals("Restart Game", option);
    }

    private KeyStroke createKeyStroke(KeyType keyType) {
        return new KeyStroke(keyType);
    }
}