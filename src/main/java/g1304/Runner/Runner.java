package g1304.Runner;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import g1304.Runner.KeyProcessor;
import g1304.Runner.MovingObjects.MainCharacter;

import java.awt.*;
import java.awt.Menu;
import java.io.IOException;

public class Runner implements Runnable{
    TerminalScreen screen;
    TextGraphics graphics;
    Thread gameTimeFlow;
    KeyProcessor keyProcessor;
    java.awt.Menu menu = new Menu();
    int FPS = 60;
    MainCharacter mainCharacter = new MainCharacter();
    public void runGame() {
        try {
            Font font = new Font(Font.MONOSPACED, Font.PLAIN, 2);
            AWTTerminalFontConfiguration cfg = new SwingTerminalFontConfiguration(true, AWTTerminalFontConfiguration.BoldMode.NOTHING, font);
            Terminal terminal = new DefaultTerminalFactory().setInitialTerminalSize(new TerminalSize(468, 335)).setTerminalEmulatorFontConfiguration(cfg).createTerminal();
            keyProcessor = new KeyProcessor();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);   // We don't need a cursor
            screen.startScreen();             // Screens must be started
            screen.doResizeIfNecessary();     // Resize screen if necessary
            screen.clear();
            graphics=screen.newTextGraphics();
            startGameTimeFlow();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }// Represents the time in the game

    //Starts the time flow of the game
    public void startGameTimeFlow() {
        gameTimeFlow = new Thread(this);
        gameTimeFlow.start();
    }

    public void startGame(int state) {
        startGameTimeFlow();
    }

    @Override
    public void run() {

        double  drawCooldown =  1000000000/FPS;
        double  nextDrawTime = System.nanoTime() + drawCooldown;


        while(gameTimeFlow != null) {
            update();

            draw();
        }
    }

    public void draw() {
        screen.clear();
        String[] drawing;
        if (keyProcessor.actionsToProcess.isEmpty()) {
            drawing = MainCharacter.mainCharacterModel;
        }
        else {
            drawing = MainCharacter.mainCharacterModelWalking;
        }
            int y = 0;
            for (String s : drawing){
                for (int x = 0; x < s.length(); x++) {
                    if(s.charAt(x) =='#') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("blue"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x, mainCharacter.HeroY() + y+1), new TerminalSize(2, 1), ' ');
                    }
                    if(s.charAt(x) =='X') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("red"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x, mainCharacter.HeroY() + y+1), new TerminalSize(2, 1), ' ');
                    }
                    if(s.charAt(x) =='Y') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("white"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x, mainCharacter.HeroY() + y+1), new TerminalSize(2, 1), ' ');
                    }
                    if(s.charAt(x) =='H') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("yellow"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x, mainCharacter.HeroY() + y+1), new TerminalSize(2, 1), ' ');
                    }
                    if(s.charAt(x) =='%') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("green"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x, mainCharacter.HeroY() + y+1), new TerminalSize(2, 1), ' ');
                    }
                }
                y++;
            }
        try {
            screen.refresh();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update() {
        try {
            keyProcessor.recieveKey(screen.pollInput());
            keyProcessor.processKey( mainCharacter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
