package g1304.Runner.State;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import g1304.Runner.Builders.GameMap;
import g1304.Runner.Builders.ScreenBuilder;
import g1304.Runner.Controller.CharacterController;
import g1304.Runner.Controller.SlimeController;
import g1304.Runner.KeyProcessor.GameKeyProcessor;
import g1304.Runner.MovingObjects.AttackController;
import g1304.Runner.MovingObjects.MainCharacter;
import g1304.Runner.MovingObjects.Monsters.SlimeCollision;

import java.io.IOException;

public class GameState extends State{
    int level;
    TerminalScreen screen;
    ScreenBuilder screenBuilder = new ScreenBuilder();
    GameMap map;
    MainCharacter mainCharacter;
    AttackController attackController;
    GameKeyProcessor keyProcessor;
    CharacterController characterController;
    TextGraphics graphics;
    SlimeCollision slimeCollision;
    boolean running = true;

    GameState() {

    };

    GameState(TerminalScreen terminalScreen1, ScreenBuilder screenBuilder1, GameMap map1, MainCharacter mainCharacter1, AttackController attackController1, GameKeyProcessor keyProcessor1, CharacterController characterController1, TextGraphics graphics1, SlimeCollision slimeCollision1) {
        screen = terminalScreen1;
        screenBuilder = screenBuilder1;
        map = map1;
        mainCharacter = mainCharacter1;
        attackController = attackController1;
        keyProcessor = keyProcessor1;
        characterController = characterController1;
        graphics = graphics1;
        slimeCollision = slimeCollision1;
    }


    @Override
    public State nextState() {
        try {
            screen.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return new GameOverState(level);
    }



    @Override
    public void startState() throws IOException {
        screen = screenBuilder.BuildGameScreen();
        map = new GameMap(level);
        map.ReadElements();
        mainCharacter =  map.mainCharacter;
        attackController = new AttackController(map.slimes, mainCharacter);
        keyProcessor = new GameKeyProcessor(mainCharacter, attackController );
        characterController = new CharacterController(mainCharacter, keyProcessor);
        graphics=screen.newTextGraphics();
        ((AWTTerminalFrame)screen.getTerminal()).getComponent(0).addKeyListener(keyProcessor);
        slimeCollision = new SlimeCollision(mainCharacter, map.slimes);
        map.StartMonsters();
        run();
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    public GameState(int level_) {
        level = level_;
    }


    public void run() {

        while(true) {
            update();
            slimeCollision.CheckCollisions();
            draw();
            if (mainCharacter.getLives() <= 0) {
                running = false;
                map.StopMonsters();
                try {
                    screen.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            }
        }
    }


    public void draw() {
        screen.clear();
        map.Draw(graphics);
        String[] drawing;

        drawing = mainCharacter.getCurrentSprite();
        int y = 0;
        if (mainCharacter.isAttacking()) {
            drawing = mainCharacter.getMainCharacterAttackUpModel();
            for (String s : drawing){
                for (int x = 0; x < s.length(); x++) {
                    if(s.charAt(x) =='#') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("blue"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x, mainCharacter.HeroY() + y -8), new TerminalSize(1, 1), ' ');
                    }
                    if(s.charAt(x) =='X') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("red"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x, mainCharacter.HeroY() + y -8), new TerminalSize(1, 1), ' ');
                    }
                    if(s.charAt(x) =='Y') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("white"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x, mainCharacter.HeroY() + y - 8), new TerminalSize(1, 1), ' ');
                    }
                    if(s.charAt(x) =='R') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("yellow"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x, mainCharacter.HeroY() + y - 8), new TerminalSize(1, 1), ' ');
                    }
                    if(s.charAt(x) =='S') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("black"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x, mainCharacter.HeroY() + y - 8), new TerminalSize(1, 1), ' ');
                    }

                    if(s.charAt(x) =='H') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("green"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x, mainCharacter.HeroY() + y - 8), new TerminalSize(1, 1), ' ');
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
        else  {
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

    }

    public void update() {
        characterController.MoveCharacter();
    }
}
