package g1304.Runner;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import g1304.Runner.MovingObjects.AttackController;
import g1304.Runner.MovingObjects.MainCharacter;

import java.io.IOException;

public class GameController implements Runnable {
    ScreenBuilder screenBuilder = new ScreenBuilder();
    TerminalScreen screen;
    TextGraphics graphics;
    GameMap map = new GameMap();
    Thread gameTimeFlow;
    GameKeyProcessor keyProcessor;
    AttackController attackController;
    MainCharacter mainCharacter;
    SlimeCollision slimeCollision;
    CharacterController characterController;
    int FPS = 60;

    public void StartState() {
        screen = screenBuilder.BuildGameScreen();
        map.ReadElements();
        mainCharacter =  new MainCharacter(48,160, map);
        attackController = new AttackController(map.slimes, mainCharacter);
        keyProcessor = new GameKeyProcessor(mainCharacter, attackController );
        characterController = new CharacterController(mainCharacter, keyProcessor);
        graphics=screen.newTextGraphics();
        ((AWTTerminalFrame)screen.getTerminal()).getComponent(0).addKeyListener(keyProcessor);
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
