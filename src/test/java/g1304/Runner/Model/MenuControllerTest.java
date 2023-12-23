package g1304.Runner.Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MenuControllerTest {

    @Test
    void testSetAndGetOption() {
        // Create MenuController instance
        MenuController menuController = new MenuController();

        // Test initial option
        assertEquals("Start Game", menuController.getOption());

        // Test setOption and getOption
        menuController.setOption("New Game");
        assertEquals("New Game", menuController.getOption());

        // Test again with a different option
        menuController.setOption("Load Game");
        assertEquals("Load Game", menuController.getOption());
    }
}