package org.den.WP_2025_DT.lab4.MazeWithBombs;

import java.awt.*;

public class Door extends MapSite {
    private Room room1;
    private Room room2;
    private Directions directionFromRoom1;

    public Door(Room room1, Room room2, Directions directionFromRoom1) {
        super(0, 0);
        this.room1 = room1;
        this.room2 = room2;
        this.directionFromRoom1 = directionFromRoom1;
    }

    @Override
    public void draw(Graphics g) {
        int L = MapSite.LENGTH;
        int x1 = room1.getX();
        int y1 = room1.getY();

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(10));
        g2d.setColor(new Color(175, 104, 0));

        switch (directionFromRoom1) {
            case East -> g2d.drawLine(x1 + L, y1 + 20, x1 + L, y1 + L - 20);
            case West -> g2d.drawLine(x1, y1 + 20, x1, y1 + L - 20);
            case South -> g2d.drawLine(x1 + 20, y1 + L, x1 + L - 20, y1 + L);
            case North -> g2d.drawLine(x1 + 20, y1, x1 + L - 20, y1);
        }
        g2d.setStroke(new BasicStroke(1));
    }

    public Room otherSideFrom(Room room) {
        return room == room1 ? room2 : room1;
    }
}