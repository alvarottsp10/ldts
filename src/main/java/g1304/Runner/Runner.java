package g1304.Runner;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFontConfiguration;
import g1304.Runner.MovingObjects.AttackController;
import g1304.Runner.MovingObjects.MainCharacter;

import java.awt.*;
import java.awt.Menu;
import java.io.IOException;

public class Runner implements Runnable{
    TerminalScreen screen;
    TextGraphics graphics;
    GameMap map = new GameMap();

    
    Thread gameTimeFlow;
    KeyProcessor keyProcessor;
    AttackController attackController;
    MainCharacter mainCharacter;
    SlimeCollision slimeCollision;
    CharacterController characterController;
    java.awt.Menu menu = new Menu();
    int FPS = 60;
    
    public void runGame() {
            Font font = new Font(Font.MONOSPACED, Font.PLAIN, 2);
            AWTTerminalFontConfiguration cfg = new SwingTerminalFontConfiguration(true, AWTTerminalFontConfiguration.BoldMode.NOTHING, font);
        Terminal terminal = null;
        try {
            terminal = new DefaultTerminalFactory().setForceAWTOverSwing(true).setInitialTerminalSize(new TerminalSize(768, 576)).setTerminalEmulatorFontConfiguration(cfg).createTerminal();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        map.ReadElements();
        mainCharacter =  new MainCharacter(48,160, map);
        attackController = new AttackController(map.slimes, mainCharacter);
        keyProcessor = new KeyProcessor(mainCharacter, attackController);
        characterController = new CharacterController(mainCharacter, keyProcessor);
        try {
            screen = new TerminalScreen(terminal);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        ((AWTTerminalFrame)screen.getTerminal()).getComponent(0).addKeyListener(keyProcessor);
            screen.setCursorPosition(null);   // We don't need a cursor
        try {
            screen.startScreen();// Screens must be started
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        screen.doResizeIfNecessary();     // Resize screen if necessary
            screen.clear();
            graphics=screen.newTextGraphics();
            slimeCollision = new SlimeCollision(mainCharacter, map.slimes);
            startGameTimeFlow();
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
            slimeCollision.CheckCollisions();

            draw();


            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void draw() {
        screen.clear();
        map.Draw(graphics);
        String[] drawing;

        drawing = mainCharacter.getCurrentSprite();
            int y = 0;
            for (String s : drawing){
                for (int x = 0; x < s.length(); x++) {
                    if(s.charAt(x) =='#') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("blue"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x, mainCharacter.HeroY() + y+1), new TerminalSize(1, 1), ' ');
                    }
                    if(s.charAt(x) =='X') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("red"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x, mainCharacter.HeroY() + y+1), new TerminalSize(1, 1), ' ');
                    }
                    if(s.charAt(x) =='Y') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("white"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x, mainCharacter.HeroY() + y+1), new TerminalSize(1, 1), ' ');
                    }
                    if(s.charAt(x) =='H') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("yellow"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x, mainCharacter.HeroY() + y+1), new TerminalSize(1, 1), ' ');
                    }
                    if(s.charAt(x) =='%') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("green"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x, mainCharacter.HeroY() + y+1), new TerminalSize(1, 1), ' ');
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
        characterController.MoveCharacter();
    }
}
