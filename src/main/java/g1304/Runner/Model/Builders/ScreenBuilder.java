package g1304.Runner.Model.Builders;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;

import java.awt.*;
import java.io.IOException;

public class ScreenBuilder {
    Screen screen;
    public TerminalScreen BuildGameScreen() {
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 2);
        AWTTerminalFontConfiguration cfg = new SwingTerminalFontConfiguration(true, AWTTerminalFontConfiguration.BoldMode.NOTHING, font);
        Terminal terminal = null;
        try {
            terminal = new DefaultTerminalFactory().setForceAWTOverSwing(true).setInitialTerminalSize(new TerminalSize(768, 576)).setTerminalEmulatorFontConfiguration(cfg).createTerminal();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        try {
            screen = new TerminalScreen(terminal);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        screen.setCursorPosition(null);   // We don't need a cursor
        try {
            screen.startScreen();// Screens must be started
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        screen.doResizeIfNecessary();     // Resize screen if necessary
        screen.clear();
        return (TerminalScreen) screen;
    }

    public TerminalScreen buildMenuScreen() {
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 2);
        AWTTerminalFontConfiguration cfg = new SwingTerminalFontConfiguration(true, AWTTerminalFontConfiguration.BoldMode.NOTHING, font);
        Terminal terminal = null;
        try {
            terminal = new DefaultTerminalFactory().setForceAWTOverSwing(true).setInitialTerminalSize(new TerminalSize(768, 576)).setTerminalEmulatorFontConfiguration(cfg).createTerminal();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        try {
            screen = new TerminalScreen(terminal);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        screen.setCursorPosition(null);// We don't need a cursor
        try {
            screen.startScreen();// Screens must be started
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        screen.doResizeIfNecessary();// Resize screen if necessary
        screen.clear();
        return (TerminalScreen) screen;
    }

}
