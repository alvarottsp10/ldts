package g1304.Runner.Model.Builders;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import g1304.Runner.Model.MovingObjects.Wall;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class WallViewer {
    String level1path = "g1304/resources/level_1_map";
    FileReader fileReader;


    public List<Wall> BuildWalls() {
        String mapName = "level_1_map";
        List<Wall> walls = new ArrayList<>();
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
                        }
                        y++;
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        return walls;

    }


    void drawWall(Wall wall, TextGraphics graphics) {
        for (int y = 0; y < 16; y++){
            for (int x = 0; x < 16; x++) {
                graphics.setBackgroundColor(TextColor.Factory.fromString("red"));
                graphics.fillRectangle(new TerminalPosition(wall.getX(), wall.getY()), new TerminalSize(1, 1), ' ');
            }
        }
    }



}
