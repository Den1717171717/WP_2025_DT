package org.den.WP_2025_DT.lab4.MazeWithBombs;
import java.awt.*;
import java.util.EnumSet;

public class Room extends MapSite {
    private EnumSet<Directions> walls;
    private Room connectedRoom;
    private int roomNumber;
    private boolean hasBomb; // Флаг для бомбы

    public Room(int x, int y, int roomNumber, boolean hasBomb) {
        super(x, y);
        this.roomNumber = roomNumber;
        this.hasBomb = hasBomb;
        walls = EnumSet.allOf(Directions.class);
    }

    public void removeWall(Directions d) {
        walls.remove(d); // Убираем стену в заданном направлении
    }

    public void setConnectedRoom(Room room) {
        this.connectedRoom = room;
    }

    public Room getConnectedRoom() {
        return connectedRoom;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean hasBomb() {
        return hasBomb;
    }

    @Override
    public void draw(Graphics g) {
        int L = LENGTH;
        int x = getX();
        int y = getY();

        g.setColor(Color.WHITE);
        g.fillRect(x + 3, y + 3, L - 6, L - 6);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setStroke(new BasicStroke(7));
        g.setColor(Color.BLACK);

        if (walls.contains(Directions.North))  g2d.drawLine(x, y, x + L, y);
        if (walls.contains(Directions.South))  g2d.drawLine(x, y + L, x + L, y + L);
        if (walls.contains(Directions.East))   g2d.drawLine(x + L, y, x + L, y + L);
        if (walls.contains(Directions.West))   g2d.drawLine(x, y, x, y + L);

        g2d.setStroke(new BasicStroke(1));


        g.setColor(Color.BLUE);
        g.setFont(new Font("SansSerif", Font.BOLD, 20));
        String num = String.valueOf(roomNumber);
        FontMetrics fm = g.getFontMetrics();
        int tx = x + (L - fm.stringWidth(num)) / 2;
        int ty = y + L/2 + 8;
        g.drawString(num, tx, ty);


        if (hasBomb) {
            g.setColor(Color.RED);
            int bs = L / 4;
            g.fillOval(x + (L - bs)/2, y + (L - bs)/2 + 10, bs, bs);
            g.setColor(Color.BLACK);
            g.drawOval(x + (L - bs)/2, y + (L - bs)/2 + 10, bs, bs);
        }
    }
}

