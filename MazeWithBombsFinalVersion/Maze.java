package org.den.WP_2025_DT.lab4.MazeWithBombsFinalVersion;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    private List<Room> rooms;

    public Maze() {
        rooms = new ArrayList<>();
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Room getRoom(int index) {
        return rooms.get(index);
    }
}
 enum Directions {
    North, East, South, West
}

