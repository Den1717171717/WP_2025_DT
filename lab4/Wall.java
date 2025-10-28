package org.den.WP_2025_DT.lab4;

import java.awt.*;

public class Wall extends MapSite {
    private Directions direction;

    public Wall(int x, int y, Directions d) {
        super(x, y);
        this.direction = d;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        int x = getX();
        int y = getY();
        int L = MapSite.LENGTH;

        switch (direction) {
            case North -> g.drawLine(x, y, x + L, y);
            case South -> g.drawLine(x, y + L, x + L, y + L);
            case East -> g.drawLine(x + L, y, x + L, y + L);
            case West -> g.drawLine(x, y, x, y + L);
        }
    }
}
