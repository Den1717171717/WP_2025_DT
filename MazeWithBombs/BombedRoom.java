package org.den.WP_2025_DT.lab4.MazeWithBombs;

public class BombedRoom extends Room {
    public BombedRoom(int x, int y, int roomNumber) {
        super(x, y, roomNumber, true);
    }
}