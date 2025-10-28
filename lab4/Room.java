package org.den.WP_2025_DT.lab4;

import java.awt.*;
import java.util.EnumSet;

enum Directions { North, East, South, West }
public class Room extends MapSite {
    private EnumSet<Directions> walls;

    public Room(int x, int y) {
        super(x, y);
        walls = EnumSet.allOf(Directions.class);
    }

    public void removeWall(Directions d) {
        walls.remove(d);
    }

    @Override
    public void draw(Graphics g) {
        for (Directions d : walls) {
            new Wall(getX(), getY(), d).draw(g);
        }
    }
}





