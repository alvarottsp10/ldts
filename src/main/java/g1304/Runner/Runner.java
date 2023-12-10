package g1304.Runner;


import g1304.Runner.Controller.MenuController;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;

public class Runner {
        State state;
    public void RunGame() {
        MenuController menuController = new MenuController();
        menuController.StartMenu();

    }

}
