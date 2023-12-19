package g1304.Runner.Viewer;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import g1304.Runner.Model.Builders.GameMap;
import g1304.Runner.Model.MovingObjects.MainCharacter;

import java.io.IOException;

public class GameViewer {
    TerminalScreen screen;
    TextGraphics graphics;

    MainCharacter mainCharacter;
    GameMap map;

    public void draw() {
        screen.clear();
        map.Draw(graphics);
        String[] drawing;

        drawing = mainCharacter.getCurrentSprite();
        int y = 0;
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

