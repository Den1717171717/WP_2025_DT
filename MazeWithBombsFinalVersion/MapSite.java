package org.den.WP_2025_DT.lab4.MazeWithBombsFinalVersion;

import java.awt.*;

public abstract class MapSite {
    public static final int LENGTH = 80;
    private int x, y;

    public MapSite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public abstract void draw(Graphics g);
}