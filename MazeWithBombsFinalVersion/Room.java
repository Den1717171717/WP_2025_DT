package org.den.WP_2025_DT.lab4.MazeWithBombsFinalVersion;
import java.awt.*;
import java.util.EnumSet;

public class Room extends MapSite {
    private EnumSet<Directions> walls = EnumSet.allOf(Directions.class);
    private int roomNumber;
    private boolean hasBomb;
    private boolean isDestroyed = false;
    private String label = "";

    public Room(int x, int y, int roomNumber, boolean hasBomb) {
        super(x, y);
        this.roomNumber = roomNumber;
        this.hasBomb = hasBomb;
    }

    public void setLabel(String label) { this.label = label; }
    public void removeWall(Directions d) { walls.remove(d); }
    public int getRoomNumber() { return roomNumber; }
    public void explode() { if (hasBomb) { isDestroyed = true; walls.clear(); } }
    public boolean isDestroyed() { return isDestroyed; }

    @Override
    public void draw(Graphics g) {
        int L = LENGTH;
        int x = getX();
        int y = getY();
        Graphics2D g2d = (Graphics2D) g;

        if (isDestroyed) g.setColor(new Color(230, 230, 230));
        else if (label.equals("ENTRY")) g.setColor(new Color(235, 255, 235));
        else if (label.equals("EXIT")) g.setColor(new Color(255, 235, 235));
        else g.setColor(Color.WHITE);
        g.fillRect(x, y, L, L);


        if (!isDestroyed) {
            g2d.setStroke(new BasicStroke(2));
            g.setColor(Color.BLACK);


            drawSmartWall(g2d, x, y, x + L, y, walls.contains(Directions.North), true);
            drawSmartWall(g2d, x, y + L, x + L, y + L, walls.contains(Directions.South), true);
            drawSmartWall(g2d, x + L, y, x + L, y + L, walls.contains(Directions.East), false);
            drawSmartWall(g2d, x, y, x, y + L, walls.contains(Directions.West), false);
        }

        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.PLAIN, 12));
        g.drawString(String.valueOf(roomNumber), x + 10, y + 20);

        if (hasBomb && !isDestroyed) {
            g.setColor(Color.RED);
            g.fillOval(x + L - 15, y + 10, 8, 8);
        }
    }

    private void drawSmartWall(Graphics2D g2d, int x1, int y1, int x2, int y2, boolean isFull, boolean isHoriz) {
        if (isFull) {
            g2d.drawLine(x1, y1, x2, y2);
        } else {
            int segment = LENGTH / 3;
            if (isHoriz) {
                g2d.drawLine(x1, y1, x1 + segment, y1);
                g2d.drawLine(x2 - segment, y2, x2, y2);
            } else {
                g2d.drawLine(x1, y1, x1, y1 + segment);
                g2d.drawLine(x2, y2 - segment, x2, y2);
            }
        }
    }
}