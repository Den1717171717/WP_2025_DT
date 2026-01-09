package org.den.WP_2025_DT.lab4.MazeWithBombsFinalVersion;
import java.awt.*;

public class Door extends MapSite {
    private Room r1, r2;
    private Directions dir;

    public Door(Room r1, Room r2, Directions dir) {
        super(0, 0);
        this.r1 = r1;
        this.r2 = r2;
        this.dir = dir;
    }

    @Override
    public void draw(Graphics g) {

    }

    public Room otherSideFrom(Room room) {
        if (room == r1) return r2;
        if (room == r2) return r1;
        return null;
    }
}