package g1304.Runner;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import g1304.Position;
import g1304.Runner.MovingObjects.Monsters.Slime;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GameMap {

    List<Wall> walls = new ArrayList<>();
    List<Slime> slimes = new ArrayList<>();
    String[] level1 = new String[]{"g1304.resources.level_1_map"};

    public void ReadElements() {
        String mapName = "level_1_map";
        String rootPath = new File(System.getProperty("user.dir")).getPath();
        String mapLocation = rootPath + "/project-l13gr04-master/src/main/java/g1304/resources/" + mapName;

        try {
            BufferedReader br = Files.newBufferedReader(Paths.get(mapLocation), Charset.defaultCharset());
            String line;

            int y = 0;
            while (((line = br.readLine()) != null)) {
                for (int x = 0; x < line.length(); x++) {
                    char currentChar = line.charAt(x);
                    if (currentChar == '#') {
                        Wall wall = new Wall(x*16, y*16);
                        walls.add(wall);
                    }
                    else if(currentChar == 'D') {
                        Slime slime = new Slime(new Position(x*16, y*16));
                        slimes.add(slime);
                    }
                }
                y++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SlimeController slimeController = new SlimeController(walls, slimes);
        slimeController.StartSlimes();
    }
    public void Draw(TextGraphics graphics) {
        for (Wall wall : walls) {
            for(int x = wall.getX(); x < wall.getX() + 16; x++) {
                for(int y = wall.getY(); y < wall.getY() + 16; y++) {
                    graphics.setBackgroundColor(TextColor.Factory.fromString("blue"));
                    graphics.fillRectangle(new TerminalPosition(x, y), new TerminalSize(1, 1), ' ');
                }
            }
        }


        String[] drawing = slimes.get(0).SlimeModel;
        for (Slime slime:slimes) {
            int y = 0;
            for(String s : drawing) {
                for (int x = 0; x < s.length(); x++) {
                    if (s.charAt(x) == '#') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("blue"));
                        graphics.fillRectangle(new TerminalPosition(slime.getX() + x, slime.getY() + y + 1), new TerminalSize(1, 1), ' ');
                    }
                    if (s.charAt(x) == 'W') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("white"));
                        graphics.fillRectangle(new TerminalPosition(slime.getX() + x, slime.getY() + y + 1), new TerminalSize(1, 1), ' ');
                    }
                    if (s.charAt(x) == 'R') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("red"));
                        graphics.fillRectangle(new TerminalPosition(slime.getX() + x, slime.getY() + y + 1), new TerminalSize(1, 1), ' ');
                    }

                    if (s.charAt(x) == 'X') {
                        graphics.setBackgroundColor(TextColor.Factory.fromString("green"));
                        graphics.fillRectangle(new TerminalPosition(slime.getX() + x, slime.getY() + y + 1), new TerminalSize(1, 1), ' ');
                    }
                }
                y++;
            }
            }


    }

    public List<Wall> GetWalls() {
        return walls;
    }
}
