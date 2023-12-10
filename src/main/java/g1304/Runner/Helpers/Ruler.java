package g1304.Runner.Helpers;

import g1304.Runner.MovingObjects.Position;

import static java.lang.Math.*;

public class Ruler {
     public int getDistance(Position pos1, Position pos2) {
         return (int) sqrt(pow(abs(pos1.getX() - pos2.getX()),2) + pow((abs(pos1.getY()) - pos2.getY()), 2));
     }
}
