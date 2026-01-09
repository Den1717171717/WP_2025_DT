package org.den.WP_2025_DT.lab4.MazeWithBombsFinalVersion;

import java.awt.*;

public class Wall extends MapSite {
    private Directions dir;

    public Wall(int x, int y, Directions dir) {
        super(x, y);
        this.dir = dir;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        ((Graphics2D)g).setStroke(new BasicStroke(6));
        int x = getX();
        int y = getY();
        int L = LENGTH;

        switch (dir) {
            case North -> g.drawLine(x, y, x + L, y);
            case South -> g.drawLine(x, y + L, x + L, y + L);
            case East  -> g.drawLine(x + L, y, x + L, y + L);
            case West  -> g.drawLine(x, y, x, y + L);
        }
        ((Graphics2D)g).setStroke(new BasicStroke(1));

    }
}