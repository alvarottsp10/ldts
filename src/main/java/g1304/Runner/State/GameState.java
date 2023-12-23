package g1304.Runner.State;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFrame;
import g1304.Runner.Model.Builders.GameMap;
import g1304.Runner.Model.Builders.ScreenBuilder;
import g1304.Runner.Model.CharacterController;
import g1304.Runner.Controller.GameKeyProcessor;
import g1304.Runner.Model.MovingObjects.AttackController;
import g1304.Runner.Model.MovingObjects.MainCharacter;
import g1304.Runner.Model.MovingObjects.Monsters.SlimeCollision;
import g1304.Runner.Music;

import java.io.IOException;

public class GameState extends State{
    int level;
    private Music music;
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

    public GameState(TerminalScreen screen, ScreenBuilder screenBuilder, GameMap map, MainCharacter mainCharacter, AttackController attackController, GameKeyProcessor keyProcessor, CharacterController characterController, TextGraphics graphics, SlimeCollision slimeCollision) {
        super();
    }


    @Override
    public State nextState() {
        try {
            screen.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (levelCleared()) {
            if (level > 3) {
                return new EndScreen(music);
            }
            return new GameState(music,level + 1);
        }
        else {
            return new GameOverState(music, level);
        }
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
        music.loadSound("CeltaIsraelita.wav");
        music.start();
        run();
    }

    @Override
    public boolean isRunning() {
        return running;
    }

    public GameState(Music music1, int level_) {
        music = music1;
        level = level_;
    }


    public void run() {

        while(true) {
            update();
            slimeCollision.CheckCollisions();
            draw();
            if (mainCharacter.getLives() <= 0 || levelCleared()) {
                running = false;
                map.StopMonsters();
                try {
                    music.stop();
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
        if (mainCharacter.isAttackingUp()) {
            drawing = mainCharacter.getMainCharacterAttackUpModel();
            for (String s : drawing){
                for (int x = 0; x < s.length(); x++) {
                    if(s.charAt(x) =='#') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("blue"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x, mainCharacter.HeroY() + y -8 ), new TerminalSize(1, 1), ' ');
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

        else if (mainCharacter.isAttackingLeft()) {
            drawing = mainCharacter.getMainCharacterAttackLeftModel();
            for (String s : drawing){
                for (int x = 0; x < s.length(); x++) {
                    if(s.charAt(x) =='#') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("blue"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x - 16, mainCharacter.HeroY() + y ), new TerminalSize(1, 1), ' ');
                    }
                    if(s.charAt(x) =='X') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("red"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x - 16, mainCharacter.HeroY() + y ), new TerminalSize(1, 1), ' ');
                    }
                    if(s.charAt(x) =='Y') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("white"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x - 16, mainCharacter.HeroY() + y ), new TerminalSize(1, 1), ' ');
                    }
                    if(s.charAt(x) =='%') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("yellow"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x - 16, mainCharacter.HeroY() + y ), new TerminalSize(1, 1), ' ');
                    }
                    if(s.charAt(x) =='S') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("red"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x - 16, mainCharacter.HeroY() + y ), new TerminalSize(1, 1), ' ');
                    }

                    if(s.charAt(x) =='H') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("yellow"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x - 16, mainCharacter.HeroY() + y ), new TerminalSize(1, 1), ' ');
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

        else if (mainCharacter.isAttackingDown()) {
            drawing = mainCharacter.getMainCharacterAttackDownModel();
            for (String s : drawing){
                for (int x = 0; x < s.length(); x++) {
                    if(s.charAt(x) =='#') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("blue"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x , mainCharacter.HeroY() + y ), new TerminalSize(1, 1), ' ');
                    }
                    if(s.charAt(x) =='X') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("red"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x , mainCharacter.HeroY() + y ), new TerminalSize(1, 1), ' ');
                    }
                    if(s.charAt(x) =='Y') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("white"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x , mainCharacter.HeroY() + y ), new TerminalSize(1, 1), ' ');
                    }
                    if(s.charAt(x) =='%') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("yellow"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x , mainCharacter.HeroY() + y ), new TerminalSize(1, 1), ' ');
                    }
                    if(s.charAt(x) =='S') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("red"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x , mainCharacter.HeroY() + y ), new TerminalSize(1, 1), ' ');
                    }

                    if(s.charAt(x) =='H') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("yellow"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x, mainCharacter.HeroY() + y ), new TerminalSize(1, 1), ' ');
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

        else if (mainCharacter.isAttackingRight()) {
            drawing = mainCharacter.getMainCharacterAttackRightModel();
            for (String s : drawing){
                for (int x = 0; x < s.length(); x++) {
                    if(s.charAt(x) =='#') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("blue"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x , mainCharacter.HeroY() + y ), new TerminalSize(1, 1), ' ');
                    }
                    if(s.charAt(x) =='X') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("red"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x , mainCharacter.HeroY() + y), new TerminalSize(1, 1), ' ');
                    }
                    if(s.charAt(x) =='Y') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("white"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x , mainCharacter.HeroY() + y ), new TerminalSize(1, 1), ' ');
                    }
                    if(s.charAt(x) =='%') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("yellow"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x , mainCharacter.HeroY() + y ), new TerminalSize(1, 1), ' ');
                    }
                    if(s.charAt(x) =='S') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("red"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x , mainCharacter.HeroY() + y ), new TerminalSize(1, 1), ' ');
                    }

                    if(s.charAt(x) =='H') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("yellow"));
                        graphics.fillRectangle(new TerminalPosition(mainCharacter.HeroX() + x, mainCharacter.HeroY() + y ), new TerminalSize(1, 1), ' ');
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

    public boolean levelCleared() {
        return map.allSlimesDied();
    }
}
