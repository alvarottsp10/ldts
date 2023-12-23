package g1304.Runner.State;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import g1304.Runner.Controller.MenuKeyProcessor;
import g1304.Runner.Model.Builders.ScreenBuilder;
import g1304.Runner.Model.MenuController;
import g1304.Runner.Music;
import g1304.Runner.Viewer.InstructionViewer;
import g1304.Runner.Viewer.MenuViewer;

import java.io.IOException;

public class InstructionState extends State{
    MenuController menuController;
    Music music;
    TerminalScreen screen;
    InstructionViewer instructionViewer;
    ScreenBuilder screenBuilder = new ScreenBuilder();
    TextGraphics graphics;
    boolean running = true;

    public InstructionState(Music music1, ScreenBuilder screenBuilder, InstructionViewer instructionViewer) {
        music = music1;
    }

    public InstructionState(Music music1) {
        music = music1;
    }

    public InstructionState(ScreenBuilder screenBuilder, InstructionViewer instructionViewer) {
        super();
    }

    public InstructionState() {

    }

    @Override
    public State nextState() {
        return new MenuState(music);
    }

    @Override
    public void startState() throws IOException {
        screen = screenBuilder.buildMenuScreen();
        graphics = screen.newTextGraphics();
        instructionViewer = new InstructionViewer(screen, graphics);
        instructionViewer.draw();
        while(true) {
            try {
                KeyStroke key = screen.readInput();
                if(key.getKeyType() == KeyType.Escape) {
                    running = false;
                    screen.close();
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
