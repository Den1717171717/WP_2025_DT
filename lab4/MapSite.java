package org.den.WP_2025_DT.lab4;

public abstract class MapSite {
    public static final int LENGTH = 40; // rozmiar pokoju w px
    private int x;
    private int y;

    public MapSite(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public abstract void draw(java.awt.Graphics g);
}
