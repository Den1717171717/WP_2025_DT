package org.den.WP_2025_DT.lab4.MazeWithBombsFinalVersion;

public class BombedMazeGameFactory extends MazeGameFactory {

    @Override
    public Room makeRoom(int roomNumber) {

        boolean hasBomb = Math.random() < 0.5;
        int col = (roomNumber - 1) % 5;
        int row = (roomNumber - 1) / 5;
        int x = col * MapSite.LENGTH + 40;
        int y = row * MapSite.LENGTH + 80;

        return hasBomb
                ? new BombedRoom(x, y, roomNumber)
                : new Room(x, y, roomNumber, false);
    }

    @Override
    public Wall makeWall() {

        return new Wall(0, 0, Directions.North);
    }

    @Override
    public Door makeDoor(Room r1, Room r2) {
        int dx = r2.getX() - r1.getX();
        int dy = r2.getY() - r1.getY();

        Directions dir;
        if (dx > 0)      dir = Directions.East;
        else if (dx < 0) dir = Directions.West;
        else if (dy > 0) dir = Directions.South;
        else             dir = Directions.North;

        return new Door(r1, r2, dir);
    }
}